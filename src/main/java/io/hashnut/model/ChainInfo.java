package io.hashnut.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ChainInfo {
    private Integer id;
    @JsonProperty("chain")
    private String blockChain;
    private String chainDesc;
    private Boolean enable;
    private String receiptAddress;
    private Long txConfirmCount;
    private Boolean walletConnectEnable;
    private String bridgeServerAddress;
    private Integer decimals;
    private String baseChainSymbol;
    private Integer env;
    @JsonProperty("EIP712ChainId")
    private Long EIP712ChainId;
    private Long chainId;
    private String baseChainCoin;
    @JsonProperty("EIP1559Support")
    private Boolean EIP1559Support;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlockChain() {
        return blockChain;
    }

    @JsonProperty("chain")
    public void setBlockChain(String blockChain) {
        this.blockChain = blockChain;
    }

    public String getChainDesc() {
        return chainDesc;
    }

    public void setChainDesc(String chainDesc) {
        this.chainDesc = chainDesc;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public Long getTxConfirmCount() {
        return txConfirmCount;
    }

    public void setTxConfirmCount(Long txConfirmCount) {
        this.txConfirmCount = txConfirmCount;
    }

    public Boolean getWalletConnectEnable() {
        return walletConnectEnable;
    }

    public void setWalletConnectEnable(Boolean walletConnectEnable) {
        this.walletConnectEnable = walletConnectEnable;
    }

    public String getBridgeServerAddress() {
        return bridgeServerAddress;
    }

    public void setBridgeServerAddress(String bridgeServerAddress) {
        this.bridgeServerAddress = bridgeServerAddress;
    }

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public String getBaseChainSymbol() {
        return baseChainSymbol;
    }

    public void setBaseChainSymbol(String baseChainSymbol) {
        this.baseChainSymbol = baseChainSymbol;
    }

    public Integer getEnv() {
        return env;
    }

    public void setEnv(Integer env) {
        this.env = env;
    }

    public Long getEIP712ChainId() {
        return EIP712ChainId;
    }

    @JsonProperty("EIP712ChainId")
    public void setEIP712ChainId(Long EIP712ChainId) {
        this.EIP712ChainId = EIP712ChainId;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public String getBaseChainCoin() {
        return baseChainCoin;
    }

    public void setBaseChainCoin(String baseChainCoin) {
        this.baseChainCoin = baseChainCoin;
    }

    public Boolean getEIP1559Support() {
        return EIP1559Support;
    }

    @JsonProperty("EIP1559Support")
    public void setEIP1559Support(Boolean EIP1559Support) {
        this.EIP1559Support = EIP1559Support;
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
