package io.hashnut.model;

import java.math.BigDecimal;
import java.util.Date;

public class HashNutOrder {
    private String payOrderId;
    private String blockChain;
    private String merchantAddress;
    private String merchantOrderId;
    private String merchantChannel;
    private String tokenSymbol;
    private Integer createChannel;
    private String payTxId;
    private Integer rate;
    private BigDecimal amount;
    private BigDecimal obtainAmount;
    private BigDecimal platformFee;
    private Long confirmCount;
    private Integer state;
    private String subject;
    private String remarkInfo;
    private String extra;
    private String param1;
    private String param2;
    private String accessKeyId;
    private String accessSign;
    private Long payTxHeight;
    private String payAddress;
    private String receiptAddress;
    private String payUrl;
    private String callbackUrl;
    private String errorCode;
    private String errorMsg;
    private Long expireTime;
    private Long confirmPayTime;
    private Long paySuccessTime;
    private Long finishTime;
    private Integer notifyCount;
    private Integer notifyState;
    private String notifyResult;
    private Integer queryTxCount;
    private Long nextQueryTxTime;
    private Date createTime;
    private Date updateTime;

    public String getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(String payOrderId) {
        this.payOrderId = payOrderId;
    }

    public String getBlockChain() {
        return blockChain;
    }

    public void setBlockChain(String blockChain) {
        this.blockChain = blockChain;
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public String getMerchantChannel() {
        return merchantChannel;
    }

    public void setMerchantChannel(String merchantChannel) {
        this.merchantChannel = merchantChannel;
    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }

    public void setTokenSymbol(String tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }

    public Integer getCreateChannel() {
        return createChannel;
    }

    public void setCreateChannel(Integer createChannel) {
        this.createChannel = createChannel;
    }

    public String getPayTxId() {
        return payTxId;
    }

    public void setPayTxId(String payTxId) {
        this.payTxId = payTxId;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getObtainAmount() {
        return obtainAmount;
    }

    public void setObtainAmount(BigDecimal obtainAmount) {
        this.obtainAmount = obtainAmount;
    }

    public BigDecimal getPlatformFee() {
        return platformFee;
    }

    public void setPlatformFee(BigDecimal platformFee) {
        this.platformFee = platformFee;
    }

    public Long getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(Long confirmCount) {
        this.confirmCount = confirmCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRemarkInfo() {
        return remarkInfo;
    }

    public void setRemarkInfo(String remarkInfo) {
        this.remarkInfo = remarkInfo;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessSign() {
        return accessSign;
    }

    public void setAccessSign(String accessSign) {
        this.accessSign = accessSign;
    }

    public Long getPayTxHeight() {
        return payTxHeight;
    }

    public void setPayTxHeight(Long payTxHeight) {
        this.payTxHeight = payTxHeight;
    }

    public String getPayAddress() {
        return payAddress;
    }

    public void setPayAddress(String payAddress) {
        this.payAddress = payAddress;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getConfirmPayTime() {
        return confirmPayTime;
    }

    public void setConfirmPayTime(Long confirmPayTime) {
        this.confirmPayTime = confirmPayTime;
    }

    public Long getPaySuccessTime() {
        return paySuccessTime;
    }

    public void setPaySuccessTime(Long paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(Integer notifyCount) {
        this.notifyCount = notifyCount;
    }

    public Integer getNotifyState() {
        return notifyState;
    }

    public void setNotifyState(Integer notifyState) {
        this.notifyState = notifyState;
    }

    public String getNotifyResult() {
        return notifyResult;
    }

    public void setNotifyResult(String notifyResult) {
        this.notifyResult = notifyResult;
    }

    public Integer getQueryTxCount() {
        return queryTxCount;
    }

    public void setQueryTxCount(Integer queryTxCount) {
        this.queryTxCount = queryTxCount;
    }

    public Long getNextQueryTxTime() {
        return nextQueryTxTime;
    }

    public void setNextQueryTxTime(Long nextQueryTxTime) {
        this.nextQueryTxTime = nextQueryTxTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
