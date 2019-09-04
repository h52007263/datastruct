package com.hzs.linkedlists;

import java.util.Stack;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 两个链表的第一个公共节点
 * @date 2019/9/1 22:04
 */

public class Demo6 {
    public static void main(String[] args) {
        // list1 = [ 1 3 5 7 8 ]
        ListNode list1 = new ListNode(1);
        // list2 = [ 2 4 6 7 8]
        ListNode list2 = new ListNode(1);

        list1.add(new ListNode(3));
        list1.add(new ListNode(5));
        list1.add(new ListNode(7));
        list1.add(new ListNode(8));

        list2.add(new ListNode(4));
        list2.add(new ListNode(6));
        list2.add(new ListNode(7));
        list2.add(new ListNode(8));

        ListNode pNode = findFirstCommonNode(list1,list2);

        System.out.println(pNode.val);

    }

    public static ListNode findFirstCommonNode(ListNode list1, ListNode list2){
        if(list1 == null || list2 == null)
            return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(list1 != null){
            stack1.push(list1);
            list1 = list1.next;
        }

        while(list2 != null){
            stack2.push(list2);
            list2 = list2.next;
        }
        ListNode pNode = null;
        while(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek().val == stack2.peek().val){
            stack1.pop();
            pNode = stack2.pop();
        }
        return pNode;
    }
}
