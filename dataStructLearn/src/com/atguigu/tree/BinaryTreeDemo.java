package com.atguigu.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        //先创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "公孙胜");
        HeroNode node5 = new HeroNode(5, "关胜");

        //先手动创建二叉树,之后递归创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);
        //测试
//        System.out.println("前序遍历");
//        binaryTree.preOrder();
//        System.out.println("中序");
//        binaryTree.infixOrder();
//        System.out.println("后序");
//        binaryTree.postOrder();
//
//        System.out.println("前序查找");
//        HeroNode node = binaryTree.preOrderSearch(10);
//        if (node != null){
//            System.out.println(node);
//        }else {
//            System.out.println("未找到");
//        }
//
//        System.out.println("中序查找");
//        HeroNode infixNode = binaryTree.infixOrderSearch(5);
//        System.out.println(infixNode);
//        System.out.println("后序查找");
//        HeroNode postNode = binaryTree.postOrderSearch(2);
//        System.out.println(postNode);
            System.out.println("删除前,前序遍历");
            binaryTree.preOrder();
            binaryTree.delNode(3);
            System.out.println("删除后,前序遍历");
            binaryTree.preOrder();

    }
}

//创建二叉树
class BinaryTree {
    private HeroNode root;  //根节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            //如果只有一个节点,判断root是否是删除节点
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("树空,无法删除");
        }
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.perOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }
    public void insert(HeroNode node){
        if (root != null){
            root.insert(root,node);
        }else {
            System.out.println("...");
        }
    }

}

//创建节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;  //默认null
    private HeroNode right; //默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //二叉树删除节点
    //如果删除节点是叶子节点,直接删除
    //如果删除节点非叶子节点,删除子树
    public void delNode(int no) {

//        1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
//        2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
//        3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
//        4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
//        5.  如果第4步也没有删除结点，则应当向右子树进行递归删除.

        // 2. 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        //3. 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //4. 如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }

    }


    //编写前序遍历方法
    public void preOrder() {
        System.out.println(this);//先输出父节点
        //递归向左子树递归
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树递归
        if (this.right != null) {
            this.right.preOrder();
        }
    }
    public void insert(HeroNode targer, HeroNode newNode){
        if (newNode.no < targer.no){
            if (targer.left != null){
                insert(targer.left,newNode);
            }else {
                targer.left = newNode;
            }
        }else {
            if (targer.right != null){
                insert(targer.right,newNode);
            }else {
                targer.right = newNode;
            }
        }
    }
    public void add(HeroNode node){

    }

    //前序遍历查找
    public HeroNode perOrderSearch(int no) {
        //比较当前节点是否是
        if (this.getNo() == no) {
            return this;
        }
        //判断当前节点左节点是否为空,不为空则递归前序查找
        //如果左递归前序查找找到就返回
        HeroNode resNode = null;
        if (this.getLeft() != null) {
            resNode = this.left.perOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //左递归没找到,判断当前节点右子树是否为空,如果不空,继续右递归前序查找
        if (this.right != null) {
            resNode = this.right.perOrderSearch(no);
        }
        return resNode;
    }

    //编写中序遍历方法
    public void infixOrder() {
        //先递归向左子树递归
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);//输出父节点
        //递归向右子树递归
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //中序遍历查找
    public HeroNode infixOrderSearch(int no) {

        //先判断当前节点左节点是否为空,不为空则递归中序查找
        //如果左递归中序查找找到就返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //比较当前节点是否是
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    //编写后序遍历方法
    public void postOrder() {
        //先递归向左子树递归
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树递归
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);//输出父节点
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {

        //先判断当前节点左节点是否为空,不为空则递归中序查找
        //如果左递归中序查找找到就返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        //比较当前节点是否是
        if (this.no == no) {
            return this;
        }

        return resNode;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}
