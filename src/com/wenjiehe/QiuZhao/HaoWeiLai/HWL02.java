package com.wenjiehe.QiuZhao.HaoWeiLai;

import java.util.ArrayList;
import java.util.Scanner;

public class HWL02 {
    //0%
    public static void main(String[] args) {
        //System.out.println(Math.floor(3.2));
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] result = new long[t];
        for (int i = 0; i < t; i++) {
            long x = sc.nextLong();
            long k = sc.nextLong();
            result[i] = s(x, k);
            System.out.println(s1(x, k));
        }
        for (int i = 0; i < t; i++) {
            System.out.println(result[i]);
        }
    }

    public static long s(long x, long k) {
        String s1 = Long.toBinaryString(x);
        String s2 = Long.toBinaryString(k);
        s1 = convert(s1);
        s2 = convert(s2);
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        ArrayList<Character> arrayList = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] == '1') {
                index.add(i);
            }
        }
        for (int i = 0; i < char2.length; i++) {
            arrayList.add(char2[i]);
        }
        for (int i = 0, j = 0; j < index.size(); j++, i++) {
            if (index.get(j) + j < arrayList.size()) {
                arrayList.add(index.get(j) + j, '0');
            } else {
                break;
            }
        }


        char[] res = new char[arrayList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arrayList.get(i);
        }

        String ss = convert(new String(res));

        return Long.valueOf(ss, 2);
    }

    public static String convert(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

    public static long s1(long x, long k) {
        long y = 1, t1, t2;
        while (k > 0) {
            t1 = x + y;
            t2 = x | y;
            if (t1 == t2) {
                k--;
            }
            y++;
        }
        return --y;
    }
}
