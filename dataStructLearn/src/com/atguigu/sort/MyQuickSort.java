package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author Skipper
 * @date 2020/08/04
 * @desc
 */
public class MyQuickSort {
    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int begin, int end){

        if (begin >= end){
            return;
        }
        int key = arr[begin];
        int keyIndex = begin;
        int temp = 0;
        for (int i = begin + 1; i < end; i++) {
            if (arr[i] < key){
                keyIndex ++;
                temp  = arr[keyIndex];
                arr[keyIndex] = arr[i];
                arr[i]  = temp;
            }
        }

        arr[begin] = arr[keyIndex];
        arr[keyIndex] = key;

        quickSort(arr,begin,keyIndex);
        quickSort(arr,keyIndex +1, end);
    }
}
