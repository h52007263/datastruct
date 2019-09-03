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

    /**
     * 链表尾部增加一个节点
     * @param node
     */
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

    /**
     * 打印链表节点的值
     */
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

    /**
     * 创建length个节点
     * @param length
     * @return 头节点
     */
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

    // 通过节点删除
    public ListNode remove(ListNode removeNode) {
        if (removeNode == null)
            return null;
        ListNode p = this;
        // step1:找到待删除的节点
        while (p.next != removeNode) {
            p = p.next;
        }
        // step2:开始删除removeNode节点
        p.next = removeNode.next;
        removeNode.next = null;
        return this;
    }

    // 通过索引删除
    public ListNode remove(int index) {
        if (index <= 0 || index > this.size())
            throw new IllegalArgumentException("非法入参index");
        ListNode p = this;
        // step1:找到待删除节点
        for (int i = 1; i < index - 1; i++) {
            p = p.next;
        }
        // step2:开始删除节点
        ListNode removeNode = p.next;
        p.next = p.next.next;
        removeNode.next = null;
        return this;
    }

    @Override
    public String toString() {
        return val + "";
    }
}
