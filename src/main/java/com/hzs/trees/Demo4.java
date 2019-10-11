package com.hzs.trees;

import sun.reflect.generics.tree.Tree;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 二叉树的镜像
 * @date 2019/9/7 0:18
 */

public class Demo4 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.add(6);
        node.add(10);
        node.add(5);
        node.add(7);
        node.add(9);
        node.add(11);
        // 期望结果：[11,10,9,8,7,6,5]
        TreeNode result = getMirrorTree(node);
        node.inPrint(result);

    }

    public static TreeNode getMirrorTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null && node.right != null) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        getMirrorTree(node.left);
        getMirrorTree(node.right);
        return node;
    }

}
