package com.hzs.trees;

import com.hzs.linkedlists.ListNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 从上到下打印二叉树
 * @date 2019/9/8 10:49
 */

public class Demo6 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.add(3);
        root.add(7);
        root.add(4);
        root.add(2);
        root.add(6);

        topToBottomPrint(root);

    }

    public static void topToBottomPrint(TreeNode root) {
        if (root == null)
            return;
        // 存放节点的队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.removeFirst();
            System.out.println(tmp.val);
            if (tmp.left != null) {
                queue.addLast(tmp.left);
            }
            if (tmp.right != null) {
                queue.addLast(tmp.right);
            }
        }
    }

}
