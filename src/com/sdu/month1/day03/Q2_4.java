package com.sdu.month1.day03;

/**一维数组装水问题
 * @author huaikong
 * @create 2021-02-01 7:39
 */
public class Q2_4 {

    public static int water(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        int N = arr.length;
        int L = 1;
        int leftMax = arr[0];
        int R = N - 2;
        int rightMax = arr[N - 1];
        int water = 0;
        while(L <= R){
            if(leftMax <= rightMax){
                water += Math.max(0,leftMax - arr[L]);
                leftMax = Math.max(leftMax,arr[L++]);
            }else {
                water += Math.max(0,rightMax - arr[R]);
                rightMax = Math.max(rightMax,arr[R--]);
            }
        }
        return water;
    }

}
