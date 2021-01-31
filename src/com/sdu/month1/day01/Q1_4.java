package com.sdu.month1.day01;

/**RGRGR ----> RRRGG
 * 最佳染色方案
 * @author huaikong
 * @create 2021-01-30 18:14
 */
public class Q1_4 {
    public static int minPaint(String s){
        if(s == null || s.length() < 2){
            return 0;
        }
        char[] str = s.toCharArray();
        int rAll = 0;
        for(int i = 0;i < str.length;i++){
            rAll += str[i] == 'R' ? 1 : 0;
        }
        int res = rAll;
        int left = 0;
        for(int i = 0;i < str.length;i++){
            left += str[i] == 'G' ? 1 : 0;
            rAll -= str[i] == 'R' ? 1 : 0;
            res = Math.min(res,left + rAll);
        }
        return res;
    }
}
