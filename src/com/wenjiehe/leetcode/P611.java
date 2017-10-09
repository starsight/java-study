package com.wenjiehe.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/9/28.
 */
public class P611 {
    public static void main(String[] args) {
        int a = triangleNumber(new int[]{2,2,3,3});
        ;
    }


    public static int triangleNumber(int[] nums) {
        int count = 0;
        int mid = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            list.add(nums[i]);
        list.sort(null);
        for (int i = 0; i < list.size() - 1; i++)
            for (int j = i + 1; j < list.size(); j++) {
                int sum = (int) list.get(i) + (int) list.get(j);
                int left = j;
                int right = list.size();
                while (right - 1 > left) {
                    mid = (right + left) / 2;
                    if (sum <= (int) list.get(mid))
                        right = mid;
                    if (sum > (int) list.get(mid))
                        left = mid;
                }
                count += left - j;
            }
        return count;
    }
}
