package com.deep.test.algorithm;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-7-24 11:15
 */
public class TestKNN extends KNNClassification<Integer> {
    @Override
    protected double similarScore(Integer o1, Integer o2) {
        return -1 * Math.abs(o1 - o2);
    }

    public static void main(String[] args) {
        TestKNN test = new TestKNN();
        //1-5 为分类1 6-9为分类0
        for (int i = 1; i < 10; i++) {
            test.add(i, i > 5 ? "0" : "1");
        }
        //预测0的分类，0最近的三个为1、2、3
        System.out.println(test.getClassifyId(0));
    }
}
