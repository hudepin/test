package com.deep.test.csv;

/**
 * @author hudepin
 * @Description
 * @ClassName ErpInfo
 * @create_date 2020.04.22 19:03
 * @since 1.2.0
 */
public class ErpInfo {
    private String sku;
    private Integer num;
    private String warehouse;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
}
