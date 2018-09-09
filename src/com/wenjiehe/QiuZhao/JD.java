package com.wenjiehe.QiuZhao;

import java.util.HashSet;
import java.util.Scanner;

public class JD {
    public static void main(String[] args) {
        solution1();//64%
        //solution2(new int[]{1,2,4,5,3});//0%
    }

    public static long solution1() {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int D = sc.nextInt();
        long count = 0;
        long count1 = 0;
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i <= D; i++) {
            int j = D - i;
            int A1 = X + i;
            int A2 = X - i;
            int AC=0;
            boolean A1C = false;
            boolean A2C = false;
            if (A1 >= 1 && A1 <= R) {
                A1C = true;
                AC++;
            }
            if (A2 >= 1 && A2 <= R && A1 != A2) {
                A2C = true;
                AC++;
            }

            int B1 = X + j;
            int B2 = X - j;
            int BC =0;
            boolean B1C = false;
            boolean B2C = false;
            if (B1 >= 1 && B1 <= C) {
                B1C = true;
                BC++;
                //count1 = check(A1C,B1C,A1,B1,count1,hashSet);
                //count1 = check(A2C,B1C,A2,B1,count1,hashSet);
            }
            if (B2 >= 1 && B2 <= C && B1 != B2) {
                B2C = true;
                BC++;
                //count1 = check(A1C,B2C,A1,B2,count1,hashSet);
                //count1 = check(A2C,B2C,A2,B2,count1,hashSet);
            }
            count += AC * BC;
        }
        //System.out.println(Long.MAX_VALUE);
        //System.out.println(count+"-"+count1);
        return count;

    }

    private static long check(boolean A1C,boolean B1C,int A1,int B1,long count,HashSet<String> hashSet) {
        String str="";
        if (A1C && B1C) {
            str = A1 + "-" + B1;
            if (!hashSet.contains(str)) {
                hashSet.add(str);
                count++;
            }
        }
        return count;
    }

    public static int solution2(int[] a) {
        int len = a.length;
        int max = 0;
        if (len <= 2) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, a[j]);
                if (max == a[j]) {
                    res++;
                }
            }

        }
        return res;
    }
}
