package com.atguigu.stack;

import java.util.Stack;

/**
 * 使用栈 实现计算器
 */
public class Calculate {

    public static void main(String[] args) {

        String expression = "30+2*6-2";
//        expression = expression.replaceAll(" ","");
//        System.out.println(expression.replaceAll("\\s",""));
//        //创建两个栈,一个数字栈,一个符号栈
//        ArrayStack2 numStack = new ArrayStack2(10);
//        ArrayStack2 operStack = new ArrayStack2(10);
//
//        //定义需要的相关变量
//        int index = 0;  //用于扫描
//        int num1 = 0;
//        int num2 = 0;
//        int oper = 0;
//        int res = 0;
//        char ch = ' ';  //将每次扫描得到的char保存到ch
//        String keepNum = ""; //用于拼接多位数
//        while (true){
//            //依次得到 expression的每一个字符
//            ch = expression.substring(index,index+1).charAt(0);
//            //判断 ch是什么, 做相应的处理
//            if (operStack.isOper(ch)){  //如果是运算符
//                if (!operStack.isEmpty()){
//                    //如果符号栈有操作符,进行比较,如果当前操作符优先级小于或等于栈中的操作符,就需要pop出两个数
//                    //从符号栈pop出一个符号,进行运算 将得到的结果, 入数栈,然后将当前的操作符入栈
//                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
//                        num1 = numStack.popStack();
//                        num2 = numStack.popStack();
//                        oper = operStack.popStack();
//                        res = numStack.calculate(num1,num2,oper);
//                        //把运算结果入数栈
//                        numStack.pushStack(res);
//                        operStack.pushStack(ch);
//                    }else {
//                        operStack.pushStack(ch);
//                    }
//                }else { //为空直接入栈
//                    operStack.pushStack(ch);
//                }
//            }else { //如果是数字，则直接入数栈  //此种方式多位数会出错
//                //numStack.pushStack(ch - 48);    // '1' - 48 = 1
//
//                //如果是多位数时候,不能直接入栈,
//                //在处理数字时 需要像expression的表达式的index后再看一位,如果是数就进行扫描,如果是符号就入栈
//
//                //处理多位数
//                keepNum += ch;
//                //注意是不是最后一位
//                if (index == expression.length()-1){
//                    numStack.pushStack(Integer.parseInt(keepNum));
//                }else {
//                    //判断下一个数字是不是数字,如果是就继续扫描,如果是运算符,入栈
//                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
//                        //如果后一位是运算符,入栈
//                        numStack.pushStack(Integer.parseInt(keepNum));
//                        //重要！！！keepNum清空
//                        keepNum = "";
//                    }
//                }
//            }
//
//            index ++;
//            if (index ==expression.length()){
//                break;
//            }
//        }
//
//        //当表达式扫描完毕,就顺序的从数栈和符号栈中pop出相应的数和符号,并执行
//        while (true){
//            if (operStack.isEmpty()){
//                break;
//            }
//
//            num1 = numStack.popStack();
//            num2 = numStack.popStack();
//            oper = operStack.popStack();
//            res = numStack.calculate(num1,num2,oper);
//            numStack.pushStack(res);
//        }
//        //数栈中最后存的数字就是结果
//        System.out.printf("表达式%s是%d\n",expression,numStack.popStack());
        ArrayStack2 operStack = new ArrayStack2(10);
        ArrayStack2 numStack = new ArrayStack2(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";

        while (true) {
            ch = expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){
                if (!operStack.isEmpty()){
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.popStack();
                        num2 = numStack.popStack();
                        oper = operStack.popStack();
                        res = numStack.calculate(num1,num2,oper);
                        numStack.pushStack(res);
                        operStack.pushStack(ch);
                    }else {
                        operStack.pushStack(ch);
                    }
                }else {
                    operStack.pushStack(ch);
                }
            }else {
                //numStack.pushStack(ch - 48);  此条只适合单个位数字
                keepNum += ch;

                if (index == expression.length() -1){
                    numStack.pushStack(Integer.parseInt(keepNum));
                }else {
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.pushStack(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }


            }

            index++;
            if (index == expression.length()) {
                break;
            }
        }

        while (true){
            if (operStack.isEmpty()){
                break;
            }

            num1 = numStack.popStack();
            num2 = numStack.popStack();
            oper = operStack.popStack();
            res = numStack.calculate(num1,num2,oper);
            numStack.pushStack(res);
        }

        System.out.printf("表达式%s=%d",expression,numStack.popStack());

    }
}

class ArrayStack2 {

    private int maxSize;    //栈大小
    private int[] stack;    //数组,模拟栈
    private int top = -1;   //top表示栈顶,初始化为-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //返回运算符优先级,优先级是由程序员来定，优先级使用数字来定,数字越大,优先级越高
    public int priority(int oper) {

        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //查看当前栈顶的值,但不是出栈
    public int peek() {
        return stack[top];
    }

    //判断是否是运算符
    public boolean isOper(char key) {

        return key == '+' || key == '-' || key == '*' || key == '/';
    }

    //计算方法
    public int calculate(int num1, int num2, int oper) {

        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;  //注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


    //判断栈是否满
    public boolean isFull() {

        return top == maxSize - 1;
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    public void pushStack(int value) {
        if (isFull()) {
            System.out.println("栈满了");
            return;
        }

        top++;
        stack[top] = value;
    }

    public int popStack() {

        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }

        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况
    public void showStack() {

        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] =%d\n", i, stack[i]);
        }
    }

    public int getLength() {
        if (isEmpty()) {
            return 0;
        }

        return top + 1;
    }
}
