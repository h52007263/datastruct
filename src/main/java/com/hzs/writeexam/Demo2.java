package com.hzs.writeexam;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 判断是否能跳到数组的最后一个位置
 * @date 2019/9/9 11:10
 */

public class Demo2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3};
        System.out.println(canJumpEndPos(arr));
    }

    public static boolean canJumpEndPos(int[] arr) {
        if (arr.length == 0)
            return false;
        int len = arr.length;
        for (int i = 0; i < len; ) {
            if (i == (len - 1))
                return true;
            i += arr[i];
            // 避免数组越界
            if (i > len)
                return false;
        }
        return false;
    }

    public static int numToStrCount(int n) {

        return 0;
    }

    public static String delimite(String srcStr, char delimiter, int index) {

        return null;
    }
}
