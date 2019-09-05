package com.hzs.trees;

import java.util.*;

/**
 * @author hezhensheng
 * @version 1.0
 * @description TreeNode
 * @date 2019/9/3 17:53
 */

public class TreeNode {
    int val = 0;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    public TreeNode(int x) {
        val = x;
    }

    /**
     * 增加一个节点
     * @param v
     */
    public void add(int v) {
        // 当前值为0，新增值放在当前接结点
        if(val == 0) {
            val = v;
        } else {
            // 新增值小于当前值 放在left
            if (v <= val) {
                if (null == left)
                    left = new TreeNode();
                left.add(v);
            } else {
                // 新增的值大于当前值， 放在right
                if (null == right)
                    right = new TreeNode();
                right.add(v);
            }
        }
    }

    /**
     * 中序打印二叉树
     * @param tree
     */
    public void inPrint(TreeNode tree) {
        if (null != tree.left) {
            inPrint(tree.left);
        }
        System.out.println(tree);
        if (null != tree.right) {
            inPrint(tree.right);
        }
    }

    /**
     * 非递归层次遍历
     * @param pTreeRoot
     * @return
     */
    public ArrayList<Integer> noRecurLevelOrder(TreeNode pTreeRoot){ //非递归版本
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(pTreeRoot == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pTreeRoot);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }




    @Override
    public String toString() {
        return val + "";
    }
}
