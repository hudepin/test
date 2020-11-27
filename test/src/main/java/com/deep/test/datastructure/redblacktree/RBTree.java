package com.deep.test.datastructure.redblacktree;

/**
 * @author hudepin
 * @Description  https://www.cnblogs.com/skywang12345/p/3624343.html
 * @ClassName RBTree
 * @create_date 2020.10.29 12:04
 * @since 1.2.0
 */
public class RBTree {
    private RedBlackNode root;
    public void add(int key){
        RedBlackNode node = new RedBlackNode(key);
        if(root == null){
            root = node;
            node.setColor(Color.BLACK.toString());
            return;
        }
        RedBlackNode parent = root;
        RedBlackNode son = null;
        if(key <= parent.getKey()){
            son = parent.getLeft();
        }else{
            son = parent.getRight();
        }
        //find the poisition
        while(son != null){
            parent = son;
            if(key <= parent.getKey()){
                son = parent.getLeft();
            }else{
                son = parent.getRight();
            }
        }
        if(key <= parent.getKey()){
            parent.setLeft(node);
        }else {
            parent.setRight(node);
        }
        node.setParent(parent);
        insertFix(node);
    }

    /**
     * case 1：F为红，U为红
     * case 2：F为红，U为黑，并且，S为F的右儿子
     * case 3：F为红，U为黑，并且，S为F的左儿子
     * @param node
     */
    private void insertFix(RedBlackNode node) {
        RedBlackNode father = null,grandFather=null;
        // 若“父节点存在，并且父节点的颜色是红色”
        while((father = node.getParent()) != null && father.isRed()){
            grandFather = father.getParent();
            //若“父节点”是“祖父节点的左孩子”
            if(grandFather.getLeft() == father){
                //F 为G左儿子
                RedBlackNode uncle = grandFather.getRight();
                //F为红，U为红 Case 1条件：叔叔节点是红色
                if(uncle != null && uncle.isRed()){
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                //case 2叔叔是黑色，且当前节点是右孩子
                if(node == father.getRight()){
                    //左旋父节点
                    RedBlackNode tmp =null;
                    leftRotate(father);
                    tmp = father;
                    father = node;
                    node = tmp;
                }
                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(father);
                setRed(grandFather);
                rightRotate(grandFather);
            }else{
                //若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色
                RedBlackNode uncle = grandFather.getLeft();
                if(uncle != null && uncle.isRed()){
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                // // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if(node == father.getLeft()){
                    RedBlackNode tmp =null;
                    rightRotate(father);
                    tmp = father;
                    father = node;
                    node = tmp;
                }
                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(father);
                setRed(grandFather);
                leftRotate(grandFather);

            }

        }
        setBlack(this.root);
    }

    /*
  * 对红黑树的节点(y)进行右旋转
  *
  * 右旋示意图(对节点y进行左旋)：
  *            py                               py
  *           /                                /
  *          y                                x
  *         /  \      --(右旋)-.            /  \                     #
  *        x   ry                           lx   y
  *       / \                                   / \                   #
  *      lx  rx                                rx  ry
  *
  */
    private void rightRotate(RedBlackNode y) {
        RedBlackNode x =  y.getLeft();
        // 将 “x的右孩子” 设为 “y的左孩子”；
        // 如果"x的右孩子"不为空的话，将 “y” 设为 “x的右孩子的父亲”
        y.setLeft(x.getRight());
        if(x.getRight() != null){
            x.getRight().setParent(y);
        }
        //设置x的parent 为y的parent
        x.setParent(y.getParent());
        if(y.getParent() == null){
            this.root = x;
        }else{
            //设置y父节点的子节点由y -> x
            if(y == y.getParent().getRight()){
                y.getParent().setRight(x);
            }else{
                y.getParent().setLeft(x);
            }
        }
        x.setRight(y);
        y.setParent(x);
    }
    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \                #
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     *
     */
    private void leftRotate(RedBlackNode x) {
        RedBlackNode y =   x.getRight();
        x.setRight(y.getRight());
        if(y.getLeft() != null){
            y.getLeft().setParent(x);
        }
        y.setParent(x.getParent());
        if(x.getParent() == null){
            this.root = y;
        }else{
            if(x == x.getParent().getLeft()){
                x.getParent().setLeft(y);
            }else{
                x.getParent().setRight(y);
            }
        }
        y.setLeft(x);
        x.setParent(y);
    }

    public void setBlack(RedBlackNode node) {
       node.setColor(Color.BLACK.toString());
    }

    public void setRed(RedBlackNode node) {
        node.setColor(Color.RED.toString());
    }
}
