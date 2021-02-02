package com.sdu.month1.day04;

/**背包问题
 * @author huaikong
 * @create 2021-02-02 8:10
 */
public class Q3_2 {

    public static int process(int[] arr,int index,int rest){
        if(rest < 0){
            return -1;
        }
        if(index == arr.length){
            return 1;
        }
        int next1 = process(arr,index + 1,rest);
        int next2 = process(arr,index + 1,rest - arr[index]);
        return next1 + (next2 == -1 ? 0 : next2);
    }

    public static int ways1(int[] arr,int w){
        return process(arr,0,w);
    }



}
