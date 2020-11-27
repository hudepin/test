package com.deep.test.letcode.datastructure;

import com.deep.test.entity.User;
import com.deep.test.letcode.datastructure.entity.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hudepin
 * @Description
 * @ClassName Solution
 * @create_date 2020.09.15 15:17
 * @since 1.2.0
 */
public class Solution {
    public static void main(String[] args) {
       ListNode head = initListNode();
        //System.out.println(isPalindrome(head));
        int[] arr1 = {7,1,6};
        int[] arr2 = {5,9,5};
        ListNode l1 = initByArr(arr1);
        ListNode l2 = initByArr(arr2);
        ListNode resNode = addTwoNumbers(l1,l2);
        printListNode(resNode);
        User u = new User("hudepin");
        User u1 =u;
        u = new User("deewd");
        User u2 = u;
        System.out.println(u1.equals(u2));
        //操作数
        ListNode mid = new ListNode(0);
        //返回头节点
        ListNode anws = mid ;
        mid.next = new ListNode(0);
        mid = new ListNode(0);
        System.out.println(anws);
    }

    private static void printListNode(ListNode addTwoNumbers) {
        while(addTwoNumbers != null){
            System.out.println(addTwoNumbers.val);
            addTwoNumbers = addTwoNumbers.next;
        }
    }

    private static ListNode initByArr(int[] arr1) {
        ListNode head = new ListNode(arr1[0]);
        for(int i=1;i<arr1.length;i++){
            ListNode node = new ListNode(arr1[i]);
            addListNode(head,node);
        }
        return head;
    }


    static void addListNode(ListNode head,ListNode insertNode){
        ListNode last = head;
        //找到最后一个节点
        while(last.next != null){
            last = last.next;
        }
        last.next = insertNode;
    }

    private static ListNode initListNode() {
        ListNode head = new ListNode(1);

        ListNode node1 = new ListNode(3);
        head.next=node1;
        ListNode node2 = new ListNode(2);
        node1.next=node2;

        ListNode node3 = new ListNode(4);
        node2.next=node3;
        ListNode node4 = new ListNode(3);
        node3.next=node4;
        ListNode node5 = new ListNode(2);
        node4.next=node5;
        ListNode node6 = new ListNode(1);
        node5.next=node6;


//
        return head;
    }


    /**
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null ){
            return true;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode right = dummyNode;
        ListNode fast = head;
        //找出链表后半部分
        while(fast != null && fast.next != null){
            right = right.next;
            fast = fast.next.next;
        }
        if(fast !=null){
            //奇数
            right=right.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = right;
        ListNode pre = dummy.next;
        ListNode cur = pre.next;
        while(cur != null){
            pre.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = pre.next;
        }
        ListNode reverseListNode = dummy.next;
        while(reverseListNode != null && head != null){
            if(reverseListNode.val != head.val){
                return false;
            }else{
                reverseListNode = reverseListNode.next;
                head = head.next;
            }
        }
        return true;





    }

    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     *
     * 这些数位是反向存放的，也就是个位排在链表首部。
     *
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //初始进位为0
        int pre = 0;
        //操作数
        ListNode mid = new ListNode(0);
        //返回头节点
        ListNode anws = mid ;
        //当l1和l2都不为null时进入while循环
        while(l1!=null&&l2!=null){
            //操作数赋值
            mid.val = (l1.val+l2.val+pre)%10;
            //更新进位
            pre = (l1.val+l2.val+pre)/10;
            //更新头节点
            l1 = l1.next;
            l2=l2.next;
            //头节点更新后判断是否为空
            if(l1==null){
                //如果l1头节点为空且进位为0，则操作数的next直接为l2剩下的
                if(pre==0) {
                    mid.next = l2;
                    return anws;
                }else {
                    //如果有进位，则递归调用addTwoNumbers方法
                    mid.next = addTwoNumbers(l2,new ListNode(pre));
                    return anws;
                }
            }
            //同上
            if(l2 == null){
                if(pre==0) {
                    mid.next = l1;
                    return anws;
                }else {
                    mid.next = addTwoNumbers(l1,new ListNode(pre));
                    return anws;
                }
            }
            //l1 l2更新后都不为null，则设置操作数为0 进入下一次while循环
            mid.next =new ListNode(0);
            mid = mid.next;
        }
        //l1为null，直接不能进入上面while循环的情况下，直接返回l2
        if(l1==null){
            return l2;
        }//同上
        else if(l2 ==null){
            return l1;
        }
        return anws;

    }

    /**
     * 141. 环形链表
     * 给定一个链表，判断链表中是否有环。

     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while(head != null){
            if(nodesSeen.contains(head)){
                return true;
            }else{
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;

    }
}
