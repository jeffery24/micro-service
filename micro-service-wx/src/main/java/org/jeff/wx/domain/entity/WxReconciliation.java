package org.jeff.wx.domain.entity;




import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WxReconciliation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 微信交易时间
     */
    private Date wxTransactionTime;

    /**
     * 公众账号id
     */
    private String publicAccountId;

    /**
     * 商户号
     */
    private String merchantNumber;

    /**
     * 特约商户号
     */
    private String specialMerchantNo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 设备号
     */
    private String deviceNumber;

    /**
     * 微信订单号
     */
    private String wechatOrderNo;

    /**
     * 商户订单号
     */
    private String merchantOrderNumber;

    /**
     * 用户标识
     */
    private String userId;

    /**
     * 交易类型
     */
    private String transactionType;

    /**
     * 交易状态
     */
    private String tradingStatus;

    /**
     * 付款银行
     */
    private String payingBank;

    /**
     * 货币种类
     */
    private String currencyType;

    /**
     * 应结订单金额
     */
    private BigDecimal orderAmountToBeSettled;

    /**
     * 代金券金额
     */
    private BigDecimal voucherAmount;

    /**
     * 微信退款单号
     */
    private String wechatRefundNo;

    /**
     * 商户退款单号
     */
    private String merchantRefundNo;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

    /**
     * 充值券退款金额
     */
    private BigDecimal refundAmountOfRechargeVoucher;

    /**
     * 退款类型
     */
    private String refundType;

    /**
     * 退款状态
     */
    private String refundStatus;

    /**
     * 商品名称
     */
    private String tradeName;

    /**
     * 商户数据包
     */
    private String merchantPacket;

    /**
     * 手续费
     */
    private BigDecimal serviceCharge;

    /**
     * 费率
     */
    private String rate;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 申请退款金额
     */
    private BigDecimal applicationForRefundAmount;

    /**
     * 费率备注
     */
    private String rateNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getWxTransactionTime() {
        return wxTransactionTime;
    }

    public void setWxTransactionTime(Date wxTransactionTime) {
        this.wxTransactionTime = wxTransactionTime;
    }

    public String getPublicAccountId() {
        return publicAccountId;
    }

    public void setPublicAccountId(String publicAccountId) {
        this.publicAccountId = publicAccountId;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber;
    }

    public String getSpecialMerchantNo() {
        return specialMerchantNo;
    }

    public void setSpecialMerchantNo(String specialMerchantNo) {
        this.specialMerchantNo = specialMerchantNo;
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

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public String getWechatOrderNo() {
        return wechatOrderNo;
    }

    public void setWechatOrderNo(String wechatOrderNo) {
        this.wechatOrderNo = wechatOrderNo;
    }

    public String getMerchantOrderNumber() {
        return merchantOrderNumber;
    }

    public void setMerchantOrderNumber(String merchantOrderNumber) {
        this.merchantOrderNumber = merchantOrderNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTradingStatus() {
        return tradingStatus;
    }

    public void setTradingStatus(String tradingStatus) {
        this.tradingStatus = tradingStatus;
    }

    public String getPayingBank() {
        return payingBank;
    }

    public void setPayingBank(String payingBank) {
        this.payingBank = payingBank;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getOrderAmountToBeSettled() {
        return orderAmountToBeSettled;
    }

    public void setOrderAmountToBeSettled(BigDecimal orderAmountToBeSettled) {
        this.orderAmountToBeSettled = orderAmountToBeSettled;
    }

    public BigDecimal getVoucherAmount() {
        return voucherAmount;
    }

    public void setVoucherAmount(BigDecimal voucherAmount) {
        this.voucherAmount = voucherAmount;
    }

    public String getWechatRefundNo() {
        return wechatRefundNo;
    }

    public void setWechatRefundNo(String wechatRefundNo) {
        this.wechatRefundNo = wechatRefundNo;
    }

    public String getMerchantRefundNo() {
        return merchantRefundNo;
    }

    public void setMerchantRefundNo(String merchantRefundNo) {
        this.merchantRefundNo = merchantRefundNo;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getRefundAmountOfRechargeVoucher() {
        return refundAmountOfRechargeVoucher;
    }

    public void setRefundAmountOfRechargeVoucher(BigDecimal refundAmountOfRechargeVoucher) {
        this.refundAmountOfRechargeVoucher = refundAmountOfRechargeVoucher;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getMerchantPacket() {
        return merchantPacket;
    }

    public void setMerchantPacket(String merchantPacket) {
        this.merchantPacket = merchantPacket;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getApplicationForRefundAmount() {
        return applicationForRefundAmount;
    }

    public void setApplicationForRefundAmount(BigDecimal applicationForRefundAmount) {
        this.applicationForRefundAmount = applicationForRefundAmount;
    }

    public String getRateNotes() {
        return rateNotes;
    }

    public void setRateNotes(String rateNotes) {
        this.rateNotes = rateNotes;
    }

    @Override
    public String toString() {
        return "WxReconciliationEntity [id=" + id + ", wxTransactionTime=" + wxTransactionTime + ", publicAccountId="
                + publicAccountId + ", merchantNumber=" + merchantNumber + ", specialMerchantNo=" + specialMerchantNo
                + ", createTime=" + createTime + ", updateTime=" + updateTime + ", deviceNumber=" + deviceNumber
                + ", wechatOrderNo=" + wechatOrderNo + ", merchantOrderNumber=" + merchantOrderNumber + ", userId="
                + userId + ", transactionType=" + transactionType + ", tradingStatus=" + tradingStatus + ", payingBank="
                + payingBank + ", currencyType=" + currencyType + ", orderAmountToBeSettled=" + orderAmountToBeSettled
                + ", voucherAmount=" + voucherAmount + ", wechatRefundNo=" + wechatRefundNo + ", merchantRefundNo="
                + merchantRefundNo + ", refundAmount=" + refundAmount + ", refundAmountOfRechargeVoucher="
                + refundAmountOfRechargeVoucher + ", refundType=" + refundType + ", refundStatus=" + refundStatus
                + ", tradeName=" + tradeName + ", merchantPacket=" + merchantPacket + ", serviceCharge=" + serviceCharge
                + ", rate=" + rate + ", orderAmount=" + orderAmount + ", applicationForRefundAmount="
                + applicationForRefundAmount + ", rateNotes=" + rateNotes + "]";
    }

}