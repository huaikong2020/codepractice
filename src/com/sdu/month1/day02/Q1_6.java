package com.sdu.month1.day02;

/**构造任意长度的数组，任意连续三项满足两侧之和不等于中间项的二倍
 * @author huaikong
 * @create 2021-01-31 8:17
 */
public class Q1_6 {
    public static int[] makeNo(int size){
        if(size == 1){
            return new int[]{1};
        }
        int halfSize = (size + 1) / 2;
        int[] base = makeNo(halfSize);
        int[] ans = new int[size];
        int index = 0;
        for(;index < halfSize;index++){
            ans[index] = base[index] * 2 + 1;
        }
        for(int i = 0;index < size;index++,i++){
            ans[index] = base[i] * 2;
        }
        return ans;
    }
}
