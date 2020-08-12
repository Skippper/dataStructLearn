package com.atguigu.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{101, 34, 119, 1};

        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

//    public static void insertSort(int[] arr) {
//
//        for (int i = 1; i < arr.length; i++) {
//            //        //定义待插入的数字
//        int insertValue = arr[i];
//        int insertIndex = i -1 ;    //arr[1]前面一个数的下标
//
//        //
//        while (insertIndex >= 0 &&insertValue < arr[insertIndex]){  //说明还未找到位置
//            arr[insertIndex +1] = arr[insertIndex]; //后移
//            insertIndex --;
//        }
//        arr[insertIndex+1] = insertValue;
//        //退出循环时位置找到,insertIndex +1
//            System.out.println("第" + i +"轮插入");
//            System.out.println(Arrays.toString(arr));
//        }
//    }

    public static void insertSort(int[] arr){

        for (int i = 1; i < arr.length; i++) {

            int insertValue = arr[i];
            int insertIndex = i -1;
            while (insertIndex >=0 && insertValue < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex +1] = insertValue;
        }
    }
}
