package com.deep.test.algorithm;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-7-24 10:54
 */
public class KNNValueBean<T> {
    private T value;
    private String classifyId;

    public KNNValueBean(T value, String classifyId) {
        this.value = value;
        this.classifyId = classifyId;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }
}
