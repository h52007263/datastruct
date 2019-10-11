package com.wxw.tree;

import java.util.Arrays;

/**
 * Offer 重构二叉树
 * @Author: wxw
 * @create: 2019-09-10-9:46
 */
public class reConstructBinaryTree {
     private TreeNode root; //根节点

    public TreeNode getRoot() {
        return root;
    }
    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode tree=new TreeNode(1);
        tree.add(8);
        tree.add(4);
        tree.add(7);
        preOrder(tree);
        System.out.println();
        midOrder(tree);
        System.out.println();

        //重构二叉树
        TreeNode newTree=reConstructBinaryTree(pre,in);
        midOrder(newTree);
    }

    //1，重构二叉树
    /**
     * copyOfRange
     * 将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
     * 注意这里包括下标from，不包括上标to
     * @param pre
     * @param in
     * @return
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
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


    //前序遍历
    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val+",");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public static void midOrder(TreeNode root){
        if(root!=null){
            midOrder(root.left);
            System.out.print(root.val+",");
            midOrder(root.right);
        }
    }

}
//定义树的节点
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode() {
    }
    @Override
    public String toString() {
        return  "TreeNode [val=" + val + "]";
    }

    //增加节点
    public void add(int v){
        //将待插入数据防暑新建节点中
        TreeNode newNode=new TreeNode();
        //当前值为0，则数据存到根节点上
        if(val==0){
            val=v;
        }else {
            //新增值小于根节点 放在左子树上
            if(v<=val){
                if(null==left)
                    left=newNode;
                left.add(v);
            }else {
                if(null==right)
                    right=newNode;
                right.add(v);
            }
        }
    }






}
