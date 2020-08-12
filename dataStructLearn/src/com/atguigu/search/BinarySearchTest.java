package com.atguigu.search;

public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = {-33,12,24,55,60};
        int num =22;
        int min = 0;
        int max = arr.length;
        int mid = (max + min) / 2;
        int index = -1;
//        while (true){
//
//            if (arr[mid] == num){
//                index = mid;
//                break;
//            }
//            if (arr[mid] > num){
//                max = mid -1 ;
//                mid = (min + max) /2;
//            }
//            if (arr[mid] < num){
//                min = mid +1;
//                mid = (max + min) /2;
//            }
//            if (min > max){
//                break;
//            }
//        }

        System.out.println(index);
        System.out.println(binarySearch(arr,0,arr.length ,24));;
    }

    public static int binarySearch(int[] arr, int left, int right,int num){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (num > midVal){
            return binarySearch(arr,mid +1, right, num);
        }else if (num < midVal){
            return binarySearch(arr, left, mid -1, num);
        }else {
            return mid;
        }
    }
}
