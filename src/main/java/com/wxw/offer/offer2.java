package com.wxw.offer;

/**
 * @Author: wxw
 * @create: 2019-09-11-21:48
 */
public class offer2 {

    public static void main(String[] args) {
         offer2 of=new offer2();
        System.out.println(of.fun1(5));
        System.out.println(of.fun2(5));

    }

    // 输入N，输出1 - 2 + 3 - 4 + 5 - 6 + ... + N的值
    public int fun1(int n){
        if(n<1)return 0;
        int result=0;
        for(int i=1;i<=n;i++){
            if((i&1)==1)result +=i;  //==1说明是奇数
            else result -=i;
        }
      return result;
    }

    // 乌鸦喝水，1，1/2，1/4，每次喝前一次的一半，求前n次喝水的总数(分数表示)
    public float fun2(int n){
        int bootom=1;
        float sum=0f;
        for (int i = 0; i <n ; i++) {
            sum+=1/(float)(bootom * pow(2,i));
        }
        return sum;
    }


    //m^n次方
    public int pow(int m,int n){
         int sum=1;
         for(int i=0;i<n;i++){
             sum*=m;
         }
         return sum;
    }



}
