package com.hzs.bit;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 位运算判断是否是2的乘方
 * @date 2019/9/23 11:35
 */

public class Demo1 {
    public static void main(String[] args) {
        int n = 160  ;
        System.out.println(numOf1(7));
    }
    public static boolean isPowerOf2(int n) {
        return (n & n - 1) == 0;
    }

    // 运算符优先级  == & =
    // 判断二进制中1的个数
    public static int numOf1(int n) {
        int sum = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                sum++;
            }
            n = n >> 1;
        }
        return sum;
    }
}
