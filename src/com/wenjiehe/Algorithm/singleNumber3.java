package com.wenjiehe.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by yiyuan on 17/2/23.
 */
public class singleNumber3 {

    public static int[] singleNumber3(int[] nums) {
        HashMap hm = new HashMap();
        for (int i = 0; i < nums.length; i++) {
                /*if(hm.isEmpty()){
                    hm.put(nums[i],i);
                    continue;
                }*/
            Object o = hm.get(nums[i]);
            if (o == null) {
                hm.put(nums[i], i);
                //System.out.println(nums[i]);
            } else
                hm.remove(nums[i]);
        }
        Collection<Integer> c = hm.keySet();
        ArrayList a = new ArrayList(c);
        int[] ccc = new int[2];
        for (int i = 0; i < 2; i++) {
            ccc[i] = (Integer) a.get(i);
        }

        return ccc;
    }

    public static int[] singleNumber3_1(int[] nums) {

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        int i;
        for (i = 0; i < 32; i++) {
            if (((num >> i) & 1) != 1)
                i++;
            else
                break;
        }
        int num1 = 0, num2 = 0;
        for (int j = 0; j < nums.length; j++) {
            if (((nums[j] >> i) & 1) != 0) {
                num1 ^= nums[j];
            } else {
                num2 ^= nums[j];
            }
        }

        return new int[]{num1, num2};
    }

    public class Solution {
        public int singleNumber2(int[] nums) {
            int[] bitnums = new int[32];
            int flag = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < 32; j++) {
                    bitnums[j] += ((nums[i] >> j) & 1);
                }
            }
            int ret = 0;
            for (int i = 0; i < 32; i++) {
                ret += (bitnums[i] % 3) << i;
            }

            return ret;
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{-1, 0};
        int[] b;
        b = singleNumber3_1(a);
        //System.out.println(Arrays.toString(b));
        System.out.println((7 >> 1) << 1);
    }
}
