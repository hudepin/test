package com.deep.test.csv.gsp;


import java.util.List;

/**
 * 
 * MP接口请求参数封装对象
 * 
 * @ClassName: MPRequestDto 
 * @author 朱加蒙
 * @date 2016年11月24日 下午7:08:34
 * @version v3.0 
 *
 */
public class MPRequestDto {
    private String exteriorMerchantCode; //外部商家编码
	private String merchantSid; //商户编码
	private transient String serviceName;
	/*查询发货地址 请求参数封装*/
	private String storeSid; //店铺SID 相当于GSP storeCode
	private String storeKey; //店铺钥匙 
	private String storeSign; // 店铺加密签名 : storeSid + storeKey + timestamp MD5 加密32位小写
	private String warehouseName; //仓库名称
	private String sid;//发货地址SID
	private String categorySid; //类目SID
	private transient String timeStamp; //十三位时间戳
	private String orderStatus;//mp系统的订单状态
	private String startDate;//mp系统订单下单开始时间 
	private String endDate;//mp系统订单下单开始时间 
	private String pageSize;
	private String currentPage;//当前页码;
	private String orderNo;//MP订单号
	private String eId;//物流公司号
	private String delComSid;//物流公司编号
	private String waybillNo;//订单号，即是物流号
	private String updaterName;//操作人
	private String reason;//调整原因
	private String newStock;//网易的库存信息
	private String goodsSid; // 商品ID
	private List<OrderPartGoodsDto> goodsParcelList;
	public String getExteriorMerchantCode() {
		return exteriorMerchantCode;
	}
	public void setExteriorMerchantCode(String exteriorMerchantCode) {
		this.exteriorMerchantCode = exteriorMerchantCode;
	}
	public String getMerchantSid() {
		return merchantSid;
	}
	public void setMerchantSid(String merchantSid) {
		this.merchantSid = merchantSid;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getStoreSid() {
		return storeSid;
	}
	public void setStoreSid(String storeSid) {
		this.storeSid = storeSid;
	}
	
	public String getStoreKey() {
		return storeKey;
	}
	public void setStoreKey(String storeKey) {
		this.storeKey = storeKey;
	}
	public String getStoreSign() {
		return storeSign;
	}
	public void setStoreSign(String storeSign) {
		this.storeSign = storeSign;
	}
	public String getWarehouseName() {
		return warehouseName;
	}
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getCategorySid() {
		return categorySid;
	}
	public void setCategorySid(String categorySid) {
		this.categorySid = categorySid;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String geteId() {
		return eId;
	}
	public void seteId(String eId) {
		this.eId = eId;
	}
	public String getWaybillNo() {
		return waybillNo;
	}
	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}
	public String getUpdaterName() {
		return updaterName;
	}
	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getNewStock() {
		return newStock;
	}
	public void setNewStock(String newStock) {
		this.newStock = newStock;
	}
	
	public String getGoodsSid() {
		return goodsSid;
	}
	public void setGoodsSid(String goodsSid) {
		this.goodsSid = goodsSid;
	}
	
	public String getDelComSid() {
		return delComSid;
	}
	public void setDelComSid(String delComSid) {
		this.delComSid = delComSid;
	}

	public List<OrderPartGoodsDto> getGoodsParcelList() {
		return goodsParcelList;
	}
	public void setGoodsParcelList(List<OrderPartGoodsDto> goodsParcelList) {
		this.goodsParcelList = goodsParcelList;
	}
	

}
