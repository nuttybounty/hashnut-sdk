package io.hashnut.model.request;

import java.math.BigDecimal;
import io.hashnut.model.response.CreatePayOrderResponse;

public class CreatePayOrderRequest extends PostRequest<CreatePayOrderResponse> {
    private String accessKeyId;
    private String merchantOrderId;
    private String merchantChannel;
    private String chainCode;
    private String coinCode;
    private BigDecimal amount;
    private String splitterAddress;
    private String subject;
    private String remark;
    private String param1;
    private String param2;
    private String customCallBackUrl;
    private String extra;
    private Long expireDuration;
    private Integer payWebType;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public String getMerchantChannel() {
        return merchantChannel;
    }

    public String getChainCode() {
        return chainCode;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public BigDecimal getAmount() {
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

    public String getCustomCallBackUrl() {
        return customCallBackUrl;
    }

    public String getExtra() {
        return extra;
    }

    public Long getExpireDuration() {
        return expireDuration;
    }

    public void setExpireDuration(Long expireDuration) {
        this.expireDuration = expireDuration;
    }

    public Integer getPayWebType() {
        return payWebType;
    }

    public void setPayWebType(Integer payWebType) {
        this.payWebType = payWebType;
    }

    protected CreatePayOrderRequest(Builder builder) {
        this.accessKeyId = builder.accessKeyId;
        this.merchantOrderId = builder.merchantOrderId;
        this.merchantChannel= builder.merchantChannel;
        this.chainCode = builder.chainCode;
        this.coinCode = builder.coinCode;
        this.amount = builder.amount;
        this.splitterAddress = builder.splitterAddress;
        this.subject = builder.subject;
        this.remark = builder.remark;
        this.param1 = builder.param1;
        this.param2 = builder.param2;
        this.customCallBackUrl = builder.customCallBackUrl;
        this.extra = builder.extra;
        this.expireDuration=builder.expireDuration;
        this.payWebType=builder.payWebType;
    }

    @Override
    public boolean needSign(){return true;}

    @Override
    public String getUri() {
        return "/pay/createPayOrderOnSplitWalletWithApiKey";
    }

    @Override
    public Class<CreatePayOrderResponse> getResponseClass() {
        return CreatePayOrderResponse.class;
    }

    public static class Builder {
        private String accessKeyId;
        private String merchantOrderId;
        private String merchantChannel;
        private String chainCode;
        private String coinCode;
        private BigDecimal amount;
        private String splitterAddress;
        private String subject;
        private String remark;
        private String param1;
        private String param2;
        private String customCallBackUrl;
        private String extra;
        private Long expireDuration;
        private Integer payWebType;
        public Builder(){

        }
        public Builder(
                String accessKeyId,
                String merchantOrderId,
                String merchantChannel,
                String chainCode,
                String coinCode,
                BigDecimal amount,
                String receiptAddress,
                String subject,
                String remark,
                String param1,
                String param2,
                String customCallBackUrl,
                String extra,
                Long expireDuration,
                Integer payWebType) {
            this.accessKeyId = accessKeyId;
            this.merchantOrderId = merchantOrderId;
            this.merchantChannel = merchantChannel;
            this.chainCode = chainCode;
            this.coinCode = coinCode;
            this.amount = amount;
            this.splitterAddress = receiptAddress;
            this.subject = subject;
            this.remark = remark;
            this.param1 = param1;
            this.param2 = param2;
            this.customCallBackUrl = customCallBackUrl;
            this.extra = extra;
            this.expireDuration=expireDuration;
            this.payWebType=payWebType;
        }

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

        public Builder withChainCode(String chainCode) {
            this.chainCode = chainCode;
            return this;
        }

        public Builder withCoinCode(String coinCode) {
            this.coinCode = coinCode;
            return this;
        }

        public Builder withAmount(BigDecimal amount) {
            this.amount = amount;
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

        public Builder withCustomCallBackUrl(String customCallBackUrl) {
            this.customCallBackUrl = customCallBackUrl;
            return this;
        }

        public Builder withExtra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder withExpireDuration(Long expireDuration){
            this.expireDuration=expireDuration;
            return this;
        }

        public Builder withIntegerWeb(Integer payWebType){
            this.payWebType=payWebType;
            return this;
        }

        public CreatePayOrderRequest build() {
            return new CreatePayOrderRequest(this);
        }
    }
}
