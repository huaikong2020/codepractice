package com.sdu.month1day01;

/**括号匹配问题
 * @author huaikong
 * @create 2021-01-30 17:47
 */
public class Q1_2 {

    public static boolean valid(String s){
        char[] str = s.toCharArray();
        int count = 0;
        for(int i = 0;i < str.length;i++){
            count += str[i] == '(' ? 1 : -1;
//            count -= str[i] == ')' ? 1 : 0;
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }

    public static int needNum(String s){
        int left = 0;
        int right = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                right++;
            }else{
                if(right == 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return left + right;
    }

}
