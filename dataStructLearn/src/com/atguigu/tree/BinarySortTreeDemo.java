package com.atguigu.tree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        Node root = new Node(7);
        Node node2 = new Node(3);
        Node node3 = new Node(10);
        Node node4 = new Node(12);
        Node node5 = new Node(5);
        Node node6 = new Node(1);
        Node node7 = new Node(9);
        tree.add(root);
        tree.add(node2);
        tree.add(node3);
        tree.add(node4);
        tree.add(node5);
        tree.add(node6);
        tree.add(node7);
        tree.list(root);
    }
}

class BinarySortTree{
    private Node root;

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }
    public void list(Node node){
       if (node == null){
           return;
       }
       list(node.left);
        System.out.println(node);
       list(node.right);
    }
}

class Node{
    int value;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }


    public void infixOrder(){
        if (this.left != null){
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
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
}
