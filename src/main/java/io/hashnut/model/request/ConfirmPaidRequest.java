package io.hashnut.model.request;

import io.hashnut.model.response.SingleResponse;

public class ConfirmPaidRequest extends PostRequest<SingleResponse> {
    private final String payOrderId;
    private final String merchantOrderId;
    private final String accessSign;
    private final String payTxId;

    private ConfirmPaidRequest(Builder builder) {
        this.payOrderId = builder.payOrderId;
        this.merchantOrderId = builder.merchantOrderId;
        this.accessSign = builder.accessSign;
        this.payTxId = builder.payTxId;
    }

    public String getPayOrderId() {
        return payOrderId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public String getAccessSign() {
        return accessSign;
    }

    public String getPayTxId() {
        return payTxId;
    }

    @Override
    public String getUri() {
        return "/pay/orders/confirm";
    }

    @Override
    public Class<SingleResponse> getResponseClass() {
        return SingleResponse.class;
    }

    public static class Builder {
        private String payOrderId;
        private String merchantOrderId;
        private String accessSign;
        private String payTxId;

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

        public Builder withPayTxId(String payTxId) {
            this.payTxId = payTxId;
            return this;
        }

        public ConfirmPaidRequest build() {
            return new ConfirmPaidRequest(this);
        }
    }
}
