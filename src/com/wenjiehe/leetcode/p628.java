package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/7.
 */
public class p628 {
    public static int maximumProduct(int[] nums) {
        int[] max =new int[3];
        int[] min =new int[2];

        //boolean[] daYuZero = new  boolean[5];

        min[0]=1000000000;
        min[1]=1000000000;
        max[0]=-1000000000;
        max[1]=-1000000000;
        max[2]=-1000000000;

        for(int i=0;i<nums.length;i++){
            if(max[2]<nums[i]){
                max[0]=max[1];
                max[1]=max[2];
                max[2]=nums[i];
            }else if(max[1]<nums[i]){
                max[0]=max[1];
                max[1]=nums[i];
            }else if(max[0]<nums[i]){
                max[0]=nums[i];
            }

            if(min[1]>nums[i]){
                min[0]=min[1];
                min[1]=nums[i];
            }else if(min[0]>nums[i]){
                min[0]=nums[i];
            }

        }

        int maxP =-1000000000;
        for(int i=0;i<3;i++){
            int temp = max[i]*min[0]*min[1];
            if(temp>maxP)
                maxP=temp;
        }

        int temp=max[0]*max[1]*max[2];
        if(temp>maxP)
            return temp;
        else
            return maxP;

    }

    public static void main(String[] args) {
        maximumProduct(new int[]{-1,-2,-3});
    }
}
