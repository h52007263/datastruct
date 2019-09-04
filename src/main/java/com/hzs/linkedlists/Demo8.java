package com.hzs.linkedlists;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 删除有序链表中的重复节点
 * @date 2019/9/3 17:04
 */

public class Demo8 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(new ListNode(2));
        head.add(new ListNode(2));
        head.add(new ListNode(3));
        head.add(new ListNode(3));
        head.add(new ListNode(3));
        head.add(new ListNode(4));
        removeDuplicateNode(head).print();
    }

    public static ListNode removeDuplicateNode(ListNode head) {
        if (head == null)
            return null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            if (p1.val == p2.val) {
                head.remove(p1);
                p1 = p2;
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }

}
