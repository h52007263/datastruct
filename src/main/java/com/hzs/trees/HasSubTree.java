package com.hzs.trees;

import sun.reflect.generics.tree.Tree;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 判断树的子结构
 * @date 2019/9/6 23:34
 */

public class HasSubTree {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(8);
        tree1.add(5);
        tree1.add(10);
        tree1.add(3);
        tree1.add(6);

        TreeNode tree2 = new TreeNode(5);
        tree2.add(3);
        tree2.add(7 );

        System.out.println(hasSubTree(tree1, tree2));

    }

    public static boolean hasSubTree(TreeNode node1, TreeNode node2) {
        boolean result = false;
        if (node1 != null && node2 != null) {
            if (node1.val == node2.val) {
                result = compare(node1, node2);
            }
            if (!result) {
                return hasSubTree(node1.left, node2) || hasSubTree(node1.right, node2);
            }
        }
        return result;
    }

    /**
     * 比较子节点是否相同
     * @param node1 当前树
     * @param node2 子树
     * @return
     */
    public static boolean compare(TreeNode node1, TreeNode node2) {
        if (node2 == null)
            return true;
        if (node1 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return compare(node1.left, node2.left) &&
                compare(node1.right, node2.right);
    }
}
