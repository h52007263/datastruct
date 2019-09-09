package com.hzs.sorts;

import java.util.Arrays;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 插入排序
 * @date 2019/9/9 13:47
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2,4,3,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        int insertNum;
        // 确定插入次数
        for (int i = 1; i < length; i++) {
            // 插入数
            insertNum = arr[i];
            // 有序序列的最后一位数下标
            int j = i - 1;
            // 如果insertNum小于有序序列的数，序列数后移一位
            while (j >= 0 && insertNum < arr[j]) {
                // 当前序列数后移一位
                arr[j + 1] = arr[j];
                // 插入数与前一位序列数进行比较
                j--;
            }
            arr[j + 1] = insertNum;
        }
    }
}
