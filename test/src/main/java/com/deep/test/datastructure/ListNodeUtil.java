package com.deep.test.datastructure;

import com.deep.test.letcode.datastructure.entity.ListNode;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-10-17 9:55
 */
public class ListNodeUtil {
    /**
     *
     * @param currNode
     * @param insertNode
     */
    public static void insert(SingleListNode currNode, SingleListNode insertNode){
        SingleListNode next = currNode.next;
        currNode.next = insertNode;
        insertNode.next = next;
    }
    public static void del(SingleListNode head, SingleListNode entity){
        if(head.value == entity.value){
            SingleListNode next = head.next;
            head.next = null;

        }
        while(head.next != null){
            if(head.next.value == entity.value){

            }
        }
    }
    public static ListNode initByArr(int[] arr1) {
        ListNode head = new ListNode(arr1[0]);
        for(int i=1;i<arr1.length;i++){
            ListNode node = new ListNode(arr1[i]);
            addListNode(head,node);
        }
        return head;
    }


    public static void addListNode(ListNode head,ListNode insertNode){
        ListNode last = head;
        //找到最后一个节点
        while(last.next != null){
            last = last.next;
        }
        last.next = insertNode;
    }

}
