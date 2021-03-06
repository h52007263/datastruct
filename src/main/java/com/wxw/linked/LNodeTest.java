package com.wxw.linked;

/**
 * @Author: wxw
 * @create: 2019-09-05-22:20
 */
public class LNodeTest {
    public static void main(String[] args) throws Exception {
        LLinkedList<Integer> list1=new LLinkedList<Integer>();
        LNode<Integer> node1 = list1.addTail(1);
        LNode<Integer> node2 = list1.addTail(2);
        LNode<Integer> node3 = list1.addTail(3);
        LNode<Integer> node4 = list1.addTail(4);
        LNode<Integer> node5 = list1.addTail(5);


        //1,链表中有效节点的个数
        System.out.println("链表中有效节点个数："+list1.getLength(list1.getHead()));
        //2,查找单链表中的倒数第k个结点 【新浪面试题】
        System.out.println("单链表中的倒数第k个结点:"+list1.findLastIndexNode(list1.getHead(),2).data);

       //打印链表
        list1.print();
        //反转打印
        list1.printReverse(list1.getHead());
        //链表的大小
        list1.getSize();
        //末尾添加节点
        list1.addNodeOnTail(new LNode<>(8));
        list1.print();
        //向链表末尾添加元素
        list1.addTail(9);
        //指定位置添加 2的位置添加18
        list1.add(18,2);
        //删除指定位置元素
        list1.removeByIndex(1);
        //删除重复节点
        list1.removeDuplicateNodes();
        //两种方法反转链表
        list1.reserveLinkedList();
        //移除末尾元素
        //list1.removeByTail();
        //判断链表是否有环形
        list1.enterOfLoop(list1.getHead());
        //链表合并
        //list1.mergeList(list1,list2);
        //链表节点的删除(不知道头结点的情况下)
        list1.deleteNodeWithoutHead(node1);
        //打印链表的中间节点
        list1.printMiddleNode();

        //根据索引获取data
        list1.getEndK(3);
        //判断链表是否有环形
        list1.hasloop();
        //判断链表是否为空
        list1.isEmpty();
        //判断当前链表与目标链表是否相交 并返回交点  栈实现

        //判断当前链表与目标链表是否相交(相交与否取决于尾节点是否相同)

        //返回两链表的交点(若不相交，返回null)



    }
}
