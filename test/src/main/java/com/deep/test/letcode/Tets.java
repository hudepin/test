package com.deep.test.letcode;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-6-6 16:35
 */
public class Tets {
    public static void main(String[] args) {
        int[][] arr={
                {7,0,0,0,0},
                {3,8,0,0,0},
                {8,1,0,0,0},
                {2,7,4,4,0},
                {4,5,2,6,5}
        };

        int max = maxSumNew(arr,5);
        System.out.println(max);
    }
    /**
     * 动态规划
     * @param arr
     * @param n
     * @param
     * @return
     */
    public static int maxSumNew(int arr[][],int n){

        if(arr==null){
            return 0;
        }
        int[][] max = new int[n][n];
        for(int i = n-1; i >=0; i--){
            for(int j = 0; j <= i; j++){
                if(i==n-1){
                    max[n-1][j] = arr[n-1][j];
                }else{
                    max[i][j] = Math.max(max[i+1][j],max[i+1][j+1]) + arr[i][j];
                }
            }
        }
        return max[0][0];
    }
}
