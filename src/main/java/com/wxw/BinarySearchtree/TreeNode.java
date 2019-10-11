package com.wxw.BinarySearchtree;

/**
 * 二叉搜索树
 * @Author: wxw
 * @create: 2019-09-06-20:23
 */
public class TreeNode {
    public int data;//节点数据
    public TreeNode left;//左子节点的引用
    public TreeNode right;//右子节点的引用

    public TreeNode(int data){
        this.data = data;
    }
    @Override
    public String toString() {
        return "TreeNode [data=" + data + "]";
    }

}

