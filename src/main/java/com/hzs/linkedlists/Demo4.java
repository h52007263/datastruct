package com.hzs.linkedlists;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 合并两个有序链表
 * @date 2019/9/1 21:05
 */

public class Demo4 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        head1.add(new ListNode(3));
        head1.add(new ListNode(4));
        head2.add(new ListNode(5));
        head2.add(new ListNode(6));
//        head1.print();
//        head2.print();

        ListNode listMerge = merge(head1,head2);
        listMerge.print();

    }

    /* 递归方式实现合并有序链表 */
    public static ListNode merge(ListNode list1, ListNode list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode mergeList = null;
        if(list1.val <= list2.val){
            mergeList = list1;
            mergeList.next = merge(list1.next,list2);
        } else {
            mergeList = list2;
            mergeList.next = merge(list1, list2.next);
        }
        return mergeList;
    }
}
