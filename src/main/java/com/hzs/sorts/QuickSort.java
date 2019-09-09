package com.hzs.sorts;

import java.util.Arrays;

/**
 * @author hezhensheng
 * @version 1.0
 * @description QuickSort
 * @date 2019/9/9 13:36
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {32,43,23,13,5};
        sort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int base = arr[start];  // 选定基准值
            int temp;
            int i = start, j = end;
            do {
                while ((arr[i] < base) && (i < end))
                    i++;
                while ((arr[j] > base) && (j > start))
                    j--;
                if (i <= j ) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    i++;
                    j--;
                    System.out.println(Arrays.toString(arr));
                }
            } while (i <= j);
            if (start < j) {
                sort(arr, start, j);
            }
            if (end > i) {
                sort(arr, i, end);
            }
        }
    }

}
