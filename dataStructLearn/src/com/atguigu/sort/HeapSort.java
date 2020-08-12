package com.atguigu.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {6,8,45,96,-1,-935,-55,25};
        HeapSort(arr);
        System.out.println("排序后的数组是:" + Arrays.toString(arr));
    }
    public static void HeapSort(int[] arr){
        int temp = 0 ;

        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjustSort(arr,i,arr.length);
        }

        for (int j = arr.length - 1; j > 0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustSort(arr,0,j);
        }
    }
    public static void adjustSort(int[] arr, int i, int length){
        int temp = arr[i];

        for (int k = 2 * i + 1; k < length; k = 2 *k +1) {
            if (k+1 < length && arr[k] < arr[k+1]){
                k++;
            }
            if (arr[k] > temp){
               arr[i] = arr[k];
               i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;
    }
}

