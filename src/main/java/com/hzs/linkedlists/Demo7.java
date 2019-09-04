package com.hzs.linkedlists;

import java.util.LinkedList;

/**
 * @author hezhensheng
 * @version 1.0
 * @description Java中环的入口节点
 * @date 2019/9/3 15:59
 */

public class Demo7 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.createTestList(4);

        //head = [1,2,3,4,null]
        head.getNodeByIndex(4).next = null;
        System.out.println(entranOfLoop(head)); // 入口节点为null

        // head = [1,2,3,4,3,4...]
        head.getNodeByIndex(4).next = head.getNodeByIndex(3);
        System.out.println(entranOfLoop(head)); // 入口节点为3
    }

    /**
     * 返回环的入口节点
     * @param head 链表
     * @return ListNode
     */
    public static ListNode entranOfLoop(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        // step1:判断链表长度是否足够循环
        if (fast != null && fast.next != null)
            fast = fast.next.next;
        else
            return null;
        slow = slow.next;

        // step2:fast指针一次跳两步，slow指针一次跳一步
        while (fast != slow) {
            if (fast != null && fast.next != null)
                fast = fast.next.next;
            else
                return null;
            slow = slow.next;
        }

        // 两个指针再次相遇为入口节点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
