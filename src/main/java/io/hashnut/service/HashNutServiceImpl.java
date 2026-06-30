package io.hashnut.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.hashnut.client.HashNutClient;
import io.hashnut.client.HashNutClientResponse;
import io.hashnut.exception.HashNutException;
import io.hashnut.model.request.CancelOrderRequest;
import io.hashnut.model.request.ConfirmPaidRequest;
import io.hashnut.model.request.CreateOrderRequest;
import io.hashnut.model.request.QueryChainsRequest;
import io.hashnut.model.request.QueryCoinsRequest;
import io.hashnut.model.request.QueryOrderRequest;
import io.hashnut.model.request.Request;
import io.hashnut.model.response.CreateOrderResponse;
import io.hashnut.model.response.QueryChainsResponse;
import io.hashnut.model.response.QueryCoinsResponse;
import io.hashnut.model.response.QueryOrderResponse;
import io.hashnut.model.response.SingleResponse;

public class HashNutServiceImpl implements HashNutService {

    private final HashNutClient hashnutClient;
    private final ObjectMapper objectMapper;

    public HashNutServiceImpl(HashNutClient hashnutClient) {
        this(hashnutClient, defaultObjectMapper());
    }

    public HashNutServiceImpl(HashNutClient hashnutClient, ObjectMapper objectMapper) {
        this.hashnutClient = hashnutClient;
        this.objectMapper = objectMapper;
    }

    public <T> T request(Request<T> request) throws HashNutException {
        try {
            String payload = request.getPayload(objectMapper);
            HashNutClientResponse response = hashnutClient.request(request.getUri(), payload, request.needSign());
            if (!response.isSuccessful()) {
                throw new HashNutException("server handle request error :" + response.getCode() + ": " + response.getBody());
            }
            return buildResponse(request.getResponseClass(), response.getBody());
        } catch (HashNutException e) {
            throw e;
        } catch (Exception e) {
            throw new HashNutException(e.getMessage());
        }
    }

    private static <T> T buildResponse(Class<T> responseClass, String response) throws HashNutException {
        ObjectMapper mapper = defaultObjectMapper();
        try {
            JsonNode root = mapper.readTree(response);
            JsonNode codeNode = root.findValue("code");
            int code = codeNode == null ? 0 : codeNode.asInt();
            JsonNode msgNode = root.findValue("msg");
            String msg = msgNode == null ? "" : msgNode.asText();
            if (code != 0) {
                throw new HashNutException("server return error response: " + msg);
            }
            return mapper.convertValue(root, responseClass);
        } catch (HashNutException e) {
            throw e;
        } catch (Exception e) {
            throw new HashNutException(e.getMessage());
        }
    }

    private static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return mapper;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public QueryOrderResponse queryOrder(QueryOrderRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public SingleResponse confirmPaid(ConfirmPaidRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public SingleResponse cancelOrder(CancelOrderRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public QueryChainsResponse queryAllChainInfo(QueryChainsRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public QueryCoinsResponse queryAllCoinInfo(QueryCoinsRequest request) throws HashNutException {
        return request(request);
    }
}
