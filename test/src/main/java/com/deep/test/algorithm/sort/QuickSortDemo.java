package com.deep.test.algorithm.sort;

/**
 * @author hudepin
 * @Description
 * @ClassName QuickSort
 * @create_date 2020.09.28 12:28
 * @since 1.2.0
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        SortUtils.initArr(arr);
        SortUtils.print(arr);
        quickSort(arr,0,arr.length-1);
        SortUtils.print(arr);
    }

    private static void quickSort(int[] arr,int low,int high) {
        if(low < high){
            int index = getIndex(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int tmp =arr[low];
        while(low < high){
            while(low < high && arr[high]>= tmp){
                high--;
            }
            arr[low] = arr[high];
            while(low<high && arr[low] <= tmp){
                low ++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }
}
