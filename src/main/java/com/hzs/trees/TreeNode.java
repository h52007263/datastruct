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
     * 前序遍历
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        } else {
            return;
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        } else {
            return;
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

    // 二叉树的深度
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        if(l > r){
            return l + 1;
        }else{
            return r + 1;
        }
    }

    /**
     * 非递归中序遍历
     * @param pTreeNode
     */
    public void noRecurInOrder(TreeNode pTreeNode){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(pTreeNode!=null || !stack.isEmpty()){
            // 左子节点入栈
            while(pTreeNode!=null){
                stack.push(pTreeNode);
                pTreeNode = pTreeNode.left;
            }
            // 节点出栈，并判断该节点是否有右子节点，有就入栈
            if(!stack.isEmpty()){
                pTreeNode = stack.pop();
                System.out.print(pTreeNode.val + " ");
                pTreeNode = pTreeNode.right;
            }
        }
    }



    @Override
    public String toString() {
        return val + "";
    }
}
