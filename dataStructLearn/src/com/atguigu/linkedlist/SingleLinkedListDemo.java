package com.atguigu.linkedlist;

import java.beans.beancontext.BeanContext;
import java.util.PrimitiveIterator;
import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);

        //显示
        singleLinkedList.showList();

         //反转链表
//        System.out.println("反转单链表~~");
//        singleLinkedList.reverseList(singleLinkedList.getHead());
//        singleLinkedList.showList();

        //测试逆序打印单链表
        System.out.println("逆序打印单链表:");
        SingleLinkedList.reversePrint(singleLinkedList.getHead());

        //测试修改节点
        HeroNode newHeroNode = new HeroNode(2,"小鲁","小赤佬");
        singleLinkedList.update(newHeroNode);

        //修改后显示
        System.out.println("修改后的链表为:");
        singleLinkedList.showList();

        //测试删除节点
        singleLinkedList.delete(4);
        //删除后显示
        System.out.println("删除后的链表为:");
        singleLinkedList.showList();

        System.out.println("该链表中有效个数是" + SingleLinkedList.getLength(singleLinkedList.getHead()));
        //看看是否得到倒数第
        System.out.println(SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(),1));

    }
}


//定义LinkedList 管理人物
class SingleLinkedList{
    //先初始化一个头节点,头节点不要动,不存放具体数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }

    //添加节点到单向链表
    //当不考虑编号顺序时
    //1.找到当前链表最后节点
    //2.将最后节点next指向新的节点
    public void add(HeroNode heroNode){
        //因为头节点不能动,因此需要一个辅助变量tmp
        HeroNode temp = head;
        //遍历链表,找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到最后,将temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
        //当退出循环时,temp指向了链表的最后
    }
    //第二种方式在添加英雄时,根据排名将英雄插入到指定位置
    //如果已经有这个排名,则添加失败
    public void addByOrder(HeroNode heroNode){
        //头节点不能动,因此需要赋值变量来帮助找到添加的位置
        //因为单链表,因为我们找的temp是位于添加位置的前一个节点,否则添加不了
        HeroNode temp = head;
        boolean flag = false;   //标志添加编号是否存在
        while (true) {
            if (temp.next==null){//说明temp已经在链表最后
                break;
            }
            if (temp.next.no>heroNode.no){//位置找到,就在temp后面插入
                break;
            }else if(temp.next.no == heroNode.no){//说明希望添加的heronode已经存在
                flag = true;//说明编号存在
                break;
            }
            temp = temp.next;   //后移,相当于遍历当前链表
        }

        if (flag){//不能添加,编号存在
            System.out.printf("英雄编号:%d已存在,无法继续添加\n",heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
            System.out.printf("英雄%s添加成功\n",heroNode.name);
        }

    }

    //修改链表,根据no编号来修改,即no编号不能变
    //1.根据newHeroNode 的no来修改即可
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //定义一个辅助变量
        HeroNode temp = head;
        boolean flag = false;   //表示是否找到该节点
        while (true){
            if (temp.next== null){
                break;  //已经遍历完链表
            }
            if(temp.next.no == newHeroNode.no){
                //找到
                flag =true;
                break;
            }

            temp = temp.next;
        }
        if (flag){//表示找到
            temp.next.name = newHeroNode.name;
            temp.next.nickname = newHeroNode.nickname;
        }else {//没有找到
            System.out.printf("没有找到编号为%d的英雄,无法修改",newHeroNode.no);
        }
    }

    /**
     * 获取链表倒数第K个节点
     * @param head
     * @param index
     * @return
     */
    public  static HeroNode findLastIndexNode(HeroNode head,int index){

        if (head.next == null){
            System.out.println("该链表为空");
            return null;
        }
        //第一次遍历得到链表长度
        int size = getLength(head);
        //第二次遍历 到size-index位置就是倒数的第K个节点
        //先做一个index校验
        if (index <=0 || index > size){
            return  null;
        }
        //定义一个辅助变量
        HeroNode cur = head.next;

        for (int i = 0; i <size - index ; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //使用栈结构实现逆序打印单链表 栈：先进后出
    public static void reversePrint(HeroNode head){

        if (head.next == null){
            return; //空链表
        }
        //创建一个栈,将各个节点压入栈点
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈点
        while (cur != null){
            stack.push(cur);
            cur = cur.next; //cur后移,这样就可以压入下一个节点
        }
        //将栈中的节点进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //获取单链表的节点的个数(如果带头节点,需要不统计头节点)

    /**
     *
     * @param head  链表的头节点
     * @return  返回有效节点个数
     */
    public static int getLength(HeroNode head){

        if (head.next == null){ //空链表
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;   //没有统计头节点
        while (cur != null){
                length ++;
                cur = cur.next; //遍历
        }
        return length;
    }


    //单链表的反转
    public void reverseList(HeroNode head){
        //如果当前链表为空或者只有一个节点,无需反转,直接返回
        if (head.next == null ||head.next.next == null){
            return;
        }
        //定义一个辅助变量
        HeroNode cur = head.next;
        HeroNode next = null;   //指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，每次遍历一个节点就将其取出,并放在新的链表reverseHead的最前端

        while (cur != null){
            next = cur.next;//先暂时保存当前节点的下一个节点,因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;
            cur = next; //让cur后移
        }
        //将head.next指向reverseHead.next，实现单链表反转
        head.next = reverseHead.next;
    }

    //删除节点,根据no编号来删除

    public void delete(int no){

        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;  //头节点不能动,定义临时变量来接收
        System.out.println("temp目前的值是" + temp);
        boolean flag = false;   //判断是否有改英雄
        while (true){
            if (temp.next == null){
                break;  //已经遍历完链表
            }
            if (no == temp.next.no){
                flag = true;
                break;
            }

            temp = temp.next;
            System.out.println("temp目前的值是" + temp);
        }

        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("未找到编号为:%d的英雄,无法删除",no);
        }
    }

    //显示链表
    public void showList(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空..");
            return;
        }
        //因为头节点不能动,因此需要辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //不为空 输出节点信息
            System.out.println(temp);
            //将temp后移   一定小心
            temp = temp.next;
        }
    }
}

//定义HeroNode,每个HerNode 对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;   //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname+ '}';
    }
}
