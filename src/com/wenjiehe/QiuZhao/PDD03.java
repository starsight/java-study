package com.wenjiehe.QiuZhao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/5.
 */
public class PDD03 {
    //ac
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] temp = s.split(" ");
        int num = Integer.valueOf(temp[0]);
        int index = Integer.valueOf(temp[1]);
        HashSet<Integer> hashSet = new HashSet();
        int[][] arr = new int[num][];

        for (int i = 0; i < num; i++) {
            s = sc.nextLine();
            temp = s.split(" ");
            int[] ints = new int[temp.length];
            for (int j = 0; j < temp.length; j++) {
                ints[j] = Integer.valueOf(temp[j]);
            }
            arr[i] = ints;
            if (i == index) {
                for (int j = 0; j < temp.length; j++) {
                    hashSet.add(ints[j]);
                }
            }
        }

        int maxCount = 0;
        int count=0;
        int maxIndex = -1;
        for (int i = 0; i < num; i++) {
            if (i != index && !hashSet.contains(i)) {
                for (int j = 0; j < arr[i].length; j++) {
                    if(hashSet.contains(arr[i][j])){
                        count++;
                    }
                }
                if(maxCount<count){
                    maxIndex =i;
                    maxCount =count;
                }
                count=0;
            }
        }
        System.out.println(maxIndex);
    }
}
