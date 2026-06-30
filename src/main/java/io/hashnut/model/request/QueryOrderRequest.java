package io.hashnut.model.request;

import io.hashnut.model.response.QueryOrderResponse;

public class QueryOrderRequest extends PostRequest<QueryOrderResponse> {
    private final String payOrderId;
    private final String merchantOrderId;
    private final String accessSign;

    public String getPayOrderId() {
        return payOrderId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public String getAccessSign() {
        return accessSign;
    }

    private QueryOrderRequest(Builder builder) {
        this.payOrderId = builder.payOrderId;
        this.merchantOrderId = builder.merchantOrderId;
        this.accessSign=builder.accessSign;
    }

    @Override
    public String getUri() {
        return "/pay/orders/query";
    }

    @Override
    public Class<QueryOrderResponse> getResponseClass() {
        return QueryOrderResponse.class;
    }
    public static class Builder {
        private String payOrderId;
        private String merchantOrderId;
        private String accessSign;

        public Builder(){

        }

        public Builder(String payOrderId,String merchantOrderId,String accessSign) {
            this.payOrderId = payOrderId;
            this.merchantOrderId = merchantOrderId;
            this.accessSign = accessSign;
        }

        public Builder withPayOrderId(String payOrderId) {
            this.payOrderId = payOrderId;
            return this;
        }

        public Builder withMerchantOrderId(String merchantOrderId) {
            this.merchantOrderId = merchantOrderId;
            return this;
        }

        public Builder withAccessSign(String accessSign) {
            this.accessSign = accessSign;
            return this;
        }

        public QueryOrderRequest build() {
            return new QueryOrderRequest(this);
        }
    }
}
