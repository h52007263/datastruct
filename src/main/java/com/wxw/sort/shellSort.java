package com.wxw.sort;

import java.util.Arrays;

/**
 * @Author: wxw
 * @create: 2019-09-08-17:30
 */
public class shellSort {
   //间隔选取N/2
    public static void shellSort(int[] array){
        System.out.println("原数组为"+Arrays.toString(array));

        int step;//数组选取的间隔
        int len = array.length; //数组长度
        for(step = len/2 ;step > 0 ; step /= 2){//定义间隔取分规则
            //分别对每个增量间隔进行排序
            for(int i = step ; i < array.length ; i++){
                int j = i;//保存间隔变量
                int temp = array[j];//后面值
                if(array[j] < array[j-step]){//array[j] 中间值  array[j-step]第0个值
                    while(j-step >=0 && temp < array[j-step]){
                        array[j] = array[j-step];//j-step=0
                        j -= step;//j=0
                    }
                    array[j] = temp;
                }
            }
           System.out.println("间隔为"+step+"的排序结果为"+ Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3,10};
        shellSort(array);
      //  System.out.println(Arrays.toString(array));
    }
}
