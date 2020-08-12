package com.atguigu.stack;

import javax.sound.midi.Soundbank;
import java.util.Calendar;
import java.util.Scanner;

public class ArrayStackDemo {

    public static void main(String[] args) {
        //测试栈是否正确
        ArrayStack arrayStack = new ArrayStack(5);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show(s)显示栈");
            System.out.println("exit(e)退出");
            System.out.println("push()添加数据到栈");
            System.out.println("pop()从栈取出数据");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.showStack();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入数据");
                    int value = scanner.nextInt();
                    arrayStack.pushStack(value);
                    break;
                case "pop":
                    try {
                        int data = arrayStack.popStack();
                        System.out.printf("出栈的数据是%d\n",data);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}

//定义一个ArrayStack表示栈

class ArrayStack{

    private int maxSize;    //栈大小
    private int[] stack;    //数组,模拟栈
    private int top = -1;   //top表示栈顶,初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //判断栈是否满
    public boolean isFull(){

        return top  == maxSize - 1;
    }
    //判断是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    public void pushStack(int value){
        if (isFull()){
            System.out.println("栈满了");
            return;
        }

        top ++;
        stack[top] = value;
    }

    public int popStack(){

        if (isEmpty()){
           throw  new RuntimeException("栈为空");
        }

        int value = stack[top];
        top --;
        return value;
    }
    //显示栈的情况
    public void showStack(){

        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }

        for (int i = top; i >=0; i--) {
            System.out.printf("stack[%d] =%d\n",i,stack[i]);
        }
    }

    public int getLength(){
        if (isEmpty()){
            return  0;
        }

        return top +1;
    }
}
