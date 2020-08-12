package com.atguigu.stack;

/**
 * 链表实现栈    ...有待改进
 */
public class LinkListStackDemo {

    public static void main(String[] args) {

        LinkListStack linkListStack = new LinkListStack();
        LinkListStackNode node1 = new LinkListStackNode(9,"代为");
        LinkListStackNode node2 = new LinkListStackNode(18,"李徐");
        LinkListStackNode node3 = new LinkListStackNode(3,"张浩");
        LinkListStackNode node4 = new LinkListStackNode(66,"张浩");

        linkListStack.pushStack(node1);
        linkListStack.pushStack(node2);
        linkListStack.pushStack(node3);
        linkListStack.pushStack(node4);


        linkListStack.showList();
        System.out.println("链表中的长度为:" + linkListStack.getLength());

        System.out.println("获得的出栈的值是" + linkListStack.popStack());
        System.out.println("获得的出栈的值是" + linkListStack.popStack());
        System.out.println("获得的出栈的值是" + linkListStack.popStack());
        linkListStack.showList();
    }
}

class LinkListStack{

    private LinkListStackNode top = new LinkListStackNode(-1,"" );

    public void pushStack(LinkListStackNode newNode){

        LinkListStackNode cur = top;
        boolean flag = false;
        while (true){
            if (cur.getNext() == null){
                break;
            }
            cur =cur.getNext();
        }
        cur.setNext(newNode);
    }

    public int getLength(){
        if (isEmpty()){
            return 0;
        }
        int length = 0;
        LinkListStackNode cur = top.getNext();
        while (true){
            if (cur == null){
                break;
            }
            length++;
            cur = cur.getNext();
        }
        return length;
    }

    public LinkListStackNode popStack(){
        if (isEmpty()){
            throw new RuntimeException("链表为空");
        }
        LinkListStackNode cur = top.getNext();
        while (true){
            if (cur.getNext() == null){
                break;
            }
            if (cur.getNext().getNext() == null){
                break;
            }
            cur = cur.getNext();
        }
        if (cur.getNext() == null){
            top.setNext(null);
            return cur;
        }
        LinkListStackNode returnNode = cur.getNext();
        cur.setNext(null);
        return returnNode;
    }

    public void  showList(){

        if (isEmpty()){
            System.out.println("链表为空");
            return;
        }
        LinkListStackNode cur = top.getNext();
        while (true){

            if (cur == null){
                break;
            }
            System.out.println(cur);

            cur = cur.getNext();
        }
    }

    public boolean isEmpty(){

        return top.getNext() == null;
    }
}

class LinkListStackNode{

    private int no;
    private String name;
    private LinkListStackNode next;

    public LinkListStackNode(int no, String name) {
        this.no = no;
        this.name = name;
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

    public LinkListStackNode getNext() {
        return next;
    }

    public void setNext(LinkListStackNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkListStackNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
