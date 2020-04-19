package com.deep.test.classloader;

public class TestSub extends Test {
    static Sample subSample = new Sample("TestSub 的subSample的静态成员的初始化");
    TestSub(){
        System.out.println("子类TestSub默认构造方法被调用");
    }
    Sample sample = new Sample("Testsub类 sample 普通成员变量初始化");
    static {
        System.out.println("TestSub 静态块开始执行");
    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}
