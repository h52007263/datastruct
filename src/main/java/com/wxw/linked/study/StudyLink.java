package com.wxw.linked.study;

/**
 * @Author: wxw
 * @create: 2019-09-09-22:53
 */
public class StudyLink {
    //节点类
    private class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;//头节点
    private ListNode temp;//临时节点

    //初始化链表，生成一个无数据的头节点
    StudyLink() {
        head = new ListNode(0);
    }

    /* ================以下方法是对链表的操作===================*/

    /**
     * 增加节点
     *
     * @param data
     */
    public void addNode(int data) {
        ListNode node = new ListNode(data);
        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    /**
     * 返回链表的长度
     * @return
     */
    public int getLength()
    {
        temp = head;
        int length = 0;
        while (temp.next!=null)
        {
            length++;
            temp = temp.next;
        }
        return length;
    }
    /**
     * 增加节点到指定的位置
     *
     * @param index
     * @param data
     */
    public void addNodeByIndex(int index, int data) {
        if (index < 1 || index > getLength() + 1) {
            System.out.println("插入的位置不合法。");
            return;
        }
        int count = 1; //记录遍历的位置
        ListNode node = new ListNode(data);
        temp = head;
        while (temp.next != null) {
            if (index == count++) {
                node.next = temp.next;
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }
    /**
     * 删除指定位置的节点
     *
     * @param index
     */
    public void deleteByIndex(int index) {
        if (index < 1 || index > getLength()) {
            System.out.println("插入的位置不合法。");
            return;
        }
        int count = 1;//记录位置
        temp = head;
        while (temp.next != null) {
            if (index == count++) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    /**
     * 从头到尾打印节点
     */
    public void printListFromHead() {
        temp = head;
        while (temp.next != null) {
            System.out.print("{" + temp.next.val + "}");
            temp = temp.next;
        }
        System.out.println();
    }
    /**
     * 从头到尾打印节点
     */
    public void printListFromHead1() {
        temp = head;
        while (temp.next != null) {
            System.out.print("{" + temp.next.val + "}");
            temp = temp.next;
        }
        System.out.println();
    }

     //合并两张有序链表
     public static ListNode Merge(ListNode list1,ListNode list2) {
         if(list1 == null)
             return list2;
         if(list2 == null)
             return list1;
         ListNode mergeList = null;
         if(list1.val <= list2.val){
             mergeList = list1;
             mergeList.next = Merge(list1.next,list2);
         } else {
             mergeList = list2;
             mergeList.next = Merge(list1, list2.next);
         }
         return mergeList;
     }
    //带头结点的打印链表
    public static void printListWithHead(ListNode node) {
        ListNode temp = node;
        temp=temp.next;
        while (temp.next != null) {
            System.out.print("{" + temp.next.val + "}");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        StudyLink list = new StudyLink();
        StudyLink list2 = new StudyLink();
        list.addNode(1);
        list.addNode(2);
        list2.addNode(3);
        list2.addNode(4);
        list2.addNode(5);
        //合并链表
        ListNode mergeList=Merge(list2.head,list.head);
        printListWithHead(mergeList);
        System.out.println("==================================");
        mergeList=mergeList.next;
        while (mergeList.next!=null){
            mergeList=mergeList.next;
            System.out.print(mergeList.val+",");
        }
        System.out.println();
        System.out.println("==============================");

        list.printListFromHead();
        list.addNodeByIndex(2,98);
        list.printListFromHead();
        list.deleteByIndex(3);
        list.printListFromHead();
        list.printListFromHead1();
        System.out.println(list.getLength());

    }
}

