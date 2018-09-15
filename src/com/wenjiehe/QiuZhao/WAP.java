package com.wenjiehe.QiuZhao;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class WAP {
    // 70%
    public static int maxGap(int a, String b) {
        String c = Integer.toBinaryString(a);
        char[] c1 = c.toCharArray();
        char[] c2 = b.toCharArray();
        int gap = 0;
        for (int i = c2.length - 1, j = c1.length - 1; i >= 0; i--, j--) {
            if (j < 0) {
                if ('0' != c2[i]) {
                    gap++;
                }
            } else if (c1[j] != c2[i]) {
                gap++;
            }
        }
        return gap;
    }

    public static String convert(int k, int obj) {
        String ss = Integer.toBinaryString(obj);
        char[] cc = new char[k];

        if (ss.length() < k) {
            for (int i = 0; i < k - ss.length(); i++) {
                cc[i] = '0';
            }
        }
        for (int i = ss.length() - 1, j = cc.length - 1; i >= 0; i--, j--) {
            cc[j] = ss.charAt(i);
        }
        return new String(cc);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        char[] res = new char[k];
        String[] str = new String[n];
        int len = (int) Math.pow(2, k);
        int obj = 0;
        int maxGap = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            str[i] = s;
        }

        for (int i = 0; i < len; i++) {
            int temp = 0;
            int tempMin = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                temp = maxGap(i, str[j]);
                if (temp < tempMin) {
                    tempMin = temp;
                }
            }
            if (tempMin > maxGap) {
                obj = i;
                maxGap = tempMin;
            }
        }

        System.out.println(convert(k, obj));
    }
//
//        int num0 = 0;
//        int num1 = 0;
//
//        for (int i = 0; i < k; i++) {
//            int j = 0;
//            num0 = 0;
//            num1 = 0;
//
//            for (j = 0; j < n; j++) {
//                char x = str[j].charAt(i);
//                if (x == '0') {
//                    num0++;
//                } else if (x == '1') {
//                    num1++;
//                }
//            }
//
//            if(num0>num1){
//                res[i] ='1';
//            }else{
//                res[i]='0';
//            }
//
//        }
//        String output = new String(res);
//        int base =output.length()-1;
//
//        while(hashSet.contains(output)){
//            char[] c = output.toCharArray();
//            c[base] = c[base]=='0'?'1':'0';
//            base--;
//            output = new String(c);
//        }
//
//        System.out.println(output);

}
