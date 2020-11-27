package com.deep.test.datastructure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Description:单项链表反转</p>
 * author:hudepin
 * createTime:2019-10-17 13:59
 */
public class ReverseListNode {
    public static void main(String[] args) {
        SingleListNode header = initSingleList();
        printSingleListValue(header);
        SingleListNode reverseHead = reverseList1(header);
        printSingleListValue(reverseHead);

        System.out.println("---------");
        SingleListNode header1 = initSingleList();
        SingleListNode reverseHead1 = reverseList(header1);
        printSingleListValue(reverseHead1);
        SingleListNode header2 = initSingleList1();
        System.out.println(isPalindrome(header2));
        SingleListNode header3 = initSingleList1();
        System.out.println(isPalindrome1(header3));
        SingleListNode header4 = initSingleList1();
        System.out.println(isPalindrome2(header4));
    }

    private static SingleListNode initSingleList1() {
        SingleListNode<Integer> header = new SingleListNode<Integer>(1);
        SingleListNode<Integer> node1 = new SingleListNode<Integer>(2);
        header.next=node1;
        SingleListNode<Integer> node2 = new SingleListNode<Integer>(2);
        node1.next=node2;
        SingleListNode<Integer> node3 = new SingleListNode<Integer>(1);
        node2.next=node3;
        return header;
    }

    public static void printSingleListValue(SingleListNode header){
        SingleListNode temp = header;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }

    }

    public static SingleListNode initSingleList() {
        SingleListNode<Integer> header = new SingleListNode<Integer>(0);
        SingleListNode<Integer> node1 = new SingleListNode<Integer>(1);
        header.next=node1;
        SingleListNode<Integer> node2 = new SingleListNode<Integer>(2);
        node1.next=node2;
        SingleListNode<Integer> node3 = new SingleListNode<Integer>(3);
        node2.next=node3;
        SingleListNode<Integer> node4 = new SingleListNode<Integer>(4);
        node3.next=node4;
        return header;
    }


    public static SingleListNode reverseList1(SingleListNode header){
        SingleListNode dummyNode = new SingleListNode(-1);//哨兵节点
        dummyNode.next = header;
        SingleListNode pre = dummyNode.next;
        SingleListNode curr = pre.next;
        while(curr != null){
            pre.next = curr.next;
            curr.next = dummyNode.next;
            dummyNode.next = curr;
            curr = pre.next;
        }
        return dummyNode.next;
    }

    /**
     * 递归反转链表
     * @param head
     * @return
     */
    public static SingleListNode reverseList(SingleListNode head){
        if(head==null || head.next==null){
            return head;
        }
        SingleListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next =null;
        return cur;
    }

    /**
     * 234. 回文链表
     * 示例 1:
     *
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     *
     * 输入: 1->2->2->1
     * 输出: true
     * @param head
     * @return
     */
    public static boolean isPalindrome(SingleListNode head) {
        if(head==null ||head.next==null){
            return false;
        }
        Deque queue = new LinkedList();
        while(head != null){
            queue.push(head.value);
            head=head.next;
        }
        while(!queue.isEmpty()){
            if(queue.pollFirst() != queue.pollLast()){
                return false;
            }
        }
        return true;


    }

    /**
     * 不借助外部空间
     * @param head
     * @return
     */
    public static boolean isPalindrome2(SingleListNode<Integer> head) {
        if(head == null ||head.next==null){
            return true;
        }
        SingleListNode slow = head;
        SingleListNode fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        SingleListNode head2 = reverseList1(slow);
        slow.next = null;
        while(head != null && head2 != null){
            if(head.value != head2.value){
                return false;
            }else{
                head = head.next;
                head2 = head2.next;
            }
        }
        return true;


    }
    public static boolean isPalindrome1(SingleListNode<Integer> head) {
        if(head==null ||head.next==null){
            return true;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int index= 0;
        while(head !=null ){
          arr.add(head.value);
           head=head.next;
        }
        if(arr.size()%2 != 0){
            return false;
        }
        int center = arr.size()/2;
        for(int i=0;i<center;i++){
                if(arr.get(i) != arr.get(arr.size()-i-1)){
                    return false;
                }
        }
        return true;

    }

}
