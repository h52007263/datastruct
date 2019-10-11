package com.wxw.BinarySearchtree;

public class BinarySearchTree {
    private TreeNode root; //树的根节点

    //访问二叉树的根节点
    public TreeNode getRoot() {
        return root;
    }

    //============查找节点======================
    public TreeNode find(int key){
        TreeNode current= root;
       while (current!=null){
           if(current.data>key){//当前节点比查找值大，搜索左子树
              current=current.left;
           }else if(current.data<key){
               current=current.right;
           }else {
               return current;
           }
       }
       return null;//遍历完整个树，没找到
    }

   //===================插入节点==========================
    public boolean insert(int data){
         TreeNode newNode= new TreeNode(data);//将待插入数据存到结点放在临时树中
        if(root == null){
            root=newNode;//插入作为根结点
            return true;
        }else {
            TreeNode current=root;//根结点不动
            TreeNode parentNode=null;//用于保存父节点
            while (current!=null){
                parentNode=current;
                if(current.data>data){//当前值比插入值大时，搜索左子树
                    current=current.left;
                    if(current==null){ //左子节点为空，直接将新值插入到该节点
                        parentNode.left=newNode;
                        return true;
                    }
                }else {
                    current=current.right;
                    if(current==null){//右子结点为空，直接将该值插入到该节点
                       parentNode.right=newNode;
                       return true;
                    }
                }
            }
        }
          return  false;
    }
    //=====================二叉树的遍历====================

    //中序遍历
    public void  middleOrder(TreeNode current){
        if(current!=null){
            middleOrder(current.left);
            System.out.print(current.data+"-");
            middleOrder(current.right);
        }
    }
    //前序遍历
    public void preOrder(TreeNode current){
         if(current!=null){
             System.out.print(current.data+"-");
             preOrder(current.left);
             preOrder(current.right);
         }
    }

    //后序遍历
    public void postOrder(TreeNode current){
        if(current!=null){
            preOrder(current.left);
            preOrder(current.right);
            System.out.print(current.data+"-");
        }
    }

    //============找最小值=====================
    public TreeNode findMin(){
        TreeNode current=root;
        TreeNode minNode=current;//当前节点为最小节点
        while (current!=null){
            minNode=current;
            current=current.left;
        }
        return minNode;
    }

    //===========找最大值===================
    public TreeNode findMax(){
        TreeNode current = root;
        TreeNode maxNode = current;
        while(current != null){
            maxNode = current;
            current = current.right;
        }
        return maxNode;
    }

  //==================删除节点操作======================
    //(1) 删除没有子节点的节点
    // (2)删除有一个子节点的节点
    //(3)删除有两个子节点的节点
  public boolean delete(int key) {
      TreeNode current = root;
      TreeNode parent = root;
      boolean isLeftChild = false;
      //查找删除值，找不到直接返回false
      while(current.data != key){
          parent = current;
          if(current.data > key){
              isLeftChild = true;
              current = current.left;
          }else{
              isLeftChild = false;
              current = current.right;
          }
          if(current == null){
              return false;
          }
      }
      //如果当前节点没有子节点
      if(current.left == null && current.right == null){
          if(current == root){
              root = null;
          }else if(isLeftChild){
              parent.left = null;
          }else{
              parent.right = null;
          }
          return true;

          //当前节点有一个子节点，右子节点
      }else if(current.left == null && current.right != null){
          if(current == root){
              root = current.right;
          }else if(isLeftChild){
              parent.left = current.right;
          }else{
              parent.right = current.right;
          }
          return true;
          //当前节点有一个子节点，左子节点
      }else if(current.left != null && current.right == null){
          if(current == root){
              root = current.left;
          }else if(isLeftChild){
              parent.left = current.left;
          }else{
              parent.right = current.left;
          }
          return true;
      }else{
          //当前节点存在两个子节点
          TreeNode successor = getSuccessor(current);
          if(current == root){
              root= successor;
          }else if(isLeftChild){
              parent.left = successor;
          }else{
              parent.right = successor;
          }
          successor.left = current.left;
      }
      return false;
  }
  //========找到并返回二叉搜索树的后继节点=========
    public TreeNode getSuccessor(TreeNode delNode){
        TreeNode successorParent=delNode;
        TreeNode successor=delNode;
        TreeNode current=delNode.right;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        ////后继节点不是删除节点的右子节点,将后继节点替换删除节点
        if(successor != delNode.right){
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    //以广义表的形式打印二叉树：前序遍历的应用============
    public String printBinaryTree(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.data);
            if (root.left != null || root.right != null) {
                sb.append('(');
                sb.append(printBinaryTree(root.left));
                sb.append(',');
                sb.append(printBinaryTree(root.right));
                sb.append(')');
            }
        }
        return sb.toString();
    }

   //后续遍历的思想 树的深度(空树为0)===================
   public int height(TreeNode root) {
       if (root != null) { // 递归终止条件
           int h1 = height(root.left);
           int h2 = height(root.right);
           return h1 > h2 ? h1 + 1 : h2 + 1;
       }
       return 0;
   }

   //后序遍历的思想：树中节点个数=========
   public int size(TreeNode root) {
       if (root != null) { // 递归终止条件
           return size(root.left) + size(root.right) + 1;
       }
       return 0;
   }

}
