package com.wenjiehe.QiuZhao.Baidu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/11.
 */
public class Baidu02 {
    //0.64
    private static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private static int[] maoPaoSort(int[] nums) {
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
//                    int t = nums[j];
//                    nums[j] =nums[j+1];
//                    nums[j+1] = t;
                    swap(nums, j, j + 1);
                    swap(index, j, j + 1);
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] min = new int[N];
        int[] gap = new int[N];
        //HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            min[i] = sc.nextInt();
            gap[i] = sc.nextInt() - min[i];
            //hashMap.put(min[i], i);
        }
        int[] index1 = maoPaoSort(min);
        int[] index2 = maoPaoSort(gap);
        int sum = 0;
        //int index = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            sum += min[i];
            if (sum > T) {
                sum -= min[i];
                //index = min[i];
                break;
            } else {
                hashSet.add(index1[i]);
            }
        }
        int i;
        for (i = 0; i < N; i++) {
            if (hashSet.contains(index2[i])) {
                sum += gap[i];
                if (sum > T) {
                    sum = T;
                    //sum -= gap[i];
                    break;
                }
            }
        }
//        if (i == N - 1 && sum < T) {
//            i = hashSet.size();
//            for (int j = 0; j < N - hashSet.size(); j++, i++) {
//                sum = sum - min[j] - gap[j];
//                sum += min[i];
//                if(sum<T){
//
//                }
//            }
//
//        }
        System.out.println(sum);
    }
}
