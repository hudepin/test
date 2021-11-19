package com.deep.test.letcode.datastructure;

import com.deep.test.letcode.datastructure.entity.ListNode;
import com.deep.test.letcode.datastructure.entity.Node;

/**
 * @author hudepin
 * @Description
 * @ClassName ListNodeUtils
 * @create_date 2020.09.16 09:47
 * @since 1.2.0
 */
public class ListNodeUtils {
    /**
     * 插入
     *
     * @param currentNode
     * @param insertNode
     * @return
     */
    public static ListNode add(ListNode currentNode, ListNode insertNode) {
        ListNode next = currentNode.next;
        currentNode.next = insertNode;
        insertNode.next = next;
        return insertNode;
    }

    /**
     * 链表尾部插入元素
     *
     * @param head
     * @param insertNode
     * @return
     */
    public static ListNode addLast(ListNode head, ListNode insertNode) {
        if (head == null) {
            return insertNode;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = insertNode;
        insertNode.next = null;
        return head;
    }


    /**
     * 链表头部插入元素
     *
     * @param head
     * @param inserNode
     * @return
     */
    public static ListNode addFirst(ListNode head, ListNode inserNode) {
        if (head == null) {
            return inserNode;
        }
        ListNode next = head.next;
        head.next = inserNode;
        inserNode.next = next;
        return head;
    }

    /**
     * 删除节点
     * @param removeNode
     */
    public static void remove(ListNode removeNode){
        removeNode.val = removeNode.next.val;
        removeNode.next = removeNode.next.next;
    }

    /**
     * 根据value 删除节点
     * @param head
     * @param val
     * @return
     */
    public static ListNode remove(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode deleteNode = dummy.next;
        while (deleteNode != null) {
            if (deleteNode.val == val) {
                pre.next = deleteNode.next;
                return dummy.next;
            }
            deleteNode = deleteNode.next;
            pre = pre.next;
        }
        return dummy.next;

    }

    public static ListNode initByArr(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            addLast(head, node);
        }
        return head;
    }

    public static void printListNode(ListNode head) {
        System.out.println("");
        ListNode temp = head;
        int i=0;
        while (temp != null) {
            if(i==0){
                System.out.print(temp.val);
            }else{
                System.out.print( "->"+temp.val );
            }
            i++;
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        ListNode head = initByArr(arr);
//        System.out.println("init listNode");
//        //printListNode(head);
//        ListNode removeHead = remove(head, 5);
//        System.out.println("remove 2");
//        printListNode(removeHead);
          Node head = initNode();
          Node node = copyRandomList(head);
          System.out.printf("node:"+node);



    }

    /**
     * 138. 复制带随机指针的链表
     * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
     *
     * 要求返回这个链表的 深拷贝。 
     *
     * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     *
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node temp =  head;
        while(temp != null){
            Node next = temp.next;
            //copy a node
            Node newNode = new Node(temp.val);
            if(temp.random != null){
                //copy a random
                Node newRandowNode = new Node(temp.random.val);
                newNode.random = newRandowNode;
            }else{
                newNode.random=null;
            }
            temp.next = newNode;
            newNode.next = next;
            temp = next;
        }
        Node dummy = new Node(-1);
        dummy.next = head.next;
        Node newHead  = head.next;
        while(newHead != null){
            newHead.next = newHead.next.next;
            newHead = newHead.next.next;
        }
        return dummy.next;

    }
    public static Node initNode(){
        Node head = new Node(7);
        Node node1 = new Node(13);
        node1.setRandom(new Node(0));
        addLast(head,node1);
        Node node2 = new Node(11);
        node2.setRandom(new Node(4));
        addLast(head,node2);
        Node node3 = new Node(10);
        node3.setRandom(new Node(2));
        addLast(head,node3);
        Node node4 = new Node(1);
        node4.setRandom(new Node(0));
        addLast(head,node4);
        return head;
    }

    public static Node addLast(Node head, Node insertNode) {
        if (head == null) {
            return insertNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = insertNode;
        insertNode.next = null;
        return head;
    }
}
