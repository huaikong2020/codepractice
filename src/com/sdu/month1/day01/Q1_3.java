package com.sdu.month1.day01;

/**最长有效括号字串
 * @author huaikong
 * @create 2021-01-30 18:00
 */
public class Q1_3 {

    public static int maxLength(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        int pre = 0;
        int res = 0;
        for(int i = 1;i < str.length;i++){
            if(str[i] == ')'){
                pre = i - dp[i - 1] - 1;
                if(pre >= 0 && str[pre] == '('){
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
