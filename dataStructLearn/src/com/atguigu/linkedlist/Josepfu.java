package com.atguigu.linkedlist;

/**
 * 约瑟夫问题  环形链表
 */
public class Josepfu {
    public static void main(String[] args) {
        //环形链表测试

        CircleSingleLinkedList circleList = new CircleSingleLinkedList();
//        System.out.println("链表为");
//        circleList.showBoyList();

        //测试出圈是否正确
        circleList.countBoy(1, 2, 5); //出圈顺序应为2,4,1,5,3
    }
}

//创建环形单向链表
class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = null;
//    //添加小孩,构建成一个环形链表
//
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值必须大于1");
            return;
        }
        Boy curBoy = null;  //辅助变量,帮助构建环形链表
        //使用for 创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号 创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);   //构成环
                curBoy = first; //让curBoy指向第一个小孩
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);//
                curBoy = boy;
            }
        }
    }


    //遍历环形链表
    public void showBoyList() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空...");
            return;
        }
        //first不能动,定义一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号为%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) {//说明遍历完毕
                break;
            }
            curBoy = curBoy.getNext();  //让curBoy后移
        }
    }


    //根据用户输入 计算小孩出圈顺序

    /**
     * @param startNo  表示从第几个小孩开始
     * @param countNum //表示数几下
     * @param nums     //表示最初有多少小孩在链表中
     */
//    public void countBoy(int startNo, int countNum, int nums) {
//        addBoy(nums);
//        //校验数据
//        if (first == null || startNo < 1 || startNo > nums) {
//            System.out.println("参数输入有问题..重新输入");
//            return;
//        }
//        Boy helper = first; //辅助指针,帮助计算
//        while (true) {
//
//            if (helper.getNext() == first) { //说明helper指向了最后剩下的小孩节点
//                break;
//            }
//
//            helper = helper.getNext();
//        }
//        //小孩报数前,让 helper 和first 移动 K-1次
//        for (int i = 0; i < startNo -1; i++) {
//            first = first.getNext();
//            helper = helper.getNext();
//        }
//        //小孩报数出圈时,让first 和helper同时移动 countNum- 1 次
//
//        while (true){
//            if (helper == first){   //说明圈中只有一个节点
//                break;
//            }
//            //
//            //让first 和helper同时移动 countNum- 1 次
//            for (int j = 0; j < countNum -1; j++) {
//                helper = helper.getNext();
//                first = first.getNext();
//            }
//            //  这时 first指向的节点就是出圈的节点
//            System.out.printf("小孩%d出圈\n",first.getNo());
//            //让first指向的节点出圈
//            first = first.getNext();
//            helper.setNext(first);  //让helper和现在的first连接起来
//        }
//        System.out.printf("最后留在的圈中的小孩编号为%d\n",first.getNo());
//    }
    public void countBoy(int startNo, int countNum, int nums){
        addBoy(5);
        if (first == null || startNo < 1 || startNo > nums){
            System.out.println("输入不合法,请重新输入");
            return;
        }
        Boy helper = first;
        while (helper.getNext() != first){
            helper = helper.getNext();
        }

        for (int i = 0; i < startNo -1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (true){

            if (helper == first){
                break;
            }

            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("出圈小孩%d\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后的小孩是" + first.getNo());
    }
}

class Boy {

    private int no;
    private Boy next;   //  指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }


}
