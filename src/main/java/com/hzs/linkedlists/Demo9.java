package com.hzs.linkedlists;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 寻找链表的中间节点
 * @date 2019/9/5 21:36
 */

public class Demo9 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.createTestList(6);
        ListNode ret = findMidNode(head);
        System.out.println(ret);
    }

    public static ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

}
