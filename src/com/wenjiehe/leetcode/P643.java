package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/7.
 */
public class P643 {
    public static  double findMaxAverage(int[] nums, int k) {

        int ave =0;

        for(int i=0;i<k;i++){
            ave+=nums[i];
        }
        //ave=ave/k;
        int temp=ave;

        for(int i=k;i<nums.length;i++){
            temp=temp-nums[i-k]+nums[i];
            if(temp>ave)
                ave=temp;
        }

        return 1.0*ave/k;
    }

    public static void main(String[] args) {
        findMaxAverage(new int[]{0,4,0,3,2},1);
    }
}
