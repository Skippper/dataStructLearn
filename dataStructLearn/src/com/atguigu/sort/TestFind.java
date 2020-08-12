package com.atguigu.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Skipper
 * @date 2020/08/07
 * @desc
 */
public class TestFind {
    public static void main(String[] args) {
        int[]  arr = {2, 7, 2, 11,-2, 15};
        int target = 9;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + arr[i + 1] == target){
                map.put(arr[i],arr[i+1]);
            }
        }

        System.out.println(map);
    }
}
