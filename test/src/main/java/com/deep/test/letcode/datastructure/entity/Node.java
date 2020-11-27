package com.deep.test.letcode.datastructure.entity;

/**
 * @author hudepin
 * @Description
 * @ClassName Node
 * @create_date 2020.09.16 18:04
 * @since 1.2.0
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node getRandom() {
        return random;
    }

    public void setRandom(Node random) {
        this.random = random;
    }
}
