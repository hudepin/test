package com.deep.test.collection;

import java.util.Arrays;

/**
 * @author hudepin
 * @Description
 * @ClassName ArrTest
 * @create_date 2020.09.01 10:02
 * @since 1.2.0
 */
public class ArrTest {
    public static void main(String[] args) {
        int[] arr[] = new int[2][3];
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=i+j;
            }
        }
        Arrays.stream(arr[0]).forEach(System.out::println);
        Arrays.stream(arr[1]).forEach(System.out::println);
    }
}
