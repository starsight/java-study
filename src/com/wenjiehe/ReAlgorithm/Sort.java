package com.wenjiehe.ReAlgorithm;

import java.util.Arrays;

public class Sort {


    public static void main(String[] args) {
        int[] nums = {5,4,3,2,88,10,7,9,1};

        Sort.maoPaoSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
    * 两两比较，小的放后面，第一次找到最小的放在最后一个，第二次次小的放在倒数第二个，以此类推
    * */
    private static void maoPaoSort(int[] nums){
        for (int i = 0; i <nums.length-1 ; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]<nums[j+1]){
                    int t = nums[j];
                    nums[j] =nums[j+1];
                    nums[j+1] = t;
                }
            }
        }
    }

}
