package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {

        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);
        }
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(date1));
        shellSort2(arr);
        Date date2 = new Date();
        System.out.println(format.format(date2));
    }

    public static void shellSort2(int[] arr){

        int count = 0;

        for (int gap = arr.length /2; gap > 0 ; gap /= 2) {
            for (int i = gap; i < arr.length;  i++) {
                int j = i;
                int temp =arr[j];
               if (arr[j] < arr[ j - gap]){
                   while ( j - gap >=0 && temp < arr[j - gap]){
                     arr[j] = arr[j - gap];
                     j -=gap;
                   }

                   arr[j] = temp;
               }
            }
        }
    }
    public static void shellSort(int[] arr) {
        //使用循环处理
        for (int gap = arr.length /2; gap < arr.length; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                if (arr[j] < arr[j - gap]){
                    while (j - gap > 0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }

        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共有gap组,步长gap)
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + ++count + "轮" + Arrays.toString(arr));
        }


        //希尔排序第一轮
        //第一轮,讲数组分为5组
//        for (int i = 5; i < arr.length; i++) {
//            //遍历各组中所有的元素(共有5组,每组两个)
//            for (int j =  i -5; j >= 0 ; j -= 5) {
//                if (arr[j] > arr[j + 5]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+5];
//                    arr[j+5] = temp;
//                }
//            }
//        }
//        System.out.println("希尔第一轮排序" + Arrays.toString(arr));
//
//        //第2轮,讲数组分为2组
//        for (int i = 2; i < arr.length; i++) {
//            //遍历各组中所有的元素(共有5组,每组两个)
//            for (int j =  i -2; j >= 0 ; j -= 2) {
//                if (arr[j] > arr[j + 2]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+2];
//                    arr[j+2] = temp;
//                }
//            }
//        }
//        System.out.println("希尔第2轮排序" + Arrays.toString(arr));
//
//        //第3轮,数组分为1组
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有的元素(共有5组,每组两个)
//            for (int j =  i - 1; j >= 0 ; j --) {
//                if (arr[j] > arr[j + 1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
//        System.out.println("希尔第3轮排序" + Arrays.toString(arr));
    }
}
