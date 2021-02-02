package com.sdu.month1.day03;

/**有序数组中提取二元组，三元组
 * @author huaikong
 * @create 2021-02-01 9:33
 */
public class Q2_6 {

    public static void printUniquePair(int[] arr,int k){
        if(arr == null || arr.length < 2){
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if(arr[left] + arr(right) < k){
                left++;
            }else if(arr[left] + arr[right] > k){
                right--;
            }else {
                if(left == 0 || arr[left - 1] != arr[left]){
                    System.out.println(arr[left] + "," + arr[right]);;
                }
                left++;
                right--;
            }
        }
    }

    public static void printUniqueTriad(int[] arr,int k){
        if(arr == null || arr.length < 3){
            return;
        }
        for(int i = 0;i < arr.length - 2;i++){
            if(i == 0 || arr[i] != arr[i - 1]){
                printRest(arr,i,i + 1,arr.length - 1,k);
            }
        }
    }

    private static void printRest(int[] arr, int f, int l, int r, int k) {
        while(l < r){
            if(arr[l] + arr[r] < k){
                l++;
            }else if (arr[l] + arr[r] > k){
                r--;
            }else {
                if(l == f + 1 || arr[l - 1] != arr[l]){
                    System.out.println(arr[f] + "," + arr[l] + "," + arr[r]);
                }
                l++;
                r--;
            }
        }
    }

}
