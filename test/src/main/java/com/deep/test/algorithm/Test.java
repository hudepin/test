package com.deep.test.algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hudepin
 * @Description
 * @ClassName Test
 * @create_date 2020.04.11 22:13
 * @since 1.2.0
 */
public class Test {
    public static void main(String[] args) {
        PriorityQueue  queue = new PriorityQueue();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
    }
}
