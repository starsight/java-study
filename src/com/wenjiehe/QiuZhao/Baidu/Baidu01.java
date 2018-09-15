package com.wenjiehe.QiuZhao.Baidu;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/11.
 */
public class Baidu01 {
    //AC
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] input = new long[T];
        for (int i = 0; i < T; i++) {
            input[i] = sc.nextLong();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(solution(input[i]));
//            long[] dp= new long[input[i]];
//            dp[0]=0;
//            for (int j = 1; j < input[i]; j++) {
//                dp[j] = Math.min(dp[j-1],dp[j>>1])+1;
//            }
//            System.out.println(dp[input[i]-1]);
        }

    }

    public static long solution(long x) {
        if (x == 1) {
            return 0;
        }

        if (x % 2 == 1) {
            return 1 + solution(x - 1);
        } else {
            return 1 + solution(x >> 1);
        }

        //return Math.min(solution(x>>1),solution(x-1))+1;
    }
}
