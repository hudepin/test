package com.deep.test.datastructure;

import java.util.Arrays;

/**
 * @author hudepin
 * @Description
 * @ClassName ArrayStack
 * @create_date 2020.09.09 16:25
 * @since 1.2.0
 */
public class ArrayStack {
    private String[] data;
    private int size;//栈的大小
    private int count = 0;//当前栈的位置
    public ArrayStack(int size){
        this.size=size;
        this.data = new String[size];
    }
    public void push(String element){
        if(count<size){
           data[count]=element;
           ++count;
        }else{
            //扩容
            String[] temp = this.data;
            this.size = 2*size;
            this.data = Arrays.copyOf(temp,size);
            data[count]=element;
            ++count;
        }
    }
    public String poll(){
        return this.data[--count];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(2);
        for(int i=0;i<10;i++){
            arrayStack.push("1"+i);
        }
        for(int i=0;i<10;i++){
            System.out.println(arrayStack.poll());
        }

    }

}
