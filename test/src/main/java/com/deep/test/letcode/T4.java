package com.deep.test.letcode;

/**
 * @author hudepin
 * @Description
 * @ClassName T4
 * @create_date 2020.10.09 17:25
 * @since 1.2.0
 */
public class T4 {
    public static void main(String[] args) {
        int[] a1 = {1,3};
        int[] a2={2};
        System.out.println(findMedianSortedArrays(a1,a2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 =0;
        int l2 =0;
        if(nums1==null && nums2==null){
            return 0;
        }
        if(nums1 == null || nums2 ==null){
            if(nums1 != null){
                l1=nums1.length;
            }
            if(nums2 != null){
                l2 = nums2.length;
            }
        }else{
            l1=nums1.length;
            l2 = nums2.length;
        }
        int i=0;
        int j=0;
        int index=0;

        int[] temp = new int[l1+l2];
        if(l1>0 && l2>0){
            while((i+j)<(l1+l2)){
                if(nums1[l1-1]<nums2[0]){
                    if(index<l1){
                        temp[index] = nums1[i];
                        i++;
                    }else{
                        temp[index] = nums2[j];
                        j++;
                    }
                    index++;

                }else if(nums1[0]>nums2[l2-1]){
                    if(index<l2){
                        temp[index] = nums2[j];
                        j++;
                    }else{
                        temp[index] = nums1[i];
                        i++;
                    }
                    index++;
                }else{
                    while((i==l1 && j<l2) ||(j<l2  && nums1[i]>nums2[j])){
                        temp[index] = nums2[j];
                        j++;
                        index++;
                    }
                    while((i<l1 && j==l2) ||( i<l1 && nums1[i]<=nums2[j])){
                        temp[index] = nums1[i];
                        i++;
                        index++;
                    }
                }

            }
        }
        if(l1==0){
            temp = nums2;
        }
        if(l2==0){
            temp = nums1;
        }

        int mid = (temp.length)/2;
        if(temp.length%2==0){
            return ((double)temp[mid]+(double)temp[mid-1])/2;
        }else{
            return (double)temp[mid];
        }

    }
}
