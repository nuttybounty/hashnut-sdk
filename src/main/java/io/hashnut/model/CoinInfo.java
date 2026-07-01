package io.hashnut.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CoinInfo {
    private Integer id;
    private String blockChain;
    private String tokenSymbol;
    @JsonProperty("isToken")
    private Boolean isToken;
    private Boolean enable;
    private String contractAddress;
    private String coinDesc;
    private Boolean gateWayEnable;
    private Long decimals;
    @JsonProperty("NFTMarket")
    private String NFTMarket;
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

    public void setBlockChain(String blockChain) {
        this.blockChain = blockChain;
    }

    public String getTokenSymbol() {
        return tokenSymbol;
    }

    public void setTokenSymbol(String tokenSymbol) {
        this.tokenSymbol = tokenSymbol;
    }

    public Boolean getToken() {
        return isToken;
    }

    @JsonProperty("isToken")
    public void setToken(Boolean token) {
        isToken = token;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getCoinDesc() {
        return coinDesc;
    }

    public void setCoinDesc(String coinDesc) {
        this.coinDesc = coinDesc;
    }

    public Boolean getGateWayEnable() {
        return gateWayEnable;
    }

    public void setGateWayEnable(Boolean gateWayEnable) {
        this.gateWayEnable = gateWayEnable;
    }

    public Long getDecimals() {
        return decimals;
    }

    public void setDecimals(Long decimals) {
        this.decimals = decimals;
    }

    public String getNFTMarket() {
        return NFTMarket;
    }

    @JsonProperty("NFTMarket")
    public void setNFTMarket(String NFTMarket) {
        this.NFTMarket = NFTMarket;
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
