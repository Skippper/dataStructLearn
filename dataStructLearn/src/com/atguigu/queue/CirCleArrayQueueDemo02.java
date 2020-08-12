package com.atguigu.queue;

import java.util.Scanner;

public class CirCleArrayQueueDemo02 {

    public static void main(String[] args) {

        CirCleArray queue = new CirCleArray(4); //说明:这里设置的是队列有效数据为3
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }
}

class CirCleArray{

    private int front;  //数组头部,指向数组的第一个位置 默认为0
    private int rear;   //数组尾部,指向数组最后一个位置前一个位置 默认为0
    private int maxSize; //数组最大值
    private int [] arr; //模拟队列的数组

    public CirCleArray(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        //front = 0;
        //rear = 0; //  默认为0,可以不写
    }

    public boolean isFull(){
        return (rear+1) % maxSize == front;
    }

    public boolean isEmpty(){
        return front == rear;
    }
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        //将rear后移一位,此地方必须考虑取余
        rear = (rear+1) % maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空");
        }
        //定义一个临时变量,用于返回；
        int value = arr[front];
        front = (front +1) % maxSize;
        return value;
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }

        for (int i = front; i < front + getSize() ; i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    //获取有效数据
    public int getSize(){
        return (rear-front+maxSize) % maxSize;
    }

    public int headQueue(){
        if ((isEmpty())){
            throw new RuntimeException("队列为空");
        }
        return arr[front];

    }

}
