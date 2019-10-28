package com.deep.test.datastructure;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-10-17 10:33
 */
public class SingleLinkList<T> {
    private int size;
    private SingleListNode<T> head;
    public SingleLinkList(){
        this.size=0;
        this.head = null;
    }
    public void addHead(T entity){
        SingleListNode<T> node = new SingleListNode<T>(entity);
        if(head==null){
            head = node;
            return;
        }
        node.next=head;
        head = node;

    }
    public void addTail(T entity){
        SingleListNode<T> node = new SingleListNode<T>(entity);
        if(head == null){
            head = node;
            return;
        }
        SingleListNode<T> tmp = head;
        while(tmp != null){
            tmp = tmp.next;
        }
        tmp.next = node;
    }
    public int length(){
        SingleListNode<T> temp = head;
        int count=0;
        while(temp.next !=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
