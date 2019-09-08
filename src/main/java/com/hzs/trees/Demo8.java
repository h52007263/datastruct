package com.hzs.trees;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 二叉树中和为某一值的路径
 * @date 2019/9/8 14:40
 */

public class Demo8 {
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root =TreeNode.createNodes();
        for (ArrayList<Integer> list : findPath(root, 12)) {
            for (int i : list)
                System.out.println(i);
            System.out.println("-----");
        }
    }

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if(root == null)
            return resultList;
        list.add(root.val);
        target -= root.val;

        if(target == 0 && root.left == null && root.right == null){
            resultList.add(new ArrayList<>(list));
        }else {
            findPath(root.left,target);
            findPath(root.right,target);
        }
        //每返回上一层一次就要回退一个节点
        list.remove(list.size()-1);
        return resultList;
    }
}
