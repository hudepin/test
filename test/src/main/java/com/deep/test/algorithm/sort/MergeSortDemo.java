package com.deep.test.algorithm.sort;

/**
 * @author hudepin
 * @Description 归并排序  分治思想
 * @ClassName MergeSortDemo
 * @create_date 2020.09.28 12:17
 * @since 1.2.0
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        SortUtils.initArr(arr);
        SortUtils.print(arr);
        int[] tmp = new int[arr.length];
        mergeSort(0,arr.length-1,arr,tmp);
        SortUtils.print(arr);
    }

    private static void mergeSort(int start, int end, int[] arr, int[] tmp) {
        if(start >= end){
            return;
        }
        int mid = (start+end)/2;
        mergeSort(start,mid,arr,tmp);
        mergeSort(mid+1,end,arr,tmp);
        mergeData(start,mid,end,arr,tmp);
    }

    private static void mergeData(int start, int mid, int end, int[] arr, int[] tmp) {
        int index = start;
        int left = start;
        int right = mid +1;
        while(left<=mid && right<= end){
            if(arr[left]< arr[right]){
                tmp[index++] = arr[left++];
            }else{
                tmp[index++] = arr[right++];
            }
        }
        while(left <= mid){
            tmp[index++] = arr[left++];
        }
        while(right <= end){
            tmp[index++] = arr[right++];
        }
        for(index=0;index<end;index++){
            arr[index] = tmp[index];
        }
    }
}
