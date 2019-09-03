package com.wxw.singlelink;

import java.util.Stack;

/**
 * @Description: $
 * @Author: 魏小伟
 * @create: 2019-09-03 20:28
 * @version: 1.0
 */
public class LinkedList {
    //节点类
    protected class ListNode {
        private Object data;
        private ListNode next = null;

        ListNode() {
            data = null;
        }

        ListNode(Object data) {
            this.data = data;
        }
    }
    private ListNode head;//头节点
    private ListNode temp;//临时节点

    //初始化链表，生成一个无数据的头节点
    LinkedList() {
        head = new ListNode();
    }

    /**
     * 增加节点 尾插法
     */
    public void  addNode(Object data){
        ListNode node=new ListNode(data);
        temp=head;
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next=node;
    }

    /**
     * 增加节点 头插法
     */
    public void addTailNode(Object data){
        ListNode node=new ListNode(data);
        if(head==null){
            head=node;
        }else {
            node.next=head;
            head=node;
        }
    }

    /**
     * 获得链表的长度
     */
    public int getLength(){
        temp=head;
        int length=0;
        while (temp.next != null){
            length++;
            temp=temp.next;
        }
        return length;
    }

    /**
     * 添加节点到指定位置
     */
    public void addNodeByIndex(int index,Object data){
        if(index<1||index>getLength()+1){
            System.out.println("插入位置不合法");
            return;
        }
        int count=1;
        ListNode node=new ListNode(data);
        temp=head;
        while (temp.next!=null){
            if(index==count++){
                node.next=temp.next;
                temp.next=node;
                return;
            }
            temp=temp.next;
        }
    }

    /**
     * 删除指定位置的节点
     *
     * @param index
     */
    public void deleteByIndex(int index) {
        if (index < 1 || index > getLength()) {
            System.out.println("删除的位置不合法。");
            return;
        }

        int count = 1;//记录位置
        temp = head;
        while (temp.next != null) {
            if (index == count++) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    /**
     * 1,从头到尾打印节点
     */
    public void printListFromHead() {
        temp = head;
        while (temp.next != null) {
            System.out.print("{" + temp.next.data + "}");
            temp = temp.next;
        }
        System.out.println();

    }


    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();//利用构造函数 初始化一个楼节点
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        list.printListFromHead();
        list.addNodeByIndex(3,2.8);
        list.printListFromHead();
        list.deleteByIndex(3);
        list.printListFromHead();
        System.out.println(list.getLength());

    }

}
