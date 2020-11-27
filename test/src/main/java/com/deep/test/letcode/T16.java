package com.deep.test.letcode;

import java.util.Arrays;

/**
 * @author hudepin
 * @Description
 * @ClassName T16
 * @create_date 2020.11.06 13:43
 * @since 1.2.0
 */
public class T16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null){
            return 0;
        }
        if(nums.length<4){
            int res = 0;
            for(int i=0;i<nums.length;i++){
                res+=nums[i];
            }
            return res;
        }
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            int start =i+1;
            int end = nums.length-1;
            while(start < end){
                int sum = nums[start]+nums[i]+nums[end];
                if(Math.abs(target-sum) <Math.abs(target-ans)){
                    ans = sum;
                }
                if(sum >target){
                    end--;
                }else if(sum <target){
                    start++;
                } else{
                    return ans;
                }

            }

        }
        return ans;

    }
}
