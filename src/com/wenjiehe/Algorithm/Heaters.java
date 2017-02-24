package com.wenjiehe.Algorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by wenjie on 17/02/24.
 */
public class Heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        //sort(houses.begin(),houses.end());
        //sort(heaters.begin(),heaters.end());

        int[] nums =new int[houses.length];
        for(int i =0;i<houses.length;i++){
            nums[i] = 1000000000;
            for(int j =0;j<heaters.length;j++){
                int t = Math.abs(heaters[j]-houses[i]);
                if(nums[i] > t)
                    nums[i] = t;
            }
        }
        int max =nums[0];
        for(int i=1;i<nums.length;i++){
            if(max<nums[i])
                max = nums[i];
        }
        return max;

    }

}
