package com.atguigu.tree;

/**
 * 顺序存储二叉树
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        //arrBinaryTree.preOrder();  // 1 2 4 5 3 6 7
        //arrBinaryTree.infixOrder();
        arrBinaryTree.postOrder();
    }
}

//编写ArrBinaryTree,实现顺序存储二叉树
class ArrBinaryTree{

    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        preOrder(0);
    }
    public void infixOrder(){
        infixOrder(0);
    }
    public void postOrder(){
        postOrder(0);
    }
    //编写方法,完成顺序存储二叉树前序遍历
    public void preOrder(int index){
        if (index < 0){
            System.out.println("索引错误");
            return;
        }
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向左递归
        if (2 * index +1 < arr.length){
            preOrder(2 * index +1);
        }
        //向右递归
        if (2 * index +2 < arr.length){
            preOrder(2 * index + 2);
        }
    }
    //中序
    public void infixOrder(int index){
        if (index < 0){
            System.out.println("索引错误");
            return;
        }
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        //先向左递归
        if (2 * index +1 < arr.length){
            infixOrder(2 * index +1);
        }
        //输出当前元素
        System.out.println(arr[index]);
        //向右递归
        if (2 * index +2 < arr.length){
            infixOrder(2 * index + 2);
        }
    }
    //后序
    public void postOrder(int index){
        if (index < 0){
            System.out.println("索引错误");
            return;
        }
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        //先向左递归
        if (2 * index +1 < arr.length){
            postOrder(2 * index +1);
        }
        //再向右递归
        if (2 * index +2 < arr.length){
            postOrder(2 * index + 2);
        }
        //输出当前元素
        System.out.println(arr[index]);
    }
}
