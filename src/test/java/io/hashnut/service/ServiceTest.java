package io.hashnut.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hashnut.authentication.Authentication;
import io.hashnut.client.HashNutClient;
import io.hashnut.client.HashNutClientResponse;
import io.hashnut.exception.HashNutException;
import io.hashnut.model.OrderState;
import io.hashnut.model.request.CancelOrderRequest;
import io.hashnut.model.request.ConfirmPaidRequest;
import io.hashnut.model.request.CreateOrderRequest;
import io.hashnut.model.request.QueryChainsRequest;
import io.hashnut.model.request.QueryCoinsRequest;
import io.hashnut.model.request.QueryOrderRequest;
import io.hashnut.model.response.CreateOrderResponse;
import io.hashnut.model.response.QueryChainsResponse;
import io.hashnut.model.response.QueryCoinsResponse;
import io.hashnut.model.response.QueryOrderResponse;
import io.hashnut.model.response.SingleResponse;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    @Test
    public void createOrderUsesV4SignedEndpointAndPayload() throws Exception {
        StubClient client = new StubClient("{\"code\":0,\"msg\":\"success\",\"data\":{\"payOrderId\":\"P001\",\"merchantOrderId\":\"M001\",\"amount\":\"10.00\",\"receiptAddress\":\"T123\",\"accessSign\":\"A001\",\"customCallBackUrl\":\"https://example.com/callback\"}}");
        HashNutService service = new HashNutServiceImpl(client);

        CreateOrderResponse response = service.createOrder(new CreateOrderRequest.Builder()
                .withAccessKeyId("AK001")
                .withMerchantOrderId("M001")
                .withMerchantChannel("default")
                .withChainCode("trc20")
                .withCoinCode("usdt")
                .withAmount(new BigDecimal("10.00"))
                .withSplitterAddress("T_SPLITTER")
                .withCallbackUrl("https://example.com/callback")
                .withExpireDuration(600L)
                .build());

        assertThat(client.uri).isEqualTo("/pay/orders/api");
        assertThat(client.needSign).isTrue();
        JsonNode payload = new ObjectMapper().readTree(client.body);
        assertThat(payload.get("amount").asText()).isEqualTo("10.00");
        assertThat(payload.get("splitterAddress").asText()).isEqualTo("T_SPLITTER");
        assertThat(payload.get("customCallBackUrl").asText()).isEqualTo("https://example.com/callback");
        assertThat(payload.has("payWebType")).isFalse();
        assertThat(response.getData().getPayOrderId()).isEqualTo("P001");
        assertThat(response.getData().getCustomCallBackUrl()).isEqualTo("https://example.com/callback");
    }

    @Test
    public void queryAndConfirmUseAccessSignWithoutHeaderSignature() throws HashNutException {
        StubClient queryClient = new StubClient("{\"code\":0,\"msg\":\"success\",\"data\":{\"payOrderId\":\"P001\",\"merchantOrderId\":\"M001\",\"state\":3}}");
        HashNutService queryService = new HashNutServiceImpl(queryClient);

        QueryOrderResponse queryResponse = queryService.queryOrder(new QueryOrderRequest.Builder()
                .withPayOrderId("P001")
                .withMerchantOrderId("M001")
                .withAccessSign("ACCESS_SIGN")
                .build());

        assertThat(queryClient.uri).isEqualTo("/pay/orders/query");
        assertThat(queryClient.needSign).isFalse();
        assertThat(queryResponse.getData().getState()).isEqualTo(OrderState.SUCCESS);

        StubClient confirmClient = new StubClient("{\"code\":0,\"msg\":\"success\"}");
        HashNutService confirmService = new HashNutServiceImpl(confirmClient);
        SingleResponse confirmResponse = confirmService.confirmPaid(new ConfirmPaidRequest.Builder()
                .withPayOrderId("P001")
                .withMerchantOrderId("M001")
                .withAccessSign("ACCESS_SIGN")
                .withPayTxId("TX001")
                .withChainCode("trc20")
                .build());

        assertThat(confirmClient.uri).isEqualTo("/pay/orders/confirm");
        assertThat(confirmClient.needSign).isFalse();
        assertThat(confirmResponse.getCode()).isZero();
    }

    @Test
    public void cancelOrderUsesSignedV4Endpoint() throws HashNutException {
        StubClient client = new StubClient("{\"code\":0,\"msg\":\"success\"}");
        HashNutService service = new HashNutServiceImpl(client);

        SingleResponse response = service.cancelOrder(new CancelOrderRequest.Builder()
                .withPayOrderId("P001")
                .build());

        assertThat(client.uri).isEqualTo("/pay/orders/cancel/api");
        assertThat(client.needSign).isTrue();
        assertThat(response.getCode()).isZero();
    }

    @Test
    public void configQueriesUseV4Endpoints() throws HashNutException {
        StubClient chainsClient = new StubClient("{\"code\":0,\"msg\":\"success\",\"data\":[{\"chain\":\"TRON\",\"chainCode\":\"trc20\",\"EIP1559Support\":false}]}");
        HashNutService chainsService = new HashNutServiceImpl(chainsClient);
        QueryChainsResponse chainsResponse = chainsService.queryAllChainInfo(new QueryChainsRequest.Builder().build());

        assertThat(chainsClient.uri).isEqualTo("/config/chains");
        assertThat(chainsClient.needSign).isFalse();
        assertThat(chainsResponse.getData()).hasSize(1);

        StubClient coinsClient = new StubClient("{\"code\":0,\"msg\":\"success\",\"data\":[{\"chain\":\"TRON\",\"chainCode\":\"trc20\",\"coinCode\":\"usdt\",\"isToken\":true}]}");
        HashNutService coinsService = new HashNutServiceImpl(coinsClient);
        QueryCoinsResponse coinsResponse = coinsService.queryAllCoinInfo(new QueryCoinsRequest.Builder().build());

        assertThat(coinsClient.uri).isEqualTo("/config/coins");
        assertThat(coinsClient.needSign).isFalse();
        assertThat(coinsResponse.getData()).hasSize(1);
        assertThat(coinsResponse.getData().get(0).getToken()).isTrue();
    }

    @Test
    public void hmacSignatureMatchesExpectedValue() throws Exception {
        Authentication authentication = new Authentication("secret");

        String sign = authentication.generateHashNutSign("uuid", 1700000000000L, "{\"payOrderId\":\"P001\"}");

        assertThat(sign).isEqualTo("hbl1Sp0GRGCrmJH2eTlXdKg/znU4Yrwj+SEc7TDXAoo=");
    }

    private static final class StubClient implements HashNutClient {
        private final String responseBody;
        private String uri;
        private String body;
        private boolean needSign;

        private StubClient(String responseBody) {
            this.responseBody = responseBody;
        }

        @Override
        public HashNutClientResponse request(String uri, String body, boolean needSign) {
            this.uri = uri;
            this.body = body;
            this.needSign = needSign;
            return new HashNutClientResponse(200, responseBody);
        }
    }
}
