package com.deep.test.lambda;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-7-23 15:12
 */
public class Test1 {
    public static void main(String[] args) {
        String[] arrs = {"123","21344"};
        Arrays.stream(arrs).forEach(Test1::printValur);
    }
    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }
}
