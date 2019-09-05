package com.hzs.linkedlists;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 判断当前链表与目标链表是否相交
 * @date 2019/9/5 22:13
 */

public class Demo10 {
    public static void main(String[] args) {
        // 【1，6，3，4，5】
        ListNode head = new ListNode(1).createTestList(5);
        // 【6，7，8，4，5】  预期结果：4
        ListNode target = new ListNode(6);
        target.add(new ListNode(7));
        target.add(new ListNode(8));
        target.add(new ListNode(4));
        target.add(new ListNode(5));
        System.out.println(existIntersect(head, target));
    }

    public static ListNode existIntersect(ListNode head, ListNode target) {
        if (head == null || target == null) {
            return null;
        }
        int count = 0;
        ListNode p1 = head;
        ListNode p2 = target;
        Stack<ListNode> headStack = new Stack<>();
        Stack<ListNode> targetStack = new Stack<>();
        while (p1 != null) {
            headStack.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            targetStack.push(p2);
            p2 = p2.next;
        }
        ListNode ret = null;
        while (headStack.peek().val == targetStack.peek().val) {
            headStack.pop();
            ret = targetStack.pop();
        }
        return ret;
    }
}
