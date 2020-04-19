package com.deep.test.classloader;

public class Test {
    static {
        System.out.println("Test 类静态成员初始化1");
    }
    static Sample sample1 = new Sample("静态成员变量初始化2");
    static {
        System.out.println("Test 类静态成员初始化2");
    }
    Test(){
        System.out.println("Test 类的构造初始化");
    }
    static Sample sample2 = new Sample("静态成员变量初始化2");
}
