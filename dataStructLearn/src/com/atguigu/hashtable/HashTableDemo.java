package com.atguigu.hashtable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {

        HashTable hashTable = new HashTable(7);

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("add(添加雇员)");
            System.out.println("list(显示雇员)");
            System.out.println("exit(退出系统)");
            String key = sc.nextLine();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = sc.nextInt();
                    System.out.println("输入名字");
                    String name = sc.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "find":
                    System.out.println("请输入查找id");
                    int no = sc.nextInt();
                    hashTable.findEmpById(no);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    break;
            }

        }
    }
}

//创建hashtable
class HashTable {
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示有多少条链表

    public HashTable(int size) {
        //初始化EmpLinkedList
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        //要分别初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工id 得到员工该添加到哪个链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //根据id查询员工
    public void findEmpById(int id){
        int empLinkListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkListNo].findEmpById(id);
        if (emp != null){
            System.out.printf("在第%d条链表中找到 雇员id = %d",empLinkListNo +1,emp.id);
        }else {

        }
    }

    //遍历
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].listEmp((i));
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
}

class EmpLinkedList {
    //头指针 指向第一个雇员 ∴ head直接指向第一个雇员
    private Emp head;

    //添加雇员到链表
    //1.假定 添加雇员时 id是自增长,即id的分配zzo总是从小到大
    // 因此讲该雇员直接添加到本链表的最后
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个,使用辅助指针
        Emp cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        //退出循环时将新雇员加入链表
        cur.next = emp;
    }

    public Emp findEmpById(int id){
        if (head == null){
            return null;
        }
        Emp cur = head;
        while (true){
            if (cur.id == id){
                return cur;
            }
            if (cur.next == null){
                System.out.println("没找到");
                return null;
            }
            cur = cur.next;
        }
    }
    //遍历链表雇员信息
    public void listEmp(int no) {
        if (head == null) {
            System.out.println("第" + no + 1 +"条链表为空");
            return;
        }
        Emp cur = head;
        while (true) {
            System.out.println("id: " + cur.id + "name: " + cur.name);
            if (cur.next == null){
                break;
            }
            cur = cur.next;
        }
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
