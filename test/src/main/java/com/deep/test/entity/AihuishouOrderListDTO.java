package com.deep.test.entity;

/**
 * @author hudepin
 * @Description
 * @ClassName AihuishouOrderListDTO
 * @create_date 2020.12.17 11:13
 * @since 1.2.0
 */
public class AihuishouOrderListDTO {
    private String abnInfo;//	异常信息	string
    private String abnStatus;//	异常状态	string
    private String aliasOrderNo;//	外部单号	string
    private String orderNo;
    private String storeId;
    private String storeName;

    public String getAbnInfo() {
        return abnInfo;
    }

    public void setAbnInfo(String abnInfo) {
        this.abnInfo = abnInfo;
    }

    public String getAbnStatus() {
        return abnStatus;
    }

    public void setAbnStatus(String abnStatus) {
        this.abnStatus = abnStatus;
    }

    public String getAliasOrderNo() {
        return aliasOrderNo;
    }

    public void setAliasOrderNo(String aliasOrderNo) {
        this.aliasOrderNo = aliasOrderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
