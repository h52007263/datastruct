package com.hzs.sorts;

import java.util.Arrays;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 选择排序
 * @date 2019/9/9 14:05
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,5,3,6,4,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int value = arr[i];
            int position = i;
            for (int j = i + 1; j < length; j++) {
                // 找出最小数的位置和值
                if (arr[j] < value) {
                    value = arr[j];
                    position = j;
                }
            }
            // 最小数位置 放 当前数
            arr[position] = arr[i];
            // 当前数位置放最小数
            arr[i] = value;
        }
    }
}
