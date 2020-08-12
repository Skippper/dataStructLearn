package com.atguigu.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{33,56,16,39,-1};

        /*for (int i = 0; i < arr.length - 1; i++) {
            int keyIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[keyIndex]){
                    keyIndex = j;
                }
            }

           int temp = arr[i];
            arr[i] = arr[keyIndex];
            arr[keyIndex] = temp;
        }*/

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
