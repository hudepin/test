package com.deep.test.algorithm.sort;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName QuickSortTest
 * @create_date 2021.03.31 17:33
 * @since
 */
public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = {65,5,123,124,123,89,23,78,12,25};
        quickSort(arr,0,arr.length-1);
        SortUtils.print(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int index = getIndex(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];
        while(low<high){
            while(low<high && arr[high]>=tmp){
                high--;
            }
            arr[low] = arr[high];
            while(low<high && arr[low]<=tmp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return low;
    }


}
