package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/8.
 */
public class P26 {
    public static int removeDuplicates(int[] nums) {
        int num =nums.length;

        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                index++;
                nums[index]=nums[i];
            }else{
                num--;
            }

        }

        return num;
    }

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,2,2});
    }
}
