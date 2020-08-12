package com.atguigu.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        System.out.println(insertValueSearch(arr,0,arr.length -1,76));
    }

    //插值查找算法
    public static int insertValueSearch(int[] arr, int left , int right, int findVal){
        if (left > right || findVal > arr[arr.length -1]){
            return -1;
        }
        //求出mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal){
            return insertValueSearch(arr, mid +1, right, findVal);
        }else if (findVal < midVal){
           return   insertValueSearch(arr, left, mid -1, findVal);
        }else {
            return mid;
        }
    }
}
