package com.deep.test.datastructure;

/**
 * @author hudepin
 * @Description
 * @ClassName Soluation
 * @create_date 2020.10.09 15:10
 * @since 1.2.0
 */

import com.deep.test.letcode.datastructure.ListNodeUtils;
import com.deep.test.letcode.datastructure.entity.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Soluation {
    public static void main(String[] args) {
        int[] arr1 = {7,1,6};
        int[] arr2 = {5,9,5};
        ListNode l1 = ListNodeUtil.initByArr(arr1);
        ListNode l2 = ListNodeUtil.initByArr(arr2);
        addTwoNumbers(l1,l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        if(l1 == null || l2 == null){
            return res;
        }
        int carry=0;
        int left=0;
        ListNode temp = null;
        while(l1 != null || l2 != null){
            int v1 = l1==null?0:l1.val;
            int v2 = l2==null?0:l2.val;
            left=(v1+v2+carry)%10;
            if(temp == null){
                res =temp= new ListNode(left);
            }else{
                temp.next = new ListNode(left);
                temp = temp.next;
            }
            carry = (v1+v2+carry)/10;
            if(l1 != null){
                l1=l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry>0){
            temp.next = new ListNode(carry);
        }
        return res;

    }
}
