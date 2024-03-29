package io.hashnut.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.hashnut.client.HashNutClient;
import io.hashnut.client.HashNutClientImpl;
import io.hashnut.exception.HashNutException;
import io.hashnut.model.*;
import io.hashnut.model.request.*;
import io.hashnut.model.response.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class ServiceTest {

    private HashNutClient hashnutClient;
    private HashNutService hashNutService;
    private final String chain="ETH";;
    private final String chainCode="erc20";
    private final String coinCode="usdt";
    private final int serviceType=0;
    private final String serviceVersion="PaymentSplitterV1_1";
    private final int serviceId=1;
    private final String mchAddress="0xe1fd94f8874d698567e03f671a8c62e4e2e4be90";
    private final String accessKeyId="ACC_1156690317534035968";
    private final String requestKey="JgsnNZqgtZttxHwzbLe4ZxstQwqLXHH4";
    private final String responseKey="CetlG87d3CPPTCQ48PgGoPCoR3tCx4R4";
    private final String receiptAddress="0x46eC57d48154C9de11ff430D5D1c6037a85AbA96".toLowerCase();

    @Before
    public void before(){
        hashnutClient = new HashNutClientImpl(requestKey, responseKey, true);
        hashNutService = new HashNutServiceImpl(hashnutClient);
    }

    @Test
    public void queryChains() throws HashNutException {
        QueryChainsResponse response=hashNutService.queryAllChainInfo(new QueryChainsRequest.Builder().build());
        System.out.println("after build response " + System.currentTimeMillis());
        for(int i=0; i < response.getData().size();i ++){
            ChainInfo chainInfo=response.getData().get(i);
            System.out.println("coin info chainCode: " + chainInfo.getChainCode());
        }
    }

    @Test
    public void queryCoins() throws HashNutException {
        QueryCoinsResponse response=hashNutService.queryAllCoinInfo(new QueryCoinsRequest.Builder().build());
        System.out.println("after build response " + System.currentTimeMillis());
        for(int i=0; i < response.getData().size();i ++){
            CoinInfo coinInfo=response.getData().get(i);
            System.out.println("coin info chainCode: " + coinInfo.getChainCode());
            System.out.println("coin info coinCode: " + coinInfo.getCoinCode());
        }
    }

    @Test
    public void querySupportCoinsByChainCode() throws HashNutException {
        QueryCoinsResponse response=hashNutService.querySupportCoin(new QuerySupportCoinRequest.Builder()
                .withChainCode("erc20").build());
        for(CoinInfo coinInfo:response.getData()){
            System.out.println("coin info coinCode: " + coinInfo.getCoinCode());
        }
    }

    @Test
    public void querySupportLegalTenders() throws HashNutException {
        QueryFiatsResponse response=hashNutService.queryFiatsRequest(new QueryFiatsRequest.Builder().build());
        for(FiatInfo legalTender:response.getData()){
            System.out.println(legalTender);
        }
    }

    @Test
    public void queryFiatExchangeRate() throws HashNutException {
        QueryFiatRateResponse response=hashNutService.queryFiatRate(new QueryFiatRateRequest.Builder()
                .withBaseCoin("usdt")
                .withQuoteCoin("HKD")
                .withChainCode("erc20")
                .build());
        FiatExchangeRate rate=response.getData();
        System.out.println("rate is " + rate);
    }

    @Test
    public void createOrder() throws HashNutException {

        final String mchOrderNo = UUID.randomUUID().toString();
        BigDecimal amountD=new BigDecimal("10.1");
        BigInteger amount=amountD.multiply(BigDecimal.TEN.pow(6)).toBigInteger();

        CreateOrderResponse response = hashNutService.createOrder(new CreateOrderRequest.Builder()
                .withChain(chain)
                .withChainCode(chainCode)
                .withCoinCode(coinCode)
                .withMchAddress(mchAddress)
                .withMchOrderNo(mchOrderNo)
                .withAccessKeyId(accessKeyId)
                .withAccessChannel(0)
                .withAmount(amount.toString())
                .withReceiptContractAddress(receiptAddress)
                .withServiceType(serviceType)
                .withServiceId(serviceId)
                .withServiceVersion(serviceVersion)
                .build());
        HashNutOrder order=response.getData();
        System.out.println("create order : " + order);
        System.out.println("create order platformId: " + order.getPlatformId());
        System.out.println("create order mchOrderNo: " + order.getMchOrderId());
        System.out.println("create order accessSign: " + order.getAccessSign());
        System.out.println("create order receiptAddress: " + order.getReceiptAddress());
    }

    @Test
    public void lockOrder() throws HashNutException {
        final String platformId="PAY_1162379934253973504";
        final String mchOrderNo="e079182d-f0a5-4679-85a0-9bb61b8067e7";
        final String accessSign="7ED491C02EBFBA2D58EF2C5E8366BAD1DDE8E8C679E5E4FEB6D82641C745EEAC";
        final String payUUID = UUID.randomUUID().toString();
        SingleResponse response=hashNutService.lockPayOrder(new LockPayOrderRequest.Builder()
                .withPlatformId(platformId)
                .withMchOrderNo(mchOrderNo)
                .withAccessSign(accessSign)
                .withPayUUID(payUUID)
                .build());
        System.out.println("resultCode " + response.resultCode);
        System.out.println("resultMsg " + response.resultMsg);
    }

    @Test
    public void confirmPayOrderPaid() throws HashNutException {
        final String platformId="PAY_1162379934253973504";
        final String mchOrderNo="e079182d-f0a5-4679-85a0-9bb61b8067e7";
        final String accessSign="7ED491C02EBFBA2D58EF2C5E8366BAD1DDE8E8C679E5E4FEB6D82641C745EEAC";
        final String payUUID = UUID.randomUUID().toString();
        final String payTxId="0x052708441397ae47186977ffab79d655e9a2feed920cd345e20049060f465192";
        SingleResponse response=hashNutService.confirmPayOrder(new ConfirmPayOrderRequest.Builder()
                .withPlatformId(platformId)
                .withMchOrderNo(mchOrderNo)
                .withAccessSign(accessSign)
                .withPayTxId(payTxId)
                .withPayUUID(payUUID)
                .withChainCode(chainCode)
                .withTxChannel(0)
                .build());

        System.out.println("resultCode " + response.resultCode);
        System.out.println("resultMsg " + response.resultMsg);
    }

    @Test
    public void queryOrder() throws HashNutException {
        final String platformId="PAY_1162379934253973504";
        final String mchOrderNo="e079182d-f0a5-4679-85a0-9bb61b8067e7";
        final String accessSign="7ED491C02EBFBA2D58EF2C5E8366BAD1DDE8E8C679E5E4FEB6D82641C745EEAC";

        QueryOrderResponse response=hashNutService.queryOrder(new QueryOrderRequest.Builder()
                .withPlatformId(platformId)
                .withMchOrderNo(mchOrderNo)
                .withAccessSign(accessSign)
                .build());
        HashNutOrder order=response.getData();
        System.out.println("get order platformId: " + order.getPlatformId());
        System.out.println("get order state: " + OrderState.toString(order.getState()));
    }

    @Test
    public void testDeserializeOrder() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // 忽略未知属性
        String json="{\"mchAddress\":\"0xe1fd94f8874d698567e03f671a8c62e4e2e4be90\",\"chain\":\"ETH\",\"chainCode\":\"erc20\",\"coinCode\":\"usdt\",\"createChannel\":1,\"accessChannel\":0,\"mchOrderId\":\"e47572f5-edc4-44c9-83c8-87a4771e6dfa\",\"platformId\":\"PAY_1161766851714220032\",\"contractAddress\":\"0xe2d7250b2ec3cd208ac5b42886edd162411529c4\",\"receiptAddress\":\"0x46ec57d48154c9de11ff430d5d1c6037a85aba96\",\"amount\":10100000,\"state\":0,\"accessSign\":\"8BB94A0CA9904147609CA933FE1DB6038732D9ED6CDEF4E0727BDC402373213E\",\"confirmCount\":0,\"genNftState\":0,\"genNftConfirmCount\":0,\"mintNftState\":0,\"mintNftConfirmCount\":0,\"walletConnectEnable\":true,\"bridgeServerAddress\":\"https://bridge.hashnut.io\",\"eip712ChainId\":1,\"chainId\":11155111,\"createTime\":0,\"expireDuration\":0}";

        HashNutOrder order=objectMapper.readValue(json,HashNutOrder.class);
        System.out.println("order is " + order);
    }
}
