package com.deep.test.csv.stock;



public class FastGoHomeMsgDTO {
    private Long goodsId;
    private Long channelSid;
    private String shopAndStoreCode;
    private Long saleStockSum;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getChannelSid() {
        return channelSid;
    }

    public void setChannelSid(Long channelSid) {
        this.channelSid = channelSid;
    }

    public String getShopAndStoreCode() {
        return shopAndStoreCode;
    }

    public void setShopAndStoreCode(String shopAndStoreCode) {
        this.shopAndStoreCode = shopAndStoreCode;
    }

    public Long getSaleStockSum() {
        return saleStockSum;
    }

    public void setSaleStockSum(Long saleStockSum) {
        this.saleStockSum = saleStockSum;
    }
}
