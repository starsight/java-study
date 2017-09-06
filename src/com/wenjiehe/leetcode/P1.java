package com.wenjiehe.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/9/6.
 */
public class P1 {

    public static void main(String[] args) {

     int[] re =twoSum(new int[]{230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789
     },542);
     System.out.println(re[0]+"-"+re[1]);

    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer,Integer> hashmap = new HashMap<>();

        //List arrayList = Arrays.asList(nums);

        HashMap<Integer,Integer> index = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(index.get(nums[i])==null)
                index.put(nums[i],i);
            else if(2*nums[i]==target){
                result[0]=i;
                result[1]=index.get(nums[i]);
                return result;
            }
        }

        for(int i=0;i<nums.length;i++){
            //if(hashmap.get(target-nums[i])==null)
            hashmap.put(target-nums[i],nums[i]);
        }

        //Set set = hashmap.keySet();
        for(int i=0;i<nums.length;i++){
            if(hashmap.get(nums[i])!=null){
                if(index.get(nums[i])!=index.get(target-nums[i])){
                    result[0]=index.get(nums[i]);
                    result[1]=index.get(target-nums[i]);
                }

            }
        }
        return result;
    }

}
