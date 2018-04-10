package com.wenjiehe.NowCoder;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/10.
 */
public class Xiaomi01 {
    public static void  main(String []args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(solution(n));


    }

    static long solution(int n) {
        int[] result = {1,2};
        if(n<=2){
            return result[n-1];
        }

        long one =2;
        long two =1;
        long res =0;
        for (int i = 3; i <=n; i++) {
            res =one+two;
            two =one;
            one=res;
         }

        return res;
    }
}
