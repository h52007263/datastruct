package com.wxw.tree;

import java.util.LinkedList;

/**
 * @Author: wxw
 * @create: 2019-09-06-16:20
 */
public class BinaryTree<T> {
      private Node<T> root;//二叉树的根节点

    //默认无参构造函数
    public BinaryTree() {
        super();
    }

   //=======根据原树的根结点复制出一颗一模一样的树==========


    public Node<T> copyTreeByRootNode(Node<T> root){
        if(root==null) return null;
        Node<T> temp=new Node<T>();
        temp.data=root.data;
        temp.left=copyTreeByRootNode(root.left);
        temp.right=copyTreeByRootNode(root.right);
        return temp;
    }

   //=======根据一个树的根复制构造出一个新树===============
    /*
     * 构造函数    复制新树
     * @Param [root] 原树的根结点
     **/
    public BinaryTree(Node<T> node) {
        this.root = copyTreeByRootNode(node);
    }

   //=========根据一棵树的前序遍历结果复制构造树=============



   //========= 广序/层次遍历，工作队列===========
   public String levelOrder() {
       StringBuilder sb = new StringBuilder();
       LinkedList<Node<T>> queue = new LinkedList<Node<T>>(); // 辅助队列
       if (root != null) {
           queue.add(root);
           while (!queue.isEmpty()) {
               Node<T> temp = queue.pop();
               sb.append(temp.data).append(" ");
               // 在遍历当前节点时，同时将其左右孩子入队
               if (temp.left != null)
                   queue.add(temp.left);
               if (temp.right != null)
                   queue.add(temp.right);
           }
       }
       return sb.toString().trim();
   }


    //打印遍历后的树
    @Override
    public String toString() {
        return levelOrder();
    }


    //=======根据树的根节点判断两棵树是否相等======
   /*
    * @Param [src, des][源树根节点，目的树根结点]
    **/
    public boolean equals2(Node<T> src,Node<T> des){
        if (src == null && des == null) { // 空树相等
            return true;
        } else if (src == null || des == null) { // 空树与非空树不相等
            return false;
        } else { // 非空树与非空树是否相等：当前节点是否相等 && 左子树是否相等 && 右子树是否相等
            return src.equals(des) && equals2(src.left, des.left)
                    && equals2(src.right, des.right);
        }
    }

    //重写二叉树的比较方法
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BinaryTree){//对方是否也是一颗二叉树
          BinaryTree<T> tree=(BinaryTree<T>)obj;
          return equals2(this.root,tree.root);
        }
        return false;
    }
}
