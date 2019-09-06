package com.hzs.trees;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 找出二叉树的下一个节点
 * @date 2019/9/6 22:21
 */

public class Demo2 {
    public static void main(String[] args) {

    }

    /**
     * 找出二叉树某一个节点的下一个节点（中序遍历顺序查找）
     * @param node
     * @return
     */
    public static BinaryTreeNode get5NextNode(BinaryTreeNode node) {
        if (node == null)
            return null;
        // 存在右节点，返回右节点或者右节点的左孩子节点
        if (node.right != null) {
            BinaryTreeNode right = node.right;
            while (right.left != null)
                right = right.left;
            return right;
        }
        // 找出当前节点是父节点左孩子节点的节点
        while (node.parent != null) {
            if (node.parent.left == node)
                return node.parent;
            node = node.parent;
        }
        return null;
    }

}



class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode parent;
}