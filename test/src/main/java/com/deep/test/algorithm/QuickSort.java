package com.deep.test.algorithm;

import java.util.Arrays;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-7-15 9:48
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={6,1,8,7,2,9,3,4,5};
        quickSort2(arr,0,8);
        System.out.println("--------------");
        Arrays.stream(arr).forEach(e->{
            System.out.println(e);
        });
    }


    private static void quickSort2(int[] a, int low, int high) {
        if( low > high) {  //递归算法的出口条件
            return;
        }
        int i = low;
        int j = high;
        int key = a[ low ];//基准元素
        while( i< j) {   //完成一趟排序
            while(i<j && a[j] > key){  //从右往左找到第一个小于key的数
                j--;
            }
            while( i<j && a[i] <= key) {  //从左往右找到第一个大于key的数
                i++;
            }
            if(i<j) { //交换两个数位置
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        //调整key的位置
        a[low] = a[i];
        a[i] = key;
        System.out.println("------");
        Arrays.stream(a).forEach(e-> System.out.print(e));

        quickSort2(a, low, i-1 );  //key左边的数
        quickSort2(a, i+1, high);   //key右边的数
    }




}
