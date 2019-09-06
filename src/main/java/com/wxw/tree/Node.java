package com.wxw.tree;

/**
 * 节点类
 * 二叉树的节点
 * @Author: wxw
 * @create: 2019-09-06-16:08
 */
public class Node<T> {
    T data;//结点数据
    Node<T> left;//指向左孩子节点
    Node<T> right;//指向右孩子节点

    //无参构造函数
    public Node() {
    }
    /**
     * 构造一个结点
     *
     * @param data  新元素数据
     */
    public Node(T data) {
        this.data = data;
    }

    //方便打印节点数据
    @Override
    public String toString() {
        return data==null?null:data.toString();
    }
    //重写比较节点数据的方法
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node){
            Node<T> temp=(Node<T>)obj;
            if(data.equals(temp.data)){

                return true;
            }
        }
        return false;
    }


}
