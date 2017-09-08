package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/8.
 */
public class P581 {
    public static int findUnsortedSubarray(int[] nums) {
        int length =nums.length;
        boolean[] change = new boolean[length-1];
        int first=-1,last=0;
        for (int i = 1; i < length; i++) {
            if(nums[i-1]<=nums[i])
                change[i-1]=true;
            else {
                if (first==-1)
                    first=i-1;
                change[i - 1] = false;
                last=i;
            }
        }

        int max=-1000000000;
        int min=1000000000;

        if(first==-1)
            first=0;

        for(int i=first;i<=last;i++){
            if(nums[i]>max)
                max=nums[i];
            if(nums[i]<min)
                min=nums[i];
        }

        boolean left=true,right=true;
        while(left||right){
            if(first>0) {
                if (nums[first - 1] > min) {
                    first--;
                } else
                    left = false;
            }else
                left=false;

            if(last<length-1){
                if (nums[last + 1] < max) {
                    last++;
                } else
                    right = false;
            }else
                right=false;

        }
        if(last==first)
            return 0;
        return last-first+1;
    }

    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{-1,-1,-1,-1,-1});
    }
}
