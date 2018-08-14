package com.wenjiehe.QiuZhao.Netease;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/11.
 */
public class Netease0811_02 {
    // 60% 修正middle==0时的判断->100%
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] apple = new int[n];

        for (int i = 0; i < n; i++) {
            apple[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int result[] = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += apple[i];
            apple[i] = count;
        }

        int index = 1;

        for (int i = 0; i < m; i++) {
            index = binarySearch(apple, result[i]);
            System.out.println(index + 1);

        }

    }

    public static int binarySearch(int[] arr, int des) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (middle == 0) {
                //对于在0，和在1没有校验！
                if(arr[middle]>des) {
                    return 0;
                }else{
                    return 1;
                }
            }
            if (arr[middle] >= des && arr[middle - 1] < des) {
                //index =middle;
                return middle;
            } else if (arr[middle] < des) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    //最简洁的办法
    public static int BinarySearch(int[] arr, int des) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;

            if (arr[middle] == des) {
                return middle;
            } else if (arr[middle] < des) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }
}
