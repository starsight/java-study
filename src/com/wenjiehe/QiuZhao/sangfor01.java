package com.wenjiehe.QiuZhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class sangfor01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int[] input = new int[m];
        for (int i = 0; i < m; i++) {
            input[i] = in.nextInt();
        }
        ArrayList a = allSort(input, 0, m - 1);
//        for (int i = 0; i < m; i++) {
//            int res = input[i];
//            for (int j = i; j < m; j++) {
//                res+=
//            }
//        }

    }

    static ArrayList<Integer> allSort(int[] array, int begin, int end) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int res = 0;
        int n = array.length;
        int nbit = 1 << n;
        for (int i = 0; i < nbit; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 1 << j;
                if ((tmp & i) != 0) {
                    res += array[j];
                    arrayList.add(array[j]);
                    //System.out.print(array[j] + " ");
                }
            }
            if (res == 100) {
                return arrayList;
            } else {
                res = 0;
                arrayList.clear();
            }
            //System.out.println();

        }

        return arrayList;
    }

}
