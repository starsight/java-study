package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/8.
 */
public class P27 {
    public static int removeElement(int[] nums, int val) {
        int index=0;
        int num=nums.length;
        for(int i=0;i<num;i++){
            if(nums[i]!=val){
                int temp =nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        removeElement(new int[]{2},3);
    }
}
