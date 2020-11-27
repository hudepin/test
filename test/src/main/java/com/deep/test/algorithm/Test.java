package com.deep.test.algorithm;

import java.util.*;

/**
 * @author hudepin
 * @Description
 * @ClassName Test
 * @create_date 2020.04.11 22:13
 * @since 1.2.0
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer>  queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        Map<Integer,Integer> map = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.add(entry.getValue());
        }

    }
}
