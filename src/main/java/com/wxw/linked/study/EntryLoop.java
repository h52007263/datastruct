package com.wxw.linked.study;

/**
 * @Author: wxw
 * @create: 2019-09-11-22:14
 */
public class EntryLoop {
    private ListNode head;//头节点
    private  ListNode temp;//临时节点
    //初始化链表，生成一个无数据的头节点
    EntryLoop() {
        head = new ListNode(0);
    }
    public ListNode getHead() {
        return head;
    }
    //尾插法 添加数据到新节点
    public void add(int val){
        ListNode node=new ListNode(val);
        temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
    }

    //打印节点  //不包含头节点
    public void print(){
        temp=head;
        while (temp.next!=null){
            System.out.print("{" + temp.next.val + "}");
            temp=temp.next;
        }
        System.out.println();
    }
    //给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
    public static ListNode EntryNodeOfLoop(ListNode pHead)
    {
        /**
         * 思想（双指针法）
         *1，找环的相交点，分别用p1，p2指向链表头部，p1每次走一步，p2每次二步直到p1==p2相交
         * 此时，p1走一圈，p2走两圈
         */
        if (pHead.next == null) {
            System.out.println("头节点为空");
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next;

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
        slow = pHead.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        EntryLoop link=new EntryLoop();//头节点默认为空 0
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(7);
        link.add(3);
        link.add(4);
        link.print();

        System.out.println("头节点："+link.getHead().val);
        System.out.println("入口节点："+EntryNodeOfLoop(link.getHead()));

    }



}








//定义链表节点
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
