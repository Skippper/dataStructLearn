package com.atguigu.tree.threadbinarytree;

public class MyBinaryTree {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9};
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < arr.length; i++) {
            binaryTree.add(new Node(arr[i]));
        }
        //遍历二叉排序树
        binaryTree.infixOrder();
    }
}

class BinaryTree{
    private Node root;

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else {
            System.out.println("树为空");
        }
    }
}
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node search(int value){
        if (value == this.value){//找到就是该节点
            return this;
        }else if (value < this.value){//查找的值小于当前节点,像左子树递归查找
           if (this.left == null){
               return null;
           }
           return  this.left.search(value);
        }else {
            if (this.right == null){
                return null;
            }
            return  this.right.search(value);
        }
    }
    //查找要删除节点的父节点

    /**
     *
     * @param value 要找到节点的值
     * @return 返回的是要删除节点的父节点,没有返回null
     */
    public Node searchParent(int value){
        if ((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)){
            //当前左或右节点值为要删除节点值,当前节点则就父节点
            return this;
        }else {
            if ( value < this.value && this.left != null){
                return this.left.searchParent(value);//向左子树递归查找
            }else if (value > this.value && this.right != null){
                return this.right.searchParent(value); //像右子树递归查找
            }else {
                return null;    //没有找到父节点
            }

        }
    }

    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.infixOrder();
        }
    }
    public void add(Node node){
        if (node == null){
            return;
        }
        if (node.value < this.value){
            if (this.left != null){
                this.left.add(node);
            }else {
                this.left = node;
            }
        }else {
            if (this.right != null){
                this.right.add(node);
            }else {
                this.right = node;
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
