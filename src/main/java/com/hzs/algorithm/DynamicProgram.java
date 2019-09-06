package com.hzs.algorithm;

import java.util.HashMap;

/**
 * @author hezhensheng
 * @version 1.0
 * @description 动态规划
 * @date 2019/9/6 9:23
 */

public class DynamicProgram {
    public static void main(String[] args) {
        int ret1 = frogJumpSteps3(10);
        System.out.println(ret1);
    }

    /**
     * 青蛙跳台阶问题
     */

    /**
     * 方法一：递归 【复杂度：时间2的n次方】
     * @param n 跳台阶的方法总数 排列组合问题
     * @return
     */
    public static int frogJumpSteps1(int n) {
        if (n < 1 ) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return frogJumpSteps1(n - 1) + frogJumpSteps1(n - 2);
    }

    /**
     * 法二：备忘录算法 【复杂度：时间=n， 空间=n】
     * @param n
     * @param map 哈希表
     * @return
     */
    public static int frogJumpSteps2(int n, HashMap<Integer, Integer> map) {
        if (n < 1 ) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = frogJumpSteps2(n - 1, map) + frogJumpSteps2(n - 2, map);
            map.put(n, value);
            return value;
        }
    }

    /**
     * 方法三：动态规划 【复杂度：时间=n， 空间=1】
     * @description 只需要保留前两个步数就可以求出解
     * @param n
     * @return
     */
    public static int frogJumpSteps3(int n) {
        if (n < 1) {
            return 0;
        }
        if ( n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int temp = 0;
        // 当前台阶的上一个台阶
        int pre1 = 2;
        // 当前的台阶的上上个台阶
        int pre2 = 1;
        for (int i = 3; i <= n; i++) {
            temp = pre1 + pre2;
            pre2 = pre1;
            pre1 = temp;
        }
        return temp;
    }

}
