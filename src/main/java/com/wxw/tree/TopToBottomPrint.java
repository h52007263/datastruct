package com.wxw.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static com.wxw.tree.reConstructBinaryTree.midOrder;

/**
 * @Author: wxw
 * @create: 2019-09-10-15:59
 */
public class TopToBottomPrint {
    public static void main(String[] args) {
         TreeNode tree=new TreeNode(5);
         tree.add(4);
         tree.add(2);
         tree.add(3);
         tree.add(7);
         tree.add(6);
         midOrder(tree);
        System.out.println();
        ArrayList<Integer> arrayList = PrintFromTopToBottom(tree);
        arrayList.stream().forEach(list-> System.out.print(list+","));
        System.out.println();
    }


    //从上往下打印出二叉树的每个节点，同层节点从左至右打印

    /**
     * 　  add        增加一个元索              如果队列已满，则抛出一个IIIegaISlabEepeplian异常
     * 　　remove   移除并返回队列头部的元素    如果队列为空，则抛出一个NoSuchElementException异常
     * 　　element  返回队列头部的元素          如果队列为空，则抛出一个NoSuchElementException异常
     * 　　offer       添加一个元素并返回true    如果队列已满，则返回false
     * 　　poll         移除并返问队列头部的元素   如果队列为空，则返回null
     * 　　peek       返回队列头部的元素            如果队列为空，则返回null
     * 　　put         添加一个元素                 如果队列满，则阻塞
     * 　　take        移除并返回队列头部的元素    如果队列为空，则阻塞
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);//添加一个元素并返回true
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();//移除并返问队列头部的元素
            result.add(temp.val);
            if(temp.left != null)queue.offer(temp.left);
            if(temp.right != null)queue.offer(temp.right);
        }
        return result;
    }




}
