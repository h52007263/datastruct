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

    void print(){
        if(this.val == 0)
            throw new IllegalArgumentException("val 不可以为0");
        ListNode p = this;
        System.out.println(p.val);
        while( p.next != null){
            System.out.println(p.next.val);
            p = p.next;
        }
    }

    public ListNode createTestList(int length){
        if( this.val != 1)
            this.val = 1;
        for (int i = 2; i < length + 1; i++) {
            this.add(new ListNode(i));
        }
        return this;
    }

    /**
     * 通过索引获取链表节点
     * @param index 索引
     * @return ListNode
     */
    public ListNode getNodeByIndex(int index) {
        if(index <= 0 || index > this.size() )
            throw new IllegalArgumentException("index非法输入");
        ListNode p = this;
        for (int i = 1; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    /**
     * 获取链表长度
     * @return 返回链表长度
     */
    public int size() {
        int len = 1;
        ListNode p = this;
        while(p.next != null){
            len++;
            p = p.next;
        }
        return len;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
