package com.wxw.offer;

/**
 * @Author: wxw
 * @create: 2019-09-13-22:42
 */
public class DoublePower {


    public static void main(String[] args) {
        System.out.println("浮点数的幂次方："+Power(3.4,5));
    }
   
  //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
  //保证base和exponent不同时为0
    public static double Power(double base, int exponent) {
         //1,底数为0则
        if(base==0.0)return 0.0;
        //2，指数为0,就是它本身
         double result=1.0d;
         //取得指数的绝对值
        int e=exponent>0?exponent:-exponent;
        //根据指数大小循环阶乘
        for(int i=1;i<=e;i++){
            result*=base;
        }
        //根据指数正负返回结果
        return exponent>0?result:1/result;
    }
}
