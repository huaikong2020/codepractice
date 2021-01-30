package com.sdu.month1day01;

/**最大覆盖问题
 * @author huaikong
 * @create 2021-01-30 17:19
 */
public class Q1_1 {

    public static int maxPoint1(int[] arr,int L){
        int res = 1;
        for(int i = 0;i < arr.length;i++){
            int nearest = nearestIndex(arr,i,arr[i] - L);
            res = Math.max(res,i - nearest + 1);
        }
        return res;
    }

    private static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while(L <= R){
            int mid = L + ((R - L) >> 1);
            if(arr[mid] >= value){
                R = mid - 1;
                index = mid;
            }else{
                L = mid + 1;
            }
        }
        return index;
    }


    public static int maxPoint2(int[] arr,int L){
        int left = 0;
        int right = 0;
        int max = 0;
        while(left < arr.length){
            while(right < arr.length && arr[right] - arr[left] <= L){
                right++;
            }
            max = Math.max(max,right - (left++));
        }
        return max;
    }

}
