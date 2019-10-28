package com.deep.test.datastructure;

/**
 * <p>Description:</p>
 * author:hudepin
 * createTime:2019-10-17 9:53
 */
public class SingleListNode<T> {
    public T value;
    public SingleListNode next;

    public SingleListNode(T value) {
        this.value = value;
    }

    public SingleListNode(T value, SingleListNode next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }
}
