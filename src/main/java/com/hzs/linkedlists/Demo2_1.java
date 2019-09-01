package com.hzs.linkedlists;

/**
 * @author hezhensheng
 * @version 1.0
 * @description Demo2_1
 * @date 2019/9/1 17:32
 */

public class Demo2_1 {
    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.createTestList(5);

        Demo2_1 demo = new Demo2_1();
        ListNode pNode = demo.findKnodeFromTail(null,5);
        if(pNode != null)
            System.out.println(pNode.val);
    }

    /*  寻找倒数第k个节点 */
    public ListNode findKnodeFromTail(ListNode head, int k){
        // 链表头指针是否为null
        if( head == null || k ==0 )
            throw new NullPointerException("head是空的");
        ListNode temp = head;
        // k是否超出链表的长度
        for (int i = 0; i < k - 1; i++) {
            if(temp.next != null)
                temp = temp.next;
            else
                throw new IllegalArgumentException("K超出范围了");
        }
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < k - 1; i++) {
            p1 = p1.next;
        }
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}
