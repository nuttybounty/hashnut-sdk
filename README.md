# HashNut Java SDK

Java SDK for integrating with the HashNut Payment API V4.

## Maven

```xml
<dependency>
    <groupId>io.hashnut</groupId>
    <artifactId>io-hashnut-web3-sdk</artifactId>
    <version>4.0.0</version>
</dependency>
```

## Quick Start

```java
import io.hashnut.client.HashNutClient;
import io.hashnut.client.HashNutClientImpl;
import io.hashnut.model.HashNutOrder;
import io.hashnut.model.request.CreateOrderRequest;
import io.hashnut.model.response.CreateOrderResponse;
import io.hashnut.service.HashNutService;
import io.hashnut.service.HashNutServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        HashNutClient client = new HashNutClientImpl("your-secret-key", true);
        HashNutService service = new HashNutServiceImpl(client);

        CreateOrderResponse response = service.createOrder(new CreateOrderRequest.Builder()
                .withAccessKeyId("your-access-key-id")
                .withMerchantOrderId("order-001")
                .withMerchantChannel("default")
                .withBlockChain("TRON")
                .withTokenSymbol("usdt")
                .withAmount("10.00")
                .withSplitterAddress("your-v4-split-wallet-address")
                .withExpireDuration(600L)
                .withCallbackUrl("https://example.com/callback")
                .build());

        HashNutOrder order = response.getData();
        System.out.println(order.getPayOrderId());
        System.out.println(order.getReceiptAddress());
        System.out.println(order.getAccessSign());
    }
}
```

## Client

```java
HashNutClient testnetClient = new HashNutClientImpl(secretKey, true);
HashNutClient productionClient = new HashNutClientImpl(secretKey, false);
HashNutClient customClient = new HashNutClientImpl(secretKey, "https://custom.example.com/api/v4.0.0");
```

## APIs

### Create Order

```java
CreateOrderResponse response = service.createOrder(new CreateOrderRequest.Builder()
        .withAccessKeyId("your-access-key-id")
        .withMerchantOrderId("order-001")
        .withBlockChain("TRON")
        .withTokenSymbol("usdt")
        .withAmount("10.00")
        .withSplitterAddress("your-v4-split-wallet-address")
        .build());
```

This request is signed with the HMAC request headers.

### Query Order

```java
service.queryOrder(new QueryOrderRequest.Builder()
        .withPayOrderId("01ABC...")
        .withMerchantOrderId("order-001")
        .withAccessSign("access-sign-from-create-order")
        .build());
```

### Confirm Paid

```java
service.confirmPaid(new ConfirmPaidRequest.Builder()
        .withPayOrderId("01ABC...")
        .withMerchantOrderId("order-001")
        .withAccessSign("access-sign-from-create-order")
        .withPayTxId("blockchain-transaction-hash")
        .build());
```

### Cancel Order

```java
service.cancelOrder(new CancelOrderRequest.Builder()
        .withPayOrderId("01ABC...")
        .build());
```

This request is signed with the HMAC request headers.

### Query Chains And Coins

```java
service.queryAllChainInfo(new QueryChainsRequest.Builder().build());
service.queryAllCoinInfo(new QueryCoinsRequest.Builder().build());
```

## Signing

Signed requests automatically include:

| Header | Description |
| --- | --- |
| `hashnut-request-uuid` | Unique request ID |
| `hashnut-request-timestamp` | Unix millisecond timestamp |
| `hashnut-request-sign` | `Base64(HMAC-SHA256(secretKey, uuid + timestamp + body))` |

In V4, `createOrder` and `cancelOrder` use request-header signing. `queryOrder` and `confirmPaid` use the order `accessSign`.

## Environments

| Environment | Base URL |
| --- | --- |
| Production | `https://defi.hashnut.io/api/v4.0.0` |
| Testnet | `https://testnet.hashnut.io/api/v4.0.0` |
