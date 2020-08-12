package com.atguigu.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end){
            return;
        }
        int key = arr[begin];
        int keyIndex = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < key) {
                keyIndex++;
                int temp = arr[i];
                arr[i] = arr[keyIndex];
                arr[keyIndex] = temp;
            }
        }

        arr[begin] = arr[keyIndex];
        arr[keyIndex] = key;
        quickSort(arr,begin,keyIndex);
        quickSort(arr,keyIndex+1,end);
    }
}
