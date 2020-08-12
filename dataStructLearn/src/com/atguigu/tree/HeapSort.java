package com.atguigu.tree;

import sun.java2d.pipe.AAShapePipe;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9,-1,90,89,56,-999};
        heapSort(arr);
    }

    //编写一个堆排序方法
    public static void heapSort(int[] arr){
        int temp = 0;
        //
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次调整:" + Arrays.toString(arr));    //4 9 8 5 6
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次调整:" + Arrays.toString(arr));    // 9 6 8 5 4
        for (int i = arr.length / 2 -1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length -1; j > 0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println("排序后:" + Arrays.toString(arr));
    }

    //将一个数组(二叉树),调整程一个大顶堆

    /**
     *功能: 完成以 i 对应的非叶子节点的树调整程大顶堆
     * {4,6,8,5,9} -> i==1 adjustHeap -> 得到 {4,9,8,5,6}
     * @param arr 待调整数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 对多少个元素调整
     */
//    public static void adjustHeap(int[] arr,int i, int length){
//
//        int temp = arr[i];
//        //k = 2 * k + 1 k是i节点的左子节点
//        for (int k = i * 2 +1; k < length; k = k * 2 +1) {
//            if (k +1 < length && arr[k] < arr[k+1]){ //说明左子节点值小于右子节点值
//                k++; //k指向右子节点
//            }
//            if (arr[k] > temp){//如果子节点大于父节点
//                arr[i] = arr[k];    //把较大的值赋给当前节点
//                i =k; //!! i指向k  继续循环比较
//            }else {
//                break;
//            }
//        }
//        arr[i] = temp; //将temp值放到调整后的位置
//
//    }
    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];

        for (int k = 2 * i +1; k < length; k = 2 * k +1) {
            if ( k + 1 < length &&arr[k] < arr[k + 1]) {
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
