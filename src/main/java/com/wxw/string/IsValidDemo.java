package com.wxw.string;

import java.util.Stack;

/**
 * @Author: wxw
 * @create: 2019-10-11-22:17
 */
public class IsValidDemo {
    public static void main(String[] args) {
         String s="{[()()]}";
        System.out.println(isValid(s));
        System.out.println(longestValidParentheses(s));
    }
    /**
     * 遇左括号入栈，遇右括号，先判断栈是否为空，若栈为空，则直接return false，
     * 若栈不为空，则出栈，继续处理下一字符；字符串结束时，若栈为空，return true，
     * 否则return false），可以用栈来解决
     * @param s
     * @return
     */
    //判断字符串有效括号
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(ch == ')' && topChar != '('){
                    return false;
                }else if(ch == ']' && topChar != '['){
                    return false;
                }else if(ch == '}' && topChar != '{'){
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }


    //给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
    public static int longestValidParentheses(String s) {
        int max = 0, start = 0;
        if(null == s) return 0;

        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index < len; index++){
            //遇左括号(，压栈(栈中元素为当前位置所处的下标)
            if('(' == s.charAt(index)){
                stack.push(index);
                continue;
            } else {
                if(stack.isEmpty()){
                    start = index+1;
                    continue;
                } else {
                    stack.pop();
                    if(stack.isEmpty()){
                        max = Math.max(max, index-start+1);
                    } else {
                        max = Math.max(max, index-stack.peek());
                    }
                }
            }
        }

        return max;
    }



}
