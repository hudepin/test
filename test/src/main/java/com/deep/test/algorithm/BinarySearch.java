package com.deep.test.algorithm;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-7-11 9:26
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(search(array,9));
        System.out.println(recursionBinarySearch(array,9,0,8));
    }
    public static int search(int[] array,int item){
        int low =0,high=array.length;
        int index=-1;
        int mid = (low+high)/2;
        if(item>array[high-1]||item<array[0]) return -1;
        while(low<high){
            int guess = array[mid];
            if(guess==item){
                index= mid;
                break;
            } else if(guess>item){
                high = mid;
                mid = (low+high)/2;
            }else{
                low = mid;
                mid = (low+high)/2;
            }
        }
        return index;


    }
    public static int recursionBinarySearch(int[] arr,int key,int low,int high) {

        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }

        int middle = (low + high) / 2;            //初始中间位置
        if (arr[middle] > key) {
            //比关键字大则关键字在左区域
            return recursionBinarySearch(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            //比关键字小则关键字在右区域
            return recursionBinarySearch(arr, key, middle + 1, high);
        } else {
            return middle;
        }

    }
}
