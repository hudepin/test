package com.deep.test.letcode.doublepointer;

import com.deep.test.datastructure.ListNodeUtil;
import com.deep.test.letcode.datastructure.ListNodeUtils;
import com.deep.test.letcode.datastructure.entity.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hudepin
 * @Description
 * @ClassName T19
 * @create_date 2020.12.07 10:08
 * @since 1.2.0
 */
public class T19 {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,10,12};
        ListNode head = ListNodeUtils.initByArr(arr);
        T19 t19 = new T19();
        t19.removeNthFromEnd1(head,2);
        head = ListNodeUtils.initByArr(arr);
        t19.removeNthFromEnd2(head,2);
        head = ListNodeUtils.initByArr(arr);
        t19.removeNthFromEnd3(head,2);


    }

    /**
     * 第一种解法 计算链表长度，然后根据n找到删除元素的前一个元素
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        System.out.println("removeNthFromEnd1删除倒数第"+n+"个元素");
        ListNodeUtils.printListNode(head);
        if(head == null){
            return null;
        }
        ListNode dummyNode = new ListNode(0,head);
        int length = getLength(head);
        ListNode cur = dummyNode;
        for(int i=1;i<length-n+1;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummyNode.next;
        ListNodeUtils.printListNode(ans);
        return ans;

    }

    /**
     * 第二种解法：栈
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if(head == null){
            return null;
        }
        System.out.println("removeNthFromEnd2删除倒数第"+n+"个元素");
        ListNodeUtils.printListNode(head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        for(int i=0;i<n;i++){
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        ListNodeUtils.printListNode(ans);
        return ans;

    }

    /**
     * 第三种解法：双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        if(head == null){
            return null;
        }
        System.out.println("removeNthFromEnd3删除倒数第"+n+"个元素");
        ListNodeUtils.printListNode(head);
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for(int i=0;i<n;++i){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans =  dummy.next;
        ListNodeUtils.printListNode(ans);
        return ans;

    }

    private int getLength(ListNode head) {
        int length = 0;
        while(head != null){
            ++length;
            head = head.next;
        }
        return length;
    }
}
