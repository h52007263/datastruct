package com.hzs.linkedlists;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 反转链表
 * @date 2019/9/1 20:12
 */

public class Demo3 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.createTestList(5);

        ListNode reverseHead = reverseList(head);
        if( reverseHead != null)
            reverseHead.print();

    }

    public static ListNode reverseList(ListNode head){
        if( head == null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
