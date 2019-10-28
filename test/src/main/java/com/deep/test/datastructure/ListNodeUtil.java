package com.deep.test.datastructure;

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
}
