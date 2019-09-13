package com.wxw.offer;

import java.math.BigInteger;

/**
 * @Author: wxw
 * @create: 2019-09-13-23:04
 */
public class AddCondition {

    public static void main(String[] args) {
        System.out.println("大数求和："+Add1(3,4));
    }
/**
 * 首先看十进制是如何做的： 5+7=12，三步走
 * 第一步：相加各位的值，不算进位，得到2。
 * 第二步：计算进位值，得到10. 如果这一步的进位值为0，那么第一步得到的值就是最终结果。
 * 第三步：重复上述两步，只是相加的值变成上述两步的得到的结果2和10，得到12。
 * 同样我们可以用三步走的方式计算二进制值相加： 5-101，7-111 第一步：相加各位的值，
 * 不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
 * 第二步：计算进位值，得到1010，相当于各位做与操作得到101，再向左移一位得到1010，(101&111)<<1。
 * 第三步重复上述两步， 各位相加 010^1010=1000，进位值为100=(010&1010)<<1。
 *      继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果
 * @param num1
 * @param num2
 * @return
 */
    public static int Add1(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;

    }

   //写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
    public int Add(int num1,int num2) {
        //大数计算
        BigInteger a1=new BigInteger(String.valueOf(num1));
        BigInteger a2=new BigInteger(String.valueOf(num2));

        return a1.add(a2).intValue();
    }
}
