package com.atguigu.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{33,56,16,39,-1};
        System.out.println("qweqwe ");
        {
            System.out.println("测试代码");
        }
        System.out.println("dsa");
        int temp = 0;
        /*boolean flag = false;   //表示是否进行过交换
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){    //在一次排序中,一次都没发生过
                break;
            }else {
                flag = false;   //重置flag
            }

        }*/

        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag){
                break;
            }else {
                flag = false;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
