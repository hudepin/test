package com.deep.test.csv;



public class StockOffineDTO {
    private Long sid;
    private String comGoodsSid;
    private String comSid;

    public String getComSid() {
        return comSid;
    }

    public void setComSid(String comSid) {
        this.comSid = comSid;
    }

    private Long goodsSid;
    private String shopCode;
    private String shopSid;
    private String shopMerchantCode;
    private String bizId;
    /**
     * 安全阈值库存pcm_stock_safe_ratio、pcm_stock_safe_ratio_global、pcm_stock_safe_ratio_category
     */
    private Long safeStockSum;
    /**
     *
     */
    private Long saleStockSum;
    /**
     * 安全阈值
     */
    private Double safeStockRatio;
    /**
     * 到家线上库存数量
     */
    private Long saleInnerTotal;
    /**
     *
     */
    private Double safeRatioInner;
    /**
     *
     */
    private Double safeRatioOuter;
    /**
     * 废弃，老属性
     */
    private Double o2oRatio;
    /**
     * 业态同步的门店库存
     */
    private Long availableInv;
    private int isEffective;
    /**
     * 到家线上可售库存
     */
    private Long saleOnline;
    private boolean isHasSafeRatio = true;
    private String stockOutKey;
    private Integer stockSource;
    private String ruleId;

    public String getBizIdAndShopAndComGoodsSid() {
        return this.bizId + "_" + this.shopCode + "_" + this.comGoodsSid;
    }

    public boolean isHasSafeRatio() {
        return isHasSafeRatio;
    }

    public void setHasSafeRatio(boolean hasSafeRatio) {
        isHasSafeRatio = hasSafeRatio;
    }

    public String getShopSid() {
        return shopSid;
    }

    public void setShopSid(String shopSid) {
        this.shopSid = shopSid;
    }

    public Long getSaleStockSum() {
        return saleStockSum;
    }

    public void setSaleStockSum(Long saleStockSum) {
        this.saleStockSum = saleStockSum;
    }

    public int getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(int isEffective) {
        this.isEffective = isEffective;
    }

    public Long getSaleOnline() {
        return saleOnline;
    }

    public void setSaleOnline(Long saleOnline) {
        this.saleOnline = saleOnline;
    }

    public Double getSafeRatioInner() {
        return safeRatioInner;
    }

    public void setSafeRatioInner(Double safeRatioInner) {
        this.safeRatioInner = safeRatioInner;
    }

    public Double getSafeRatioOuter() {
        return safeRatioOuter;
    }

    public void setSafeRatioOuter(Double safeRatioOuter) {
        this.safeRatioOuter = safeRatioOuter;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getComGoodsSid() {
        return comGoodsSid;
    }

    public void setComGoodsSid(String comGoodsSid) {
        this.comGoodsSid = comGoodsSid;
    }

    public Long getGoodsSid() {
        return goodsSid;
    }

    public void setGoodsSid(Long goodsSid) {
        this.goodsSid = goodsSid;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public String getShopMerchantCode() {
        return shopMerchantCode;
    }

    public void setShopMerchantCode(String shopMerchantCode) {
        this.shopMerchantCode = shopMerchantCode;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Long getSafeStockSum() {
        return safeStockSum;
    }

    public void setSafeStockSum(Long safeStockSum) {
        this.safeStockSum = safeStockSum;
    }

    public Double getSafeStockRatio() {
        return safeStockRatio;
    }

    public void setSafeStockRatio(Double safeStockRatio) {
        this.safeStockRatio = safeStockRatio;
    }

    public Long getSaleInnerTotal() {
        return saleInnerTotal;
    }

    public void setSaleInnerTotal(Long saleInnerTotal) {
        this.saleInnerTotal = saleInnerTotal;
    }

    public Double getO2oRatio() {
        return o2oRatio;
    }

    public void setO2oRatio(Double o2oRatio) {
        this.o2oRatio = o2oRatio;
    }

    public Long getAvailableInv() {
        return availableInv;
    }

    public void setAvailableInv(Long availableInv) {
        this.availableInv = availableInv;
    }

    public String getStockOutKey() {
        return stockOutKey;
    }

    public void setStockOutKey(String stockOutKey) {
        this.stockOutKey = stockOutKey;
    }

    public Integer getStockSource() {
        return stockSource;
    }

    public void setStockSource(Integer stockSource) {
        this.stockSource = stockSource;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
