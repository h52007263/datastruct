package com.hzs.arrays;

import java.util.Arrays;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 数组长度2n(n个奇数，n个偶数)，实现数组奇数位放奇数，偶数位放偶数
 * @date 2019/9/5 16:41
 */

public class Demo1 {
    public static void main(String[] args) {
        // 3个奇数，3个偶数， 奇数下标存放奇数， 偶数下标存放偶数
        int[] arr = new int[]{1,1,2,2,4,3};
        int[] arr1 = ascAndDesc1(arr);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 方法1：复杂度 = 【 时间2n + 空间n 】
     * @param arr
     * @return
     */
    public static int[] ascAndDesc(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length % 2 != 0) {
            throw new IllegalArgumentException("参数异常，数组长度为偶数");
        }
        int len = arr.length;
        int[] arr1 = new int[arr.length];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] % 2 == 0) {
                arr1[index] = arr[i];
                index += 2;
            }
        }
        index = 1;
        for (int i = 0; i < len; i++) {
            if (arr[i] % 2 != 0) {
                arr1[index] = arr[i];
                index += 2;
            }
        }
        return arr1;
    }

    /**
     * 方法2：复杂度 = 【 最坏情况的时间：n * n / 2， 平均情况的时间：n】
     * @param arr
     * @return
     */
    public static int[] ascAndDesc1(int[] arr) {
        if (arr == null) {
            return null;
        }
        if (arr.length % 2 != 0) {
            throw new IllegalArgumentException("参数异常，数组长度为偶数");
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if ((i % 2) != (arr[i] % 2)) {
                for (int j = i + 1; j < len; j++) {
                    if ((j % 2) == (i % 2)) {
                        swap(arr, i, j);
                        break;
                    }
                }
            }
        }
        return arr;
    }

    // 交换两个元素
    public static void swap(int[] arr, int a, int b) {
        if (checkRange(arr, a) || checkRange(arr, b))
            throw new IllegalArgumentException("参数异常");
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    // 检查参数正确性
    public static boolean checkRange(int[] arr, int len) {
        if (len < 0 || len > arr.length - 1)
            return true;
        return false;
    }


}
