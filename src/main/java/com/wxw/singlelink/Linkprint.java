package com.wxw.singlelink;

import java.util.Stack;

/**
 * @Description: $
 * @Author: 魏小伟
 * @create: 2019-09-03 22:19
 * @version: 1.0
 */
public class Linkprint {

    Node head;//头节点

    //添加节点 尾插法
    public void addNode(Node node){
        if(node == null)
            throw new NullPointerException("新增节点是空的");
        if(0 == node.val)
            throw new IllegalArgumentException("节点的值不允许为0");
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.next=null;
    }

    //从头打印链表
    public void  printLink(){
        Node temp=head;
        while (temp.next != null) {
            System.out.print("{" + temp.next.val + "}");
            temp = temp.next;
        }
        System.out.println();
    }
    //从尾到头 栈
    public void printTail(Node node){
        if(node==null){
           return;
        }
        Stack<Integer> stack = new Stack<Integer>(); //借助于栈
        while(node!=null){
            stack.push(node.val); //将数据放入栈中
            node = node.next; //指针域指向下一个指针
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " "); //借助于栈输出
        }
    }
    //从尾到头 递归
    public void printTail_2(Node node){
        if(node!=null){
            if(node.next!=null){
                printTail_2(node.next);
            }
            System.out.print(" "+node.val);
        }

    }


    public static void main(String[] args) {
          Node a1=new Node(1);
          Node a2=new Node(2);
          Node a3=new Node(3);
          Node a4=new Node(4);
          Node a5=new Node(5);
         a1.next=a2;
         a2.next=a3;
         a3.next=a4;
         a4.next=a5;
         a5.next=null;
        new Linkprint().printTail(a1);
        System.out.println();
        new Linkprint().printTail_2(a1);


    }


}


//定义一个链表节点
class  Node{
    int val;
    Node next=null;

    public Node(int val){
        this.val=val;
    }

}