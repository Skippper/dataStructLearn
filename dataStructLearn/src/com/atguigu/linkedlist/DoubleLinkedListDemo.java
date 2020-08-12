package com.atguigu.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "公孙胜", "入云龙");
        //
        DoubleLinkList doubleLinkList = new DoubleLinkList();
//        doubleLinkList.add(hero1);
//        doubleLinkList.add(hero2);
//        doubleLinkList.add(hero3);
//        doubleLinkList.add(hero4);
        doubleLinkList.addByOrder(hero1);
        doubleLinkList.addByOrder(hero2);
        doubleLinkList.addByOrder(hero3);
        doubleLinkList.addByOrder(hero4);

        doubleLinkList.showList();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4,"林冲","豹子头");
        doubleLinkList.update(newHeroNode);
        System.out.println("修改后链表情况");
        doubleLinkList.showList();

        //删除
        doubleLinkList.delete(3);
        System.out.println("删除后的链表情况");
        doubleLinkList.showList();
    }
}

class DoubleLinkList{

    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead(){
        return  head;
    }
    //添加节点到双向链表最后
    public void add(HeroNode2 heroNode){
        //因为头节点不能动,因此需要一个辅助变量tmp
        HeroNode2 temp = head;
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
        heroNode.pre = temp;
        //当退出循环时,temp指向了链表的最后
    }

    public void addByOrder(HeroNode2 heroNode){
        //头节点不能动,因此需要赋值变量来帮助找到添加的位置
        //因为单链表,因为我们找的temp是位于添加位置的前一个节点,否则添加不了
        HeroNode2 temp = head;
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

         if (temp.next!= null){
             heroNode.next = temp.next;
             temp.next.pre = heroNode;

         }
            heroNode.pre = temp;
            temp.next = heroNode;

            System.out.printf("英雄%s添加成功\n",heroNode.name);
        }

    }

    //修改链表,根据no编号来修改,即no编号不能变
    //1.根据newHeroNode 的no来修改即可
    public void update(HeroNode2 newHeroNode){
        //判断是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //定义一个辅助变量
        HeroNode2 temp = head.next;
        boolean flag = false;   //表示是否找到该节点
        while (true){
            if (temp== null){
                break;  //已经遍历完链表
            }
            if(temp.no == newHeroNode.no){
                //找到
                flag =true;
                break;
            }

            temp = temp.next;
        }
        if (flag){//表示找到
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {//没有找到
            System.out.printf("没有找到编号为%d的英雄,无法修改",newHeroNode.no);
        }
    }


    //删除节点,根据no编号来删除
    //对于双向链表 可以直接找到要删除的节点,找到之后,自我删除即可
    public void delete(int no){

        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode2 temp = head.next;  //头节点不能动,定义临时变量来接收
        boolean flag = false;   //判断是否有改英雄
        while (true){
            if (temp == null){
                break;  //已经遍历完链表
            }
            if (no == temp.no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }

        }else {
            System.out.printf("未找到编号为:%d的英雄,无法删除",no);
        }
    }

    public void showList(){
        //判断链表是否为空
        if (head.next == null){
            System.out.println("链表为空..");
            return;
        }
        //因为头节点不能动,因此需要辅助变量来遍历
        HeroNode2 temp = head.next;
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

class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;   //指向下一个节点
    public HeroNode2 pre;   //指向前一个节点
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname+ '}';
    }
}



