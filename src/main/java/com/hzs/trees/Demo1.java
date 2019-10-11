package com.hzs.trees;

import java.util.Arrays;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 重建二叉树
 * @date 2019/9/4 23:02
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre, in);
        root.inPrint(root);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        //递归调用的终止条件
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }

}
