package io.hashnut.model.request;

import io.hashnut.model.response.SingleResponse;

public class ConfirmPaidRequest extends PostRequest<SingleResponse> {
    private final String payOrderId;
    private final String merchantOrderId;
    private final String accessSign;
    private final String payTxId;
    private final String chainCode;

    private ConfirmPaidRequest(Builder builder) {
        this.payOrderId = builder.payOrderId;
        this.merchantOrderId = builder.merchantOrderId;
        this.accessSign = builder.accessSign;
        this.payTxId = builder.payTxId;
        this.chainCode = builder.chainCode;
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

    public String getChainCode() {
        return chainCode;
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
        private String chainCode;

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

        public Builder withChainCode(String chainCode) {
            this.chainCode = chainCode;
            return this;
        }

        public ConfirmPaidRequest build() {
            return new ConfirmPaidRequest(this);
        }
    }
}
