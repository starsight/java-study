package com.wenjiehe.QiuZhao.Tencent;

import java.util.Scanner;

public class TX03 {
    //50%
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        String P = in.nextLine();

        int res = 0;
        long sum = 0;
        int resTemp = 0;
        int resTemp2 = 0;

        for (int i = 0; i < S.length(); i++) {
            res = S.indexOf(P, i);
            if (res == -1) {
                break;
            }
            resTemp = res;
            resTemp2 = res;

            while (resTemp2 - resTemp <= P.length()) {
                resTemp = resTemp2;
                resTemp2 = S.indexOf(P, resTemp + 1);
                if(resTemp2==-1)
                    break;
            }

            int sq = resTemp - res + P.length();
            sum += sq * sq;
            i = resTemp;
        }
        System.out.println(sum);
    }
}
