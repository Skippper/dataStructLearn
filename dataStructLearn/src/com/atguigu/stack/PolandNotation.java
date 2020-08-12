package com.atguigu.stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //
        String suffixExpression = "30 4 + 5 * 6 -";
        String suffixExpression2 = "1 2 3 + 4 * + 5 -";
//        //思路
//        //1.先将 "3 4 + 5 x 6 -" 放入到Arraylist中
//        //2.将ArrayList 传递给一个方法,遍历集合,配合栈,完成计算
        List<String> rpnList = getListString(suffixExpression2);
        System.out.println(rpnList);

        int res = calculate(rpnList);
        System.out.println("运算的结果是" + res);

        String expression = "10+(2*3+8)/40";
        List<String> list = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的list:" + list);



        List<String> suffixExpressionList = parseSuffixExpressionList(list);

        System.out.println("后缀表达式对应的List为" + suffixExpressionList);
        System.out.println("中缀表达式运算结果是" + calculate(suffixExpressionList));


    }

    //讲中缀表达式转换成后缀表达式
//    public static List<String> parseSuffixExpressionList(List<String> ls){
//        //定义两个栈
//        Stack<String> s1 = new Stack<>();   //符号栈
//        //s2在整个过程中没有出栈,可用一个ArrayList替代
//        //Stack<String> s2 = new Stack<>();   //存储中间结果的栈
//        List<String> s2 = new ArrayList<>();
//        //遍历ls
//        for (String ele : ls) {
//            //如果是数字入栈
//            if (ele.matches("\\d+")){
//                s2.add(ele);
//            }else if (ele.equals("(")){
//                s1.push(ele);
//            }else if (ele.equals(")")){
//                //如果是右括号,依次弹出s1栈顶的运算符,并压入s2,知道遇到左括号为止,此时一堆括号将抛弃;
//                while (!s1.peek().equals("(")){
//                    s2.add(s1.pop());
//                }
//                s1.pop();   //!!!将(弹出 s1
//            }else {
//                //当ele优先级<=是s1栈顶运算符,s1栈顶运算符弹出并压入s2中
//                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(ele)){
//                    s2.add(s1.pop());
//                }
//                //还需要将ele压入s1
//                s1.push(ele);
//            }
//        }
//        //将s1中剩余运算符弹出并压入s2
//        while (s1.size() != 0){
//            s2.add(s1.pop());
//        }
//        return s2;  //因为是存放在集合,所以按顺序输出即中缀对应的后缀(逆波兰)表达式
//
//    }

    //  方法:将中缀表达式转成对应list
//    public static List<String> toInfixExpressionList(String s) {
//
//        List<String> list = new ArrayList<>();
//
//        int index = 0;  //指针,用于遍历字符串s
//        String str; //对多位数的拼接工作
//        char c; //  每遍历到一个字符就放入到c
//
//        do {
//            //如果c是非数字
//            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57) {
//                list.add("" + c);
//                index++;    //后移
//            } else { //如果是一个数,需要考虑多位数
//
//                str = "";
//                while (index < s.length() && (c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57) {
//                    str += c;   //拼接
//                    index++;
//                }
//                list.add(str);
//            }
//        } while (index < s.length());
//
//        return list;    //返回
//    }

    public static List<String> parseSuffixExpressionList(List<String> ls){
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (String ele : ls) {
            if (ele.matches("\\d+")){
                s2.add(ele);
            }else if (ele.equals("(")){
                s1.push(ele);
            }else if (ele.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
               while (s1.size()!=0 && Operation.getValue(ele) <= Operation.getValue(s1.peek())){
                   s2.add(s1.pop());
               }
                s1.add(ele);
            }
        }

        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;
    }

    public static List<String> toInfixExpressionList(String s){

        List<String> list = new ArrayList<>();
        int index = 0;
        String str ;
        char c;
        do {
            if ((c = s.charAt(index)) < 48 || (c = s.charAt(index)) > 57){
                list.add(c + "");
                index++;
            }else {
                str = "";
               while (index < s.length() && (c = s.charAt(index)) >= 48 && (c = s.charAt(index)) <= 57){
                   str += c;
                   index++;
               }
                list.add(str);
            }
        }while (index < s.length());

        return list;
    }


    public static List<String> getListString(String suffixExpression) {
        String[] strs = suffixExpression.split(" ");

        List<String> list = new ArrayList<>();
        for (String ele : strs) {
            list.add(ele);
        }

        return list;
    }


    public static int calculate(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
//        int num1 = 0;
//        int num2 = 0;
//        int res = 0;
        for (String ele : list) {

            if (ele.matches("\\d+")) {
                stack.push(ele);
            } else {
               int num2 = Integer.parseInt(stack.pop());
               int num1 = Integer.parseInt(stack.pop());
               int res = 0;
                if (ele.equals("+")) {
                    res = num1 + num2;
                } else if (ele.equals("-")) {
                    res = num1 - num2;
                } else if (ele.equals("*")) {
                    res = num1 * num2;
                } else if (ele.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算有误.");
                }
                stack.push("" + res);
            }
        }
        //最后stack中的数据就是结果
        return Integer.parseInt(stack.pop());
    }
}

//编写一个类,可以返回运算符对应的优先级
class Operation{
    private static  int ADD = 1;
    private static  int SUB = 1;
    private static  int MUL = 2;
    private static  int DIV = 2;

    //写一个方法返回对应数字
    public static int getValue(String operator){

        int result = 0;
        switch (operator){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
                default:
                    break;
        }
        return result;
    }
}


