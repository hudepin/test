package com.deep.test.datastructure.redblacktree;

/**
 * @author hudepin
 * @Description
 * 红黑树是一颗二叉查找树，且具有如下特性：
    (1) 每个节点或者是黑色，或者是红色。
    (2) 根节点是黑色。
    (3) 每个叶子节点是黑色。 [注意：这里叶子节点，是指为空的叶子节点！]
    (4) 如果一个节点是红色的，则它的子节点必须是黑色的。
    (5) 从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑色节点。
 * @ClassName RedBlackNode
 * @create_date 2020.10.29 11:59
 * @since 1.2.0
 */
public class RedBlackNode {
    private String color =Color.RED.toString();
    private int key;
    private  RedBlackNode left;
    private RedBlackNode right;
    private RedBlackNode parent;
    public RedBlackNode(int key){
        //默认构建的节点是红色节点
        color = Color.RED.toString();
    }



    public RedBlackNode getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode left) {
        this.left = left;
    }

    public RedBlackNode getRight() {
        return right;
    }

    public void setRight(RedBlackNode right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    boolean isRed(){
        return this.color.equals(Color.RED.toString())?true:false;
    }
}
