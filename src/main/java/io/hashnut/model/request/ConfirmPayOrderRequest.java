package io.hashnut.model.request;

import io.hashnut.model.response.SingleResponse;

public class ConfirmPayOrderRequest extends PostRequest<SingleResponse>{
    private final String payOrderId;
    private final String merchantOrderId;
    private final String accessSign;
    private final String payTxId;
    private final String chainCode;
    private final String payUUID;
    private final int txChannel;

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

    public String getPayUUID() {
        return payUUID;
    }

    public int getTxChannel() {
        return txChannel;
    }

    public ConfirmPayOrderRequest(Builder builder){
        this.payOrderId =builder.payOrderId;
        this.merchantOrderId =builder.merchantOrderId;
        this.accessSign =builder.accessSign;
        this.payTxId=builder.payTxId;
        this.chainCode=builder.chainCode;
        this.payUUID=builder.payUUID;
        this.txChannel=builder.txChannel;
    }

    @Override
    public String getUri() {
        return "/pay/confirmPayOrderPaid";
    }

    @Override
    public Class<SingleResponse> getResponseClass() {
        return SingleResponse.class;
    }

    public static class Builder{
        private String payOrderId;
        private String merchantOrderId;
        private String accessSign;
        private String payTxId;
        private String chainCode;
        private String payUUID;
        private int txChannel;

        public Builder(){

        }

        public Builder(String payOrderId,String merchantOrderId,String accessSign,String payTxId,String chainCode,String payUUID,int txChannel){
            this.payOrderId =payOrderId;
            this.merchantOrderId =merchantOrderId;
            this.accessSign =accessSign;
            this.payTxId=payTxId;
            this.chainCode=chainCode;
            this.payUUID=payUUID;
            this.txChannel=txChannel;
        }

        public Builder withPayOrderId(String payOrderId){
            this.payOrderId =payOrderId;
            return this;
        }

        public Builder withMerchantOrderId(String merchantOrderId){
            this.merchantOrderId =merchantOrderId;
            return this;
        }

        public Builder withAccessSign(String accessSign){
            this.accessSign =accessSign;
            return this;
        }

        public Builder withPayTxId(String payTxId){
            this.payTxId=payTxId;
            return this;
        }

        public Builder withChainCode(String chainCode){
            this.chainCode=chainCode;
            return this;
        }

        public Builder withPayUUID(String payUUID){
            this.payUUID=payUUID;
            return this;
        }

        public Builder withTxChannel(int txChannel){
            this.txChannel=txChannel;
            return this;
        }

        public ConfirmPayOrderRequest build(){
            return new ConfirmPayOrderRequest(this);
        }
    }
}
