package com.hzs;

import com.hzs.trees.TreeNode;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        TreeNode root = new TreeNode(5);
        root.add(3);
        root.add(7);
        root.add(2);
        root.add(4);
        root.add(8);
        root.add(6);
        root.add(9);
        root.noRecurInOrder(root);
    }
}
