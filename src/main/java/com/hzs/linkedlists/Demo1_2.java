package com.hzs.linkedlists;

/**
 * @author hezhensheng
 * @version 1.0
 * @description Demo1_2
 * @date 2019/9/1 17:22
 */

public class Demo1_2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(new ListNode(2));
        head.add(new ListNode(3));
        head.add(new ListNode(4));
        head.add(new ListNode(5));

        System.out.println("从头到尾打印链表");
        head.print();

        System.out.println("从尾到头打印链表");

        ListNode pre = head;
        ListNode cur = head.next;

        while( cur != null){
            ListNode temp = cur.next;
            cur.next = head;
            head = cur;
            cur = temp;
        }
        pre.next = null;
        head.print();
    }
}
