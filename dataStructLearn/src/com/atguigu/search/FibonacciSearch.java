package com.atguigu.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr,89));
    }
    public static int[] fib(){
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i -1] + arr[i-2];
        }
        return arr;
    }

    public static int fibSearch(int[] arr, int key){

        int low = 0;
        int high = arr.length;
        int k = 0; //表示斐波那契分割数值下标
        int mid = 0;    //存放mid值
        int[] f = fib();
        //获取到斐波那契分割数值的下标
        while (high > f[k] - 1){
            k++;
        }
        //因为f[k]可能大于arr的长度,需要使用Arrays类构建一个新的数组,指向a
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际需求使用a数组最后的数填充temp
        //举例
        //temp = {1,8,10, 1000,1234,0,0}  =>  {1,8,10, 1000,1234,1234,1234,1234}
        for (int i = high +1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high){    //只要这个条件满足,就可找
            mid = low + f[k -1] -1;
            if (key < temp[mid]){   //我们应该继续向数组前面查找
                high = mid -1;
                //1. 全部元素=前面元素+后面元素
                //2. f[k] = f[k-1] + f[k-2]
                //因为前面有f[k-1]个元素,所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                //即在f[k-1]的前面继续查找
                //即下次循环mid = f[k-1-1]-1;
                key--;
            }else if (key > temp[mid]){ //继续向数组后面查找
                low = mid +1;
                //为什么是 k-2
                //1. 全部元素 = 前面元素 + 后边元素
                //2. f[k] = f[k-1] + f[k-2]
                //3. 因为后面我们有f[k-2] 所以可以继续拆分 f[k-1] = f[k-3] + f[k-4]
                //4. 即在f[k-2]前面可以继续查找
                //5. 即下次循环 mid = f[k-1-2] -1
                k -= 2;
            }else { //找到
                if (mid < high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
