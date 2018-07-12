package com.wenjiehe.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P523 {
    public static void main(String[] args) {
        checkSubarraySum(new int[]{23,2,4,6,7},6);
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        // 自己的思路
        int len = nums.length;
        int[] dp = new int[len];
        boolean res = false;
        if(nums==null||len<2){
            return false;
        }
        //dp[0] = nums[0];
        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                dp[j]+=nums[i];
                if(modK(dp[j],k)&&i!=j){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean modK(int num,int k){
        if(k==0){
            if(num==0){
                return true;
            }
        }else if(num%k==0){
            return true;
        }
        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // 思路：按序遍历，计算前i项和，求余数，如果遇到的余数之前存在过，那么这两个相同余数中间的一段是可以被整除的。注意数组中出现0或k为0.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int t = k == 0 ? sum : sum % k;

            if (map.containsKey(t)) {
                if (i - map.get(t) > 1) {
                    return true;
                }
            } else {
                map.put(t, i);
            }
        }
        return false;
    }
}
