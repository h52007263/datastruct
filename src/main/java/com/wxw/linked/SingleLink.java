package com.wxw.linked;

import java.util.Stack;

/**
 * @Description: $
 * @Author: 魏小伟
 * @create: 2019-09-04 23:22
 * @version: 1.0
 */
public class SingleLink {
    public static void main(String[] args) {
        // 初始化一个head链表
        Node head = new Node(1);
        head.add(new Node(2));
        head.add(new Node(3));
        head.add(new Node(4));
        System.out.println("从头到尾打印链表");
        head.printIt();

        System.out.println("从尾到头打印链表");

        // ******************方法一 用栈实现*********************
        Stack<Node> stack = new Stack<>();
        if (null != head)
            stack.push(head);
        while (head.next != null) {
            stack.push(head.next);
            head = head.next;
        }
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.print(stack.pop().data+"->");
        }
    }
}


class Node{

    int data;
    int len=0; //链表长度
    Node next=null;

    public int getLen() {
        return len;
    }

    public Node(int data) {
        this.data = data;
    }

    //添加节点  尾插法
    public void add(Node node){
        if(node == null)
            throw new NullPointerException("新增节点是空的");
        if(0 == node.data)
            throw new IllegalArgumentException("节点的值不允许为0");
        Node p = this;
        while(p.next != null)
            p = p.next;     //p 为 尾节点
        p.next = node;
        node.next = null;
    }

    /**
     * 打印链表节点的值
     */
    void printIt(){
        if(this.data == 0)
            throw new IllegalArgumentException("val 不可以为0");
        Node p = this;
        System.out.print(p.data+"->");
        while( p.next != null){
            System.out.print(p.next.data+"->");
            p = p.next;
        }
        System.out.println();
    }

}
