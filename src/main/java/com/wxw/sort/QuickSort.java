package com.wxw.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: wxw
 * @create: 2019-09-08-18:05
 */
public class QuickSort {
    private static int count;

    public static void main(String[] args) {
        int[] num = {3,45,78,64,52,11,64,55,99,11,18};
        System.out.println("排序前："+Arrays.toString(num));
        QuickSort(num,0,num.length-1);
        System.out.println("排序后："+Arrays.toString(num));
        System.out.println("数组个数："+num.length);
        System.out.println("循环次数："+count);

        //测试快排的执行速度
        // 创建要给80000个的随机的数组
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }

//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
//        //快速排序
//        QuickSort(arr, 0, arr.length-1);
//
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);

    }

    private static void QuickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(num[j]>=key && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(num[i]<=key && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        count++;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
    }

}
