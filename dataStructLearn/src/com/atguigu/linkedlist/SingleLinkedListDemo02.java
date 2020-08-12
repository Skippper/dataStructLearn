package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo02 {

    public static void main(String[] args) {
        PersonNode personNode1 = new PersonNode(6,"大肉","Nige");
        PersonNode personNode2 = new PersonNode(16,"大肉","Nige");
        PersonNode personNode3 = new PersonNode(22,"大肉","Nige");
        PersonNode personNode4 = new PersonNode(15,"大肉","Nige");
        PersonNode personNode5 = new PersonNode(3,"大肉","Nige");

        SingleLinkList linkList = new SingleLinkList();

        linkList.add(personNode1);
        linkList.add(personNode2);
        linkList.add(personNode3);
        linkList.add(personNode4);
        linkList.add(personNode5);

        linkList.showList();

        linkList.reverseList(linkList.getHead());

        System.out.println("反转后的链表为:");
        linkList.showList();

        PersonNode personBynum = linkList.findPersonBynum(46);
        System.out.println(personBynum);
    }
}


class SingleLinkList{

    private PersonNode head = new PersonNode(0,"","");

    public PersonNode getHead(){
        return head;
    }


   public void add(PersonNode personNode){

       PersonNode temp = head;
        boolean flag= false;
       while (true){
           if (temp.next == null){
               break;
           }
           if (temp.next.no > personNode.no){
               break;
           }else if (temp.next.no == personNode.no){
               flag =true;
               break;
           }

           temp = temp.next;
       }
       if (flag){
           System.out.printf("人物编号:%d的人物已存在",personNode.no);
       }else {
           personNode.next = temp.next;
           temp.next = personNode;
           System.out.printf("英雄%s添加成功\n",personNode.name);
       }
   }

   public void update(PersonNode personNode){
       if (head.next == null){
           return;
       }
       PersonNode temp = head.next;
       boolean flag = false;
       while (true){
           if (temp == null){
               break;
           }
           if (temp.no == personNode.no){
               flag =true;
               break;
           }

           if (flag){
                temp.name = personNode.name;
                temp.nickName = personNode.nickName;
           }else {
               System.out.printf("未找到编号为%d的人物",personNode.no);
           }

           temp = temp.next;
       }
   }

   public void delete(int no){
       if(head.next == null){
           return;
       }
       PersonNode cur = head;
       boolean flag = false;
       while (true){

           if (cur.next == null){
               break;
           }
           if (cur.next.no == no){
               flag =true;
               break;
           }
           if (flag){

               cur.next = cur.next.next;
           }else {
               System.out.printf("未找到编号为%d的用户,无法删除",no);
           }
           cur = cur.next;
       }
   }

   public void reverseList(PersonNode head){
      if (head.next == null){
          return;
      }

      PersonNode cur = head.next;
      PersonNode next = null;
      PersonNode reverseHead = new PersonNode(0,"","");
      while (cur != null){
          next = cur.next;
          cur.next = reverseHead.next;
          reverseHead.next = cur;
          cur = next;
      }

      head.next = reverseHead.next;
   }

   public PersonNode findPersonBynum(int no){

       if (head.next == null){
           return null;
       }
       PersonNode cur = head.next;
       boolean flag = false;
       while (true){
           if (cur == null){
               break;
           }
           if (cur.no == no){
               flag =true;
               break;
           }

           cur = cur.next;
       }

       if (!flag){
           System.out.println("未找到用户");
           return null;
       }

       return cur;
   }

   public PersonNode findLastIndexNode(PersonNode head, int index){

       if (head.next == null){
           return  null;
       }

       int size = getLength(head);
        PersonNode cur = head.next;

        if (index < 0 || index > size){
            return  null;
        }

       for (int i = 0; i < size - index; i++) {
           cur = cur.next;
       }
       return  cur;
   }

   public int getLength(PersonNode head){

       if (head.next == null){
           return 0;
       }
        int length = 0;
       PersonNode cur = head.next;

       while (cur != null){
           length++;
           cur = cur.next;
       }
       return length;
   }

   public void showList(){
       if (head.next == null){
           return;
       }
       PersonNode cur = head.next;
       while (cur != null){
           System.out.println(cur);
           cur = cur.next;
       }
   }

   public void reversePrint(PersonNode head){

       if (head.next == null){
           return;
       }
       PersonNode cur = head.next;

       Stack<PersonNode> stack = new Stack<>();

       while (true){

           if (cur == null){
               break;
           }
           stack.push(cur);
           cur = cur.next;
       }

       while (stack.size()>0){
           System.out.println(stack.pop());
       }
   }
}

class PersonNode{

    public int  no;
    public String name;
    public String nickName;
    PersonNode next;

    public PersonNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "PersonNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
