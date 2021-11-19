package com.deep.test.datastructure;

import java.util.LinkedList;

/**
 * @author hudepin
 * @Description
 * @ClassName LinkListStack
 * @create_date 2020.09.09 16:59
 * @since 1.2.0
 */
public class LinkListStack<T> {
    private LinkedList<T> data;
    private int size;
    private int count;
    public LinkListStack(){
        data = new LinkedList<T>();
    }
    public void push(T element){
        this.data.addLast(element);
        this.size = this.data.size();
    }
    public T poll(){
        T t = this.data.pollLast();
        this.size = this.data.size();
        return t;
    }
    public int size(){
        return this.size;
    }

    public static void main(String[] args) {
        LinkListStack linkListStack = new LinkListStack();
        for(int i=0;i<10;i++){
            linkListStack.push("1"+i);
        }
        System.out.println("size:"+linkListStack.size());
        for(int i=0;i<10;i++){
            System.out.println(linkListStack.poll());
        }
    }
}
