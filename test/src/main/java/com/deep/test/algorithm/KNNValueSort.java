package com.deep.test.algorithm;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-7-24 10:56
 */
public class KNNValueSort {
    private String classifyId;
    private double score;

    public KNNValueSort(String classifyId, double score) {
        this.classifyId = classifyId;
        this.score = score;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
