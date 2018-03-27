package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class NetEase03 {

    /**out memory
     * accept20%
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int w = in.nextInt();

        int[] weight = new int[n];
        int[][] res = new int[n + 1][w + 1];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }

        res[0][0] = 1;
        for (int i = 1; i <= w; i++){
            res[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j - weight[i - 1] < 0) {
                    res[i][j] = res[i - 1][j];
                } else {
                    res[i][j] = res[i - 1][j] +res[i-1][j-weight[i-1]];
                }
            }

        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= w; j++) {
//                for (int k = j-1; k >=0 ; k--) {
//                    if(k+weight[i-1]<=j-1){
//                        res[i][j]+=res[i-1][k];
//                        break;
//                    }
//                }
//                res[i][j]+=res[i-1][j];
//            }
//
//        }

        System.out.println(res[n][w]);
    }
}

