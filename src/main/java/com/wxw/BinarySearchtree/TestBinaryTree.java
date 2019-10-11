package com.wxw.BinarySearchtree;

/**
 * @Author: wxw
 * @create: 2019-09-06-20:40
 */
public class TestBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        System.out.print("前序遍历：");
        bt.preOrder(bt.getRoot());
        System.out.print("中序遍历：");
        bt.middleOrder(bt.getRoot());
        System.out.print("后序遍历：");
        bt.postOrder(bt.getRoot());
        System.out.println();
        System.out.println("最大节点值："+bt.findMax().data);
        System.out.println("最小节点值："+bt.findMin().data);
        bt.delete(10);//删除没有子节点的节点
        bt.delete(30);//删除有一个子节点的节点
        bt.delete(80);//删除有两个子节点的节点
        System.out.print("前序遍历：");
        bt.preOrder(bt.getRoot());
        System.out.println();
        //查找节点
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));
        System.out.println("树的节点个数："+bt.size(bt.getRoot()));
        System.out.println("树的深度："+ bt.height(bt.getRoot()));
        System.out.println(bt.printBinaryTree(bt.getRoot()));//广义表的形式打印二叉树

    }

}
