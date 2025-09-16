package io.hashnut.model.request;

import java.math.BigDecimal;
import io.hashnut.model.response.CreatePassThroughOrderResponse;

public class CreatePassThroughOrderRequest extends PostRequest<CreatePassThroughOrderResponse> {
    private String accessKeyId;
    private String merchantOrderId;
    private String chainCode;
    private String coinCode;
    private BigDecimal amount;
    private String splitterAddress;
    private String subject;
    private String remark;
    private String param1;
    private String param2;
    private Boolean customCallBackUrl;
    private String extra;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
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

    public Boolean getCustomCallBackUrl() {
        return customCallBackUrl;
    }

    public String getExtra() {
        return extra;
    }

    protected CreatePassThroughOrderRequest(Builder builder) {
        this.accessKeyId = builder.accessKeyId;
        this.merchantOrderId = builder.merchantOrderId;
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
    }

    @Override
    public boolean needSign(){return true;}

    @Override
    public String getUri() {
        return "/pay/createPassThroughPayOrderWithApiKey";
    }

    @Override
    public Class<CreatePassThroughOrderResponse> getResponseClass() {
        return CreatePassThroughOrderResponse.class;
    }

    public static class Builder {
        private String accessKeyId;
        private String merchantOrderId;
        private String chainCode;
        private String coinCode;
        private BigDecimal amount;
        private String splitterAddress;
        private String subject;
        private String remark;
        private String param1;
        private String param2;
        private Boolean customCallBackUrl;
        private String extra;
        public Builder(){

        }
        public Builder(
                String accessKeyId,
                String mchOrderNo,
                String chainCode,
                String coinCode,
                BigDecimal amount,
                String receiptAddress,
                String subject,
                String remark,
                String param1,
                String param2,
                Boolean customCallBackUrl,
                String extra) {
            this.accessKeyId = accessKeyId;
            this.merchantOrderId = mchOrderNo;
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
        }

        public Builder withAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
            return this;
        }

        public Builder withMerchantOrderId(String merchantOrderId) {
            this.merchantOrderId = merchantOrderId;
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

        public Builder withCustomCallBackUrl(Boolean customCallBackUrl) {
            this.customCallBackUrl = customCallBackUrl;
            return this;
        }

        public Builder withExtra(String extra) {
            this.extra = extra;
            return this;
        }

        public CreatePassThroughOrderRequest build() {
            return new CreatePassThroughOrderRequest(this);
        }
    }
}
