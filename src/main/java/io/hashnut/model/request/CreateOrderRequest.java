package io.hashnut.model.request;

import io.hashnut.model.response.CreateOrderResponse;

import java.math.BigDecimal;

public class CreateOrderRequest extends PostRequest<CreateOrderResponse> {
    private final String accessKeyId;
    private final String merchantOrderId;
    private final String merchantChannel;
    private final String blockChain;
    private final String tokenSymbol;
    private final String amount;
    private final String splitterAddress;
    private final String subject;
    private final String remark;
    private final String param1;
    private final String param2;
    private final String callbackUrl;
    private final String extra;
    private final Long expireDuration;
    private final Integer payWebType;

    private CreateOrderRequest(Builder builder) {
        this.accessKeyId = builder.accessKeyId;
        this.merchantOrderId = builder.merchantOrderId;
        this.merchantChannel = builder.merchantChannel;
        this.blockChain = builder.blockChain;
        this.tokenSymbol = builder.tokenSymbol;
        this.amount = builder.amount;
        this.splitterAddress = builder.splitterAddress;
        this.subject = builder.subject;
        this.remark = builder.remark;
        this.param1 = builder.param1;
        this.param2 = builder.param2;
        this.callbackUrl = builder.callbackUrl;
        this.extra = builder.extra;
        this.expireDuration = builder.expireDuration;
        this.payWebType = builder.payWebType;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public String getMerchantChannel() {
        return merchantChannel;
    }

    public String getBlockChain() {
        return blockChain;
    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }

    public String getAmount() {
        return amount;
    }

    public String getSplitterAddress() {
        return splitterAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getRemark() {
        return remark;
    }

    public String getParam1() {
        return param1;
    }

    public String getParam2() {
        return param2;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public String getExtra() {
        return extra;
    }

    public Long getExpireDuration() {
        return expireDuration;
    }

    public Integer getPayWebType() {
        return payWebType;
    }

    @Override
    public boolean needSign() {
        return true;
    }

    @Override
    public String getUri() {
        return "/api/orders/create";
    }

    @Override
    public Class<CreateOrderResponse> getResponseClass() {
        return CreateOrderResponse.class;
    }

    public static class Builder {
        private String accessKeyId;
        private String merchantOrderId;
        private String merchantChannel;
        private String blockChain;
        private String tokenSymbol;
        private String amount;
        private String splitterAddress;
        private String subject;
        private String remark;
        private String param1;
        private String param2;
        private String callbackUrl;
        private String extra;
        private Long expireDuration;
        private Integer payWebType;

        public Builder withAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        public Builder withMerchantOrderId(String merchantOrderId) {
            this.merchantOrderId = merchantOrderId;
            return this;
        }

        public Builder withMerchantChannel(String merchantChannel) {
            this.merchantChannel = merchantChannel;
            return this;
        }

        public Builder withBlockChain(String blockChain) {
            this.blockChain = blockChain;
            return this;
        }

        public Builder withTokenSymbol(String tokenSymbol) {
            this.tokenSymbol = tokenSymbol;
            return this;
        }

        public Builder withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount == null ? null : amount.toPlainString();
            return this;
        }

        public Builder withSplitterAddress(String splitterAddress) {
            this.splitterAddress = splitterAddress;
            return this;
        }

        public Builder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder withRemark(String remark) {
            this.remark = remark;
            return this;
        }

        public Builder withParam1(String param1) {
            this.param1 = param1;
            return this;
        }

        public Builder withParam2(String param2) {
            this.param2 = param2;
            return this;
        }

        public Builder withCallbackUrl(String callbackUrl) {
            this.callbackUrl = callbackUrl;
            return this;
        }

        public Builder withExtra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder withExpireDuration(Long expireDuration) {
            this.expireDuration = expireDuration;
            return this;
        }

        public Builder withPayWebType(Integer payWebType) {
            this.payWebType = payWebType;
            return this;
        }

        public CreateOrderRequest build() {
            return new CreateOrderRequest(this);
        }
    }
}
