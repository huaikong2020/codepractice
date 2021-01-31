package com.sdu.month1.day02;

/**
 * @author huaikong
 * @create 2021-01-31 11:57
 */
public class Q2_3 {

    public static int maxABS(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max - Math.min(arr[0], arr[arr.length - 1]);
    }

}
