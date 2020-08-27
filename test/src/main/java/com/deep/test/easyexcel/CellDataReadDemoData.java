package com.deep.test.easyexcel;

import com.alibaba.excel.metadata.CellData;

import java.util.Date;

/**
 * @author hudepin
 * @Description
 * @ClassName CellDataReadDemoData
 * @create_date 2020.08.27 13:56
 * @since 1.2.0
 */
public class CellDataReadDemoData {
    private CellData<String> p1;
    private CellData<String> p2;
    private CellData<String> p3;
    private CellData<String> p4;
    private CellData<String> p5;
    private CellData<String> p6;
    private CellData<String> p7;
//    // 这里注意 虽然是日期 但是 类型 存储的是number 因为excel 存储的就是number
//    private CellData<Date> date;
//    private CellData<Double> doubleData;
//    // 这里并不一定能完美的获取 有些公式是依赖性的 可能会读不到 这个问题后续会修复
//    private CellData<String> formulaValue;

    public CellData<String> getP1() {
        return p1;
    }

    public void setP1(CellData<String> p1) {
        this.p1 = p1;
    }

    public CellData<String> getP2() {
        return p2;
    }

    public void setP2(CellData<String> p2) {
        this.p2 = p2;
    }

    public CellData<String> getP3() {
        return p3;
    }

    public void setP3(CellData<String> p3) {
        this.p3 = p3;
    }

    public CellData<String> getP4() {
        return p4;
    }

    public void setP4(CellData<String> p4) {
        this.p4 = p4;
    }

    public CellData<String> getP5() {
        return p5;
    }

    public void setP5(CellData<String> p5) {
        this.p5 = p5;
    }

    public CellData<String> getP6() {
        return p6;
    }

    public void setP6(CellData<String> p6) {
        this.p6 = p6;
    }

    public CellData<String> getP7() {
        return p7;
    }

    public void setP7(CellData<String> p7) {
        this.p7 = p7;
    }
}
