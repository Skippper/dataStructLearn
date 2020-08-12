package com.atguigu.sort;

import java.util.Arrays;

/**
 * @author Skipper
 * @date 2020/08/12
 * @desc   快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {33,45,97,55,63,48,28,19,72};
        System.out.println("排序前 : " + Arrays.toString(arr));
        quickSort(arr,0,arr.length);
        System.out.println("排序后 : " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end){
        if (begin >= end){ //中断条件
            return;
        }
        int key = arr[begin];
        int keyIndex = begin;
        int temp = 0;
        for (int i = begin + 1; i < end; i++) {
            if (arr[i] < key){
                keyIndex ++;
                temp = arr[i];
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
