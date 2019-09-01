package com.hzs.linkedlists;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 自定义链表节点类
 * @date 2019/9/1 16:53
 */

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val){
        this.val = val;
    }

    public void add(ListNode node){
        if(node == null)
            throw new NullPointerException("新增节点是空的");
        if(0 == node.val)
            throw new IllegalArgumentException("节点的值不允许为0");
        ListNode p = this;
        while(p.next != null)
            p = p.next;     //p 为 尾节点
        p.next = node;
        node.next = null;
    }

    void print(ListNode head){
        if(head == null)
            throw new NullPointerException("头指针为空了");
        if(head.val == 0)
            throw new IllegalArgumentException("val 不可以为0");
        ListNode p = head;
        System.out.println(p.val);
        while( p.next != null){
            System.out.println(p.next.val);
            p = p.next;
        }
    }
}
