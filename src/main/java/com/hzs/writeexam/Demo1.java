package com.hzs.writeexam;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 简单笔试题目
 * @date 2019/9/8 22:11
 */

public class Demo1 {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
//        System.out.println(demo1.fun1(5));

//        System.out.println(demo1.pow(2,0));
        System.out.println(demo1.fun2(2));

    }

    // 输入N，输出1 - 2 + 3 - 4 + 5 - 6 + ... + N的值
    public int fun1(int n) {
        if (n < 1)
            return 0;
        int result = 0;
        for (int i = 1; i <= n ; i++) {
            if ((i & 1) == 1)
                result += i;
            else
                result -= i;
        }
        return result;
    }

    // 乌鸦喝水，1，1/2，1/4，每次喝前一次的一半，求前n次喝水的总数
    public float fun2(int n) {
        int bootom = 1;
        float sum = 0f;
        for (int i = 0; i < n; i++) {
            sum += 1 / (float)(bootom * pow(2,i));
        }
        return sum;
    }

    public int pow(int m, int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
             sum *= m;
        }
        return sum;
    }

}
