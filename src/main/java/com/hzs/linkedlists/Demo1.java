package com.hzs.linkedlists;

import java.util.List;
import java.util.Stack;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 从尾到头打印链表
 * @date 2019/9/1 16:55
 */

public class Demo1 {
    public static void main(String[] args) {
        // 初始化一个head链表
        ListNode head = new ListNode(1);
        head.add(new ListNode(2));
        head.add(new ListNode(3));
        head.add(new ListNode(4));

        System.out.println("从头到尾打印链表");
        head.print();

        System.out.println("从尾到头打印链表");

        // ******************方法一 用栈实现*********************
        Stack<ListNode> stack = new Stack<>();
        if(null != head)
            stack.push(head);
        while(head.next != null){
            stack.push(head.next);
            head = head.next;
        }
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            System.out.println(stack.pop().val);
        }
        // ******************************************************
    }
}
