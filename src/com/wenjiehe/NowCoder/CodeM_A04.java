package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class CodeM_A04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[][] arr= new int[n+1][n+1];
        int[][] count= new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            arr[from][to] = sc.nextInt();
            count[from][to] = sc.nextInt();
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int f =sc.nextInt();
            int r =sc.nextInt();
            soultion(arr,count,f,r);
        }

    }

    public  static long soultion(int[][] arr, int[][] count,int f,int t){
        int len =arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {

            }
        }

        return 0;

    }


}
