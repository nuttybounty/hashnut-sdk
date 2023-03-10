package io.hashnut.sdk.models;


import java.io.Serializable;
import java.util.Date;

public class FliatExchangeRate implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_fliat_exchange_rate.BaseCoin
     *
     * @mbggenerated
     */
    /**
     * 基准货币币种代号,例如:usdt，bnb等
     *
     * @mbggenerated
     */
    private String baseCoin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_fliat_exchange_rate.QuoteCoin
     *
     * @mbggenerated
     */
    /**
     * 兑换货币种代号,例如:usd,hkd,eur等
     *
     * @mbggenerated
     */
    private String quoteCoin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_fliat_exchange_rate.ChainCode
     *
     * @mbggenerated
     */
    /**
     * 币种所在的链,例如:erc20,bsc20,trc20等
     *
     * @mbggenerated
     */
    private String chainCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_fliat_exchange_rate.Rate
     *
     * @mbggenerated
     */
    /**
     * 兑换汇率 BaseCoin/QuoteCoin
     *
     * @mbggenerated
     */
    private Float rate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_fliat_exchange_rate.CreateTime
     *
     * @mbggenerated
     */
    /**
     * 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_fliat_exchange_rate.UpdateTime
     *
     * @mbggenerated
     */
    /**
     * 更新时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_fliat_exchange_rate
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_fliat_exchange_rate.BaseCoin
     *
     * @return the value of t_fliat_exchange_rate.BaseCoin
     *
     * @mbggenerated
     */
    public String getBaseCoin() {
        return baseCoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_fliat_exchange_rate.BaseCoin
     *
     * @param baseCoin the value for t_fliat_exchange_rate.BaseCoin
     *
     * @mbggenerated
     */
    public void setBaseCoin(String baseCoin) {
        this.baseCoin = baseCoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_fliat_exchange_rate.QuoteCoin
     *
     * @return the value of t_fliat_exchange_rate.QuoteCoin
     *
     * @mbggenerated
     */
    public String getQuoteCoin() {
        return quoteCoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_fliat_exchange_rate.QuoteCoin
     *
     * @param quoteCoin the value for t_fliat_exchange_rate.QuoteCoin
     *
     * @mbggenerated
     */
    public void setQuoteCoin(String quoteCoin) {
        this.quoteCoin = quoteCoin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_fliat_exchange_rate.ChainCode
     *
     * @return the value of t_fliat_exchange_rate.ChainCode
     *
     * @mbggenerated
     */
    public String getChainCode() {
        return chainCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_fliat_exchange_rate.ChainCode
     *
     * @param chainCode the value for t_fliat_exchange_rate.ChainCode
     *
     * @mbggenerated
     */
    public void setChainCode(String chainCode) {
        this.chainCode = chainCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_fliat_exchange_rate.Rate
     *
     * @return the value of t_fliat_exchange_rate.Rate
     *
     * @mbggenerated
     */
    public Float getRate() {
        return rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_fliat_exchange_rate.Rate
     *
     * @param rate the value for t_fliat_exchange_rate.Rate
     *
     * @mbggenerated
     */
    public void setRate(Float rate) {
        this.rate = rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_fliat_exchange_rate.CreateTime
     *
     * @return the value of t_fliat_exchange_rate.CreateTime
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_fliat_exchange_rate.CreateTime
     *
     * @param createTime the value for t_fliat_exchange_rate.CreateTime
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_fliat_exchange_rate.UpdateTime
     *
     * @return the value of t_fliat_exchange_rate.UpdateTime
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_fliat_exchange_rate.UpdateTime
     *
     * @param updateTime the value for t_fliat_exchange_rate.UpdateTime
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_fliat_exchange_rate
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", baseCoin=").append(baseCoin);
        sb.append(", quoteCoin=").append(quoteCoin);
        sb.append(", chainCode=").append(chainCode);
        sb.append(", rate=").append(rate);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_fliat_exchange_rate
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FliatExchangeRate other = (FliatExchangeRate) that;
        return (this.getBaseCoin() == null ? other.getBaseCoin() == null : this.getBaseCoin().equals(other.getBaseCoin()))
                && (this.getQuoteCoin() == null ? other.getQuoteCoin() == null : this.getQuoteCoin().equals(other.getQuoteCoin()))
                && (this.getChainCode() == null ? other.getChainCode() == null : this.getChainCode().equals(other.getChainCode()))
                && (this.getRate() == null ? other.getRate() == null : this.getRate().equals(other.getRate()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_fliat_exchange_rate
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBaseCoin() == null) ? 0 : getBaseCoin().hashCode());
        result = prime * result + ((getQuoteCoin() == null) ? 0 : getQuoteCoin().hashCode());
        result = prime * result + ((getChainCode() == null) ? 0 : getChainCode().hashCode());
        result = prime * result + ((getRate() == null) ? 0 : getRate().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}