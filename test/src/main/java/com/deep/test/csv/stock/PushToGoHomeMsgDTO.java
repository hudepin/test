package com.deep.test.csv.stock;



public class PushToGoHomeMsgDTO {

	private Long goodsSid;
	private Long channelSid;
	private String shopAndStoreCode;
	private Long saleStockSum;
	private String shopSid;

	public Long getGoodsSid() {
		return goodsSid;
	}

	public void setGoodsSid(Long goodsSid) {
		this.goodsSid = goodsSid;
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

	public String getShopSid() {
		return shopSid;
	}

	public void setShopSid(String shopSid) {
		this.shopSid = shopSid;
	}
}
