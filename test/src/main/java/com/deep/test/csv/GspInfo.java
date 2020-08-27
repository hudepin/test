package com.deep.test.csv;

/**
 * @author hudepin
 * @Description
 * @ClassName GspInfo
 * @create_date 2020.04.22 19:04
 * @since 1.2.0
 */
public class GspInfo {
    private String sku;
    private Integer num;
    private String warehouse;
    private String invenId;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getInvenId() {
        return invenId;
    }

    public void setInvenId(String invenId) {
        this.invenId = invenId;
    }
}
