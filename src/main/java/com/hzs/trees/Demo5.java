package com.hzs.trees;

import sun.reflect.generics.tree.Tree;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 判断二叉树是否对称
 * @date 2019/9/8 10:26
 */

public class Demo5 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        node1.left = new TreeNode(4);
        node1.right = new TreeNode(4);

        System.out.println(isSymmetric(null));

    }

    /**
     * 判断二叉树是否对称
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null)
            throw new NullPointerException("不可以输入空指针");
        return subtreeEqual(root.left, root.right);
    }

    public static boolean subtreeEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 != null && node2 != null)
            return node1.val == node2.val &&
                    subtreeEqual(node1.left, node2.left) &&
                    subtreeEqual(node2.right, node2.right);
        return false;
    }

}
