package io.hashnut.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import io.hashnut.client.HashNutClient;
import io.hashnut.client.HashNutClientResponse;
import io.hashnut.exception.HashNutException;
import io.hashnut.model.request.*;
import io.hashnut.model.response.*;

import java.io.IOException;


public class HashNutServiceImpl implements HashNutService {

    private final HashNutClient hashnutClient;
    private final ObjectMapper objectMapper;
    public HashNutServiceImpl(HashNutClient hashnutClient) {
        this.hashnutClient = hashnutClient;
        this.objectMapper=new ObjectMapper();
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object paramT, JsonGenerator paramJsonGenerator,
                                  SerializerProvider paramSerializerProvider) throws IOException {
                paramJsonGenerator.writeString("");
            }
        });
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public <T> T request(Request<T> request) throws HashNutException {
        try {
            String payload = request.getPayload(objectMapper);
            String uri = request.getUri();
            HashNutClientResponse response = hashnutClient.request(uri,payload,request.needSign());
            if (response.isSuccessful()) {
                return buildResponse(request.getResponseClass(), response.getBody());
            } else {
                throw new HashNutException("server handle request error :" + response.getCode() + ": " + response.getBody());
            }
        } catch(Exception e) {
            throw new HashNutException(e.getMessage());
        }
    }

    private static <T> T buildResponse(Class<T> responseClass, String response) throws HashNutException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            // To ensure this can be converted from JSON properly we need to strip out the data and meta nodes
            JsonNode root = mapper.readTree(response);
            int code=root.findValue("code").asInt();
            String msg=root.findValue("msg").asText();
            if(code!=0)
                throw new HashNutException("server return error response: " + msg);
            return mapper.convertValue(root,responseClass);
        } catch (Exception e) {
            throw new HashNutException(e.getMessage());
        }
    }

    @Override
    public QueryCoinsResponse queryAllCoinInfo(QueryCoinsRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public QueryChainsResponse queryAllChainInfo(QueryChainsRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public QueryCoinsResponse querySupportCoin(QuerySupportCoinRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public QueryOrderResponse queryOrder(QueryOrderRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public CreatePayOrderResponse createPayOrder(CreatePayOrderRequest request) throws HashNutException {
        return request(request);
    }

    @Override
    public SingleResponse lockPayOrder(LockPayOrderRequest request) throws HashNutException{
        return request(request);
    }

    @Override
    public SingleResponse confirmPayOrder(ConfirmPayOrderRequest request) throws HashNutException {
        return request(request);
    }
}
