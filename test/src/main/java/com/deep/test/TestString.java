package com.deep.test;

import java.util.*;

/**
 * @author hudepin
 * @Description
 * @ClassName TestString
 * @create_date 2020.11.16 14:02
 * @since 1.2.0
 */
public class TestString{
    public static void main(String[] args) {
        String rowsValue="2021-03-02";
        System.out.println(rowsValue.replaceAll("-","/"));
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("3");
        System.out.println(Collections.max(list));
        list.stream().forEach(s->{

        });
        System.out.println(System.currentTimeMillis());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(2);
        minHeap.offer(1);
        minHeap.offer(3);
        minHeap.offer(5);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((v1,v2)->{return v2-v1;});
        maxHeap.offer(5);
        maxHeap.offer(1);
        maxHeap.offer(3);
        maxHeap.poll();
        while(!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }
}
