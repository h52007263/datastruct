package com.wxw.string;


import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * @Author: wxw
 * @create: 2019-09-16-23:39
 */
public class Test2 {
   //参考博客：https://blog.csdn.net/zl18310999566/article/details/80251679
    //方法一
    public String ReverseSentence(String str) {
        if(str == null){ return null;}//为null则直接返回
        if(str.trim().equals("")){ //去除两边空格则直接返回
            return str;
        }
        String string = str;
        String[] strings = string.split(" "); //把一个字符串以空格为分割标准分割成字符串数组
        StringBuilder sBuilder = new StringBuilder();
        for (int i = strings.length-1 ; i>=0;i--) { //倒序遍历
            if(i == 0){
                sBuilder.append(strings[i]);
            }else {
                sBuilder.append(strings[i]);
                sBuilder.append(" ");
            }
        }

        String string2 = sBuilder.toString();//数组转换为字符串
        return string2;
    }

    public String ReverseSentence1(String str) {
        String trim = str.trim();
        String a = "";
        if("".equals(str.trim())){
            return str;
        }
        String[] split = str.split(" ");
        for (int i = split.length-1; i >=0; i--) {
            a +=split[i]+" ";
        }
        return a.trim();
    }

    public String ReverseSentence2(String str) {
        //未考虑null输入，若果输入为若干个空白符，则原样返回
        if(str.replaceAll(" ", "").equals("")) {
            return str;
        }
        String[] ans = str.split(" ");
        int length = ans.length;
        StringBuilder answer = new StringBuilder();
        for (int i = length - 1; i > 0; i--) {
            answer.append(ans[i] + " ");
        }
        return answer.append(ans[0]).toString();
    }
  //方法二

    /**
     * 定义两个指针，依次交换对应的字符串，即可
     * 例如 str = “I am a student.”，array = {“I”,“am”, “a”, “student.”}
     * array[0]和array[3]交换，{“student.”, “am”, “a”, “I”}
     * array[1]和array[2]交换，{“student.”, “a”, “am”, “I”}
     *
     */

    public static String reverseStringSequence(String str) {
        if (null==str) {
            return str;
        }
        String[] seq = str.split(" ");
        // 定义两个指针，一个从头开始，一个从尾开始，成对交换，当两个指针相遇时则停止
        int start = 0;
        int end = seq.length - 1;
        while (start < end) {
            String temp = seq[start];
            seq[start] = seq[end];
            seq[end] = temp;
            start++;
            end--;
        }
        return StringUtils.join(Arrays.asList(seq), " ");
    }


    public static void main(String[] args) {
        String input="I am a student";
        Test2 at2=new Test2();
        System.out.println(at2.ReverseSentence(input));
        System.out.println(at2.ReverseSentence1(input));
        System.out.println(at2.ReverseSentence2(input));

        System.out.println(reverseStringSequence(input));
    }
}
