package com.deep.test.csv;

import java.math.BigDecimal;
import java.util.Date;

public class MPCategoryRel {

    private String mpCategoryCode;

    private String erpCategoryCode;


    private String erpCostCenter;

    private Long buyer;


    public String getMpCategoryCode() {
        return mpCategoryCode;
    }

    public void setMpCategoryCode(String mpCategoryCode) {
        this.mpCategoryCode = mpCategoryCode;
    }

    public String getErpCategoryCode() {
        return erpCategoryCode;
    }

    public void setErpCategoryCode(String erpCategoryCode) {
        this.erpCategoryCode = erpCategoryCode;
    }

    public String getErpCostCenter() {
        return erpCostCenter;
    }

    public void setErpCostCenter(String erpCostCenter) {
        this.erpCostCenter = erpCostCenter;
    }


    public Long getBuyer() {
        return buyer;
    }

    public void setBuyer(Long buyer) {
        this.buyer = buyer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MPCategoryRel that = (MPCategoryRel) o;

        if (!mpCategoryCode.equals(that.mpCategoryCode)) return false;
        if (!erpCategoryCode.equals(that.erpCategoryCode)) return false;
        if (!erpCostCenter.equals(that.erpCostCenter)) return false;
        return buyer.equals(that.buyer);
    }

    @Override
    public int hashCode() {
        int result = mpCategoryCode.hashCode();
        result = 31 * result + erpCategoryCode.hashCode();
        result = 31 * result + erpCostCenter.hashCode();
        result = 31 * result + buyer.hashCode();
        return result;
    }
}