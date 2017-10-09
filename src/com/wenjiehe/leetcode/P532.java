package com.wenjiehe.leetcode;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/9/14.
 */
public class P532 {
    public static int findPairs(int[] nums, int k) {
        int[] change = new int[2];//0 -min 1- max
        int len =  nums.length;
        int count=0;
        boolean min=true,max=true;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        if(k<0)
            return 0;
        for (int i = 0; i < len; i++) {
            change[0] = nums[i]-k;
            change[1] = nums[i]+k;
            min =true;
            max =true;
            for (int j = i+1; j < len; j++) {
                if(nums[j]==change[0]&&min){
                    if(null==hashMap.get(change[0])){
                        count++;
                        min=false;
                        hashMap.put(change[0],nums[i]);
                    }
                }else if(nums[j]==change[1]&&max){
                    if(null==hashMap.get(nums[i])) {
                        count++;
                        max = false;
                        hashMap.put(nums[i],change[1]);
                    }
                }
                if(!max&&!min)
                    break;
            }
        }
        return count;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(hashmap.containsKey(nums[i])){
                int x = hashmap.get(nums[i]);
                if(i-x<=k)
                    return true;
                else
                    hashmap.put(nums[i],i);
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        findPairs(new int[]{1, 1, 1, 2, 1},1);

    }
}
