package io.hashnut.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.hashnut.client.HashNutClient;
import io.hashnut.client.HashNutClientImpl;
import io.hashnut.exception.HashNutException;
import io.hashnut.model.*;
import io.hashnut.model.request.*;
import io.hashnut.model.response.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class ServiceTest {

    private HashNutClient hashnutClient;
    private HashNutService hashNutService;
    private final String chainCode="trc20";
    private final String coinCode="usdt";
    private final String merchantAddress="0x363C1E6160dd47Ae583D73Ff0087afcB52B9f082";
    private final String accessKeyId="01KKCFPKAY1TBJE3BJN0D9ERRF";
    private final String secretKey ="knZoxwkkKpbkNjJGwZGGEfZsRqAlsGqg";
    private final String splitterAddress="TAsXR6bKbNNQuCfvustbQfQi1mQbj2a5EV";

    @Before
    public void before(){
        hashnutClient = new HashNutClientImpl(secretKey, false);
        hashNutService = new HashNutServiceImpl(hashnutClient);
    }

    @Test
    public void queryChains() throws HashNutException {
        QueryChainsResponse response=hashNutService.queryAllChainInfo(new QueryChainsRequest.Builder().build());
        System.out.println("after build response " + System.currentTimeMillis());
        for(int i=0; i < response.getData().size();i ++){
            ChainInfo chainInfo=response.getData().get(i);
            System.out.println("chain info chain: " + chainInfo.getChain());
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
    public void createPayOrder() throws HashNutException {
        final String merchantOrderId = UUID.randomUUID().toString();
        BigDecimal amount=new BigDecimal("0.03");
        System.out.println("start " + new Date());
        CreatePayOrderResponse response = hashNutService.createPayOrder(new CreatePayOrderRequest.Builder()
                .withAccessKeyId(accessKeyId)
                .withMerchantOrderId(merchantOrderId)
                .withMerchantChannel("default")     // optional: default value: "default",if you want special you must configure in merchant web system
                .withChainCode(chainCode)
                .withCoinCode(coinCode)
                .withAmount(amount)
                .withSplitterAddress(splitterAddress)
                .withExpireDuration(300L)
                .withCustomCallBackUrl("https://shency-test.qa.jpushoa.com/pay-result")
                .build());
        System.out.println("end " + new Date());
        HashNutOrder order=response.getData();

        ObjectMapper objectMapper=new ObjectMapper();
        ObjectNode objectNode=objectMapper.createObjectNode();
        objectNode.put("payOrderId",order.getPayOrderId());
        objectNode.put("merchantOrderId",order.getMerchantOrderId());
        objectNode.put("accessSign",order.getAccessSign());
        objectNode.put("receiptAddress",order.getReceiptAddress());
        
        System.out.println(objectNode.toPrettyString());
    }

    @Test
    public void confirmPayOrderPaid() throws HashNutException {
        final String payOrderId="01KKCDTER7ET8Q2T2BPB6GD4SK";
        final String merchantOrderId="2dfa6685-1b42-4aae-8846-70ab30bc5080";
        final String accessSign="3B08148D3E3BD86F01818EFF4E35CA2DBFD6620F5C6CF7D6A44785CADAA9C0ED";
        final String payUUID = UUID.randomUUID().toString();
        final String payTxId="af7ba7264186407cc4dbcd8bbd27fd3b14d26cc9548c9e739ab1083590783d5e";
        SingleResponse response=hashNutService.confirmPayOrder(new ConfirmPayOrderRequest.Builder()
                .withPayOrderId(payOrderId)
                .withMerchantOrderId(merchantOrderId)
                .withAccessSign(accessSign)
                .withPayTxId(payTxId)
                .withPayUUID(payUUID)
                .withChainCode(chainCode)
                .withTxChannel(0)
                .build());
        System.out.println("resultCode " + response.code);
        System.out.println("resultMsg " + response.msg);
    }

    @Test
    public void queryOrder() throws HashNutException {
        final String payOrderId="01KCXRSGPH6W0WJZ9AKMBEVE5A";
        final String mchOrderNo="8e267d36-5ad6-4514-b37d-da24f22a7b9e";
        final String accessSign="3868249EB79ABC0C34A2D391B6CBA81E1551B5B5D13B354A790A3571F2C65EA9";

        QueryOrderResponse response=hashNutService.queryOrder(new QueryOrderRequest.Builder()
                .withPayOrderId(payOrderId)
                .withMerchantOrderId(mchOrderNo)
                .withAccessSign(accessSign)
                .build());
        HashNutOrder order=response.getData();
        System.out.println("get order payOrderId: " + order.getPayOrderId());
        System.out.println("get order merchantOrderId: " + order.getMerchantOrderId());
        System.out.println("get order accessSign: " + order.getAccessSign());
        System.out.println("get order amount: " + order.getAmount());
        System.out.println("get order state: " + OrderState.toString(order.getState()));
    }
}
