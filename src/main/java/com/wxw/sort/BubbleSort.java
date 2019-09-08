package com.wxw.sort;

/**
 * @Author: wxw
 * @create: 2019-09-08-14:58
 *
 * 冒泡排序
 * 每一轮从头开始两两比较，将较大的项放在较小项的右边，
 * 这样每轮下来保证该轮最大的数在最右边。
 */

public class BubbleSort {

    public static   int[] sort(int[] array){
        //for循环表示总共需要比较多少论
        for(int i=1;i<array.length;i++){
            //设定一个标记，若为true，则表示次循环没有进行交换，也就是待排序列已有序列，排序已经完成。
            boolean flag=true;
            //这里for循环表示每轮比较参与元素的下标
            //对当前无序区间array[0......length-1]进行排序
            //j的范围很关键，这个范围是在逐步缩小的，因为每轮比较都会将最大的放在右边
            for(int j=0;j<array.length-i;j++){
                if(array[i]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
            //排序步骤
           //第i论排序的结果为
            System.out.println("第"+i+"轮排序后的结果为：");
            display(array);

        }
        return array;
    }

    //遍历显示数组
    public static void  display(int[] array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4,2,8,9,5,7,6,1,3};
        //未排序数组顺序为
        System.out.println("未排序数组顺序为:");
        display(array);
        System.out.println("-----------------------");
        array=sort(array);
        System.out.println("-----------------------");
        System.out.println("经过冒泡排序后的数组顺序为：");
        display(array);
    }
}
