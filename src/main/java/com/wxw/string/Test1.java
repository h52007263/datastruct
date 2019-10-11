package com.wxw.string;

import java.util.Stack;

/**
 * @Author: wxw
 * @create: 2019-09-16-23:25
 */
public class Test1 {

    //单词反转
    /*
    * 例如：I am a student =》 student a am I
　　思路：
　　1、先将整个字符串翻转：如：I am a student =》 tneduts a ma I
　　2、通过空格判断出每个单词，然后对每个单词进行翻转
    * */
    public static String reverse1(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse1(right) + reverse1(left);
    }

    /**
     * 取得当前字符并和之前的字符append起来
     * @param s
     * @return
     */
    public static String reverse2(String s) {
        int length = s.length();
        String reverse = "";
        for (int i=0; i<length; i++)
            reverse = s.charAt(i) + reverse;
        return reverse;
    }

    /**
     * 将字符从后往前的append起来
     * @param s
     * @return
     */
    public static String reverse3(String s) {
        char[] array = s.toCharArray();
        String reverse = "";
        for (int i = array.length - 1; i >= 0; i--) {
            reverse += array[i];
        }
        return reverse;
    }

    /**
     * 和StringBuffer()一样，都用了Java自实现的方法，使用位移来实现
     * @param s
     * @return
     */
    public static String reverse4(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * 和StringBuilder()一样，都用了Java自实现的方法，使用位移来实现
     * @param s
     * @return
     */
    public static String reverse5(String s) {
        return new StringBuffer(s).reverse().toString();
    }

    /**
     * 二分交换，将后面的字符和前面对应的那个字符交换
     * @param s
     * @return
     */
    public static String reverse6(String s) {
        char[] array = s.toCharArray();
        int end = s.length() - 1;
        int halfLength = end / 2;
        for (int i = 0; i <= halfLength; i++) {
            char temp = array[i];
            array[i] = array[end-i];
            array[end-i] = temp;
        }

        return new String(array);
    }

    /**
     * 原理是使用异或交换字符串
     * 如果a、b两个值不相同，则异或结果为1。如果a、b两个值相同，异或结果为0。
     *    理解：https://blog.csdn.net/iteye_4921/article/details/82618205
     * a=a^b;
     * b=b^a;
     * a=b^a;
     *
     * @param s
     * @return
     */
    public static String reverse7(String s) {
        char[] array = s.toCharArray();

        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            array[begin] = (char) (array[begin] ^ array[end]);
            array[end] = (char) (array[end] ^ array[begin]);
            array[begin] = (char) (array[end] ^ array[begin]);
            begin++;
            end--;
        }

        return new String(array);
    }

    /**
     * 基于栈先进后出的原理
     *
     * @param s
     * @return
     */
    public static String reverse8(String s) {
        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < array.length; i++)
            stack.push(array[i]);

        String reverse = "";
        for (int i = 0; i < array.length; i++)
            reverse += stack.pop();

        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse1("hello"));
        System.out.println(reverse2("hello"));
        System.out.println(reverse3("hello"));
        System.out.println(reverse4("hello"));
        System.out.println(reverse5("hello"));
        System.out.println(reverse6("hello"));
        System.out.println(reverse7("hello"));
        System.out.println(reverse8("hello"));
    }
}

