package com.deep.test.algorithm.sort;

/**
 * @author hudepin
 * @Description
 * @ClassName SortUtils
 * @create_date 2020.09.28 12:28
 * @since 1.2.0
 */
public class SortUtils {
    public static void print(int[] arr) {
        System.out.println();
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+",");
            }

        }
        System.out.println();
    }

    public static void initArr(int[] arr) {
        for(int i=0;i<arr.length;i++){
            arr[i] = (int)(Math.random()*1000);
        }
    }
}
