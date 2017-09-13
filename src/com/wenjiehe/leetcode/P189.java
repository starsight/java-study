package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/11.
 */
public class P189 {
    public static void rotate(int[] nums, int k) {
        if(nums.length==1)
            return ;

        if(k==0)
            return;

        int[] temp = new int[k];
        for(int i=0;i<k;i++){
            temp[i] = nums[nums.length-1-i];
        }


        for(int i=nums.length-1;i>=k;i--)
            nums[i]=nums[i-k];


        for(int i=0;i<k;i++){
            nums[i]= temp[k-i-1];
        }

    }

    public static void main(String[] args) {
        rotate(new int[]{1,2},1);
    }
}
