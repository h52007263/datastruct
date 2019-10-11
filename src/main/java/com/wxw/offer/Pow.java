package com.wxw.offer;

import java.util.Scanner;

/**
 * @Author: wxw
 * @create: 2019-09-10-12:41
 */
public class Pow {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Sum_Solution(n));

    }



   //1,求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
   public static int Sum_Solution(int n) {
       /**
        * 等差数列求和公式：Sn=n(a1+an)/2   an=a1+(n-1)d(d为等差中项)
        * 思路：这是一个等差数列，sum=(a1+an)n/2=>(1+n)n/2=>(n+n^2)/2；
        * Math.pow(a,b)表示a^b；右移一位相当于除以2。
        */
       //sum==n^2+n   再右移一位就是除以2
       int sum=(int)Math.pow(n,2)+n;
       return sum>>1;
   }

    /**
     *有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
     * 给定数组A及它的大小n，请返回最大差值。
     * @param A
     * @param n
     * 贪心算法
     */
    public int getDis(int[] A, int n){
            int dis=0;
        if(n>1){
            int min=A[0];
            for(int i=1;i<n;i++){
                if(A[i]-min>dis){
                    dis=A[i]-min;
                }
                if(min>A[i]){
                    min=A[i];
                }
            }
        }
        return dis;
  }


}
