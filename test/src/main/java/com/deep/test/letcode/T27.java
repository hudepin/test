package com.deep.test.letcode;

import java.util.Arrays;

/**
 * @author hudepin
 * @Description
 * @ClassName T27
 * @create_date 2020.11.27 14:37
 * @since 1.2.0
 */
public class T27 {
    public static int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int num: nums) {
            if(num != val) {
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,5,2,2,8,3,2};
        System.out.println(removeElement(nums,2));
    }
}
