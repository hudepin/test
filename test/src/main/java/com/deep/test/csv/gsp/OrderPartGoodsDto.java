package com.deep.test.csv.gsp;
/**
 * 部分发货
 * @author CDS
 *
 */
public class OrderPartGoodsDto {
	private String eId;
	
	private String lcompanyNo;
	
	private String goodsSid;
	
	private String orderDetailNo;
	
	private String waybillNo;

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String getLcompanyNo() {
		return lcompanyNo;
	}

	public void setLcompanyNo(String lcompanyNo) {
		this.lcompanyNo = lcompanyNo;
	}

	public String getGoodsSid() {
		return goodsSid;
	}

	public void setGoodsSid(String goodsSid) {
		this.goodsSid = goodsSid;
	}

	public String getOrderDetailNo() {
		return orderDetailNo;
	}

	public void setOrderDetailNo(String orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}

	public String getWaybillNo() {
		return waybillNo;
	}

	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}
	
}
