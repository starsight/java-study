package com.wenjiehe.Algorithm;

import java.util.*;

/**
 * Created by yiyuan on 17/3/2.
 */
public class InterSection {
    //https://leetcode.com/problems/intersection-of-two-arrays/
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0; i < nums1.length; i++) {
            binarySearch(nums2, nums1[i], 0, nums2.length - 1, map);
        }

        Set keys = map.keySet();

        int[] key = new int[keys.size()];
        Iterator it = keys.iterator();

        for (int i = 0; i < keys.size(); i++) {
            key[i] = (int)it.next();
        }
        return key;
    }


    public void binarySearch(int[] nums, int findNum, int start, int end, Map<Integer, Integer> map) {
        if (start < end) {
            int middle = (end - start) / 2 + start;
            if (nums[middle] > findNum) {
                binarySearch(nums, findNum, start, middle - 1, map);
            } else if (nums[middle] < findNum) {
                binarySearch(nums, findNum, middle + 1, end, map);
            } else {
                map.put(findNum, middle);
            }
        } else if (start == end) {
            if (nums[start] == findNum) {
                map.put(findNum, start);
            }
        }
    }
}
