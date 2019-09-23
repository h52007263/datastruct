package com.wxw.tree;
import static com.wxw.tree.reConstructBinaryTree.midOrder;

/**
 *
 * @Author: wxw
 * @create: 2019-09-10-15:29
 */
public class OfferMirror {

    public static void main(String[] args) {
        TreeNode tree=new TreeNode(1);
        tree.add(8);
        tree.add(4);
        tree.add(5);
        tree.add(7);
        midOrder(tree);
        System.out.println();
        Mirror(tree);
        midOrder(tree);

    }


    //操作给定的二叉树，将其变换为源二叉树的镜像
    public static void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        //递归的终止条件
        if(root.left==null && root.right==null){
            return;
        }
        //交换根节点的子节点
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
       //继续递归   有空则返回
        Mirror(root.left);
        Mirror(root.right);
    }
}
