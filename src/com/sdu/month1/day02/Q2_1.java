package com.sdu.month1.day02;

/**行有序列有序数组查找数字
 * @author huaikong
 * @create 2021-01-31 10:52
 */
public class Q2_1 {
    public static boolean isContains(int[][] m,int num){
        int row = 0;
        int col = m[0].length - 1;
        while(row < m.length && col > -1){
            if(m[row][col] == num){
                return true;
            }else if(m[row][col] > num){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
}
