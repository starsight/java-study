package com.wenjiehe.ReAlgorithm;

import java.util.Arrays;

public class Sort {


    public static void main(String[] args) {
        int[] nums = {5,4,3,2,88,10,7,9,91,10,23,54,33,22,5,8,44,1};

        //Sort.maoPaoSort(nums);
        Sort.quickSort1(nums,0,nums.length-1);

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

    /***
     * 剑指offer的方法 P64
     */
    private static void  quickSort1(int[] num,int start,int end){
        if(start==end)
            return ;
        int index = partition(num,start,end);
        if(index>start)
            quickSort1(num,start,index-1);
        if(index<end)
            quickSort1(num,index+1,end);
    }

    private static int partition(int[] num ,int start,int end){
        int index =start;
        for(int i= start;i<end;i++){
            if(num[i]<num[end]){
                if(index!=i){
                    swap(num,i,index);
                }
                index++;
            }
        }
        swap(num,index,end);
        return index;
    }

    private  static void swap(int[] num,int i ,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] =temp;
    }


}
