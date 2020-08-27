package com.deep.test.csv;

/**
 * @author hudepin
 * @Description
 * @ClassName OrderInfo
 * @create_date 2020.05.23 11:36
 * @since 1.2.0
 */
public class OrderInfo {
    private String orderNo;
    private String customerName;
    private String idCard;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
