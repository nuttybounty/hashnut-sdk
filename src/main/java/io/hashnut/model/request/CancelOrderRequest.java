package io.hashnut.model.request;

import io.hashnut.model.response.SingleResponse;

public class CancelOrderRequest extends PostRequest<SingleResponse> {
    private final String payOrderId;

    private CancelOrderRequest(Builder builder) {
        this.payOrderId = builder.payOrderId;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    @Override
    public boolean needSign() {
        return true;
    }

    @Override
    public String getUri() {
        return "/pay/orders/cancel/api";
    }

    @Override
    public Class<SingleResponse> getResponseClass() {
        return SingleResponse.class;
    }

    public static class Builder {
        private String payOrderId;

        public Builder withPayOrderId(String payOrderId) {
            this.payOrderId = payOrderId;
            return this;
        }

        public CancelOrderRequest build() {
            return new CancelOrderRequest(this);
        }
    }
}
