package com.wenjiehe.NowCoder;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/7/19.
 */
public class NewCoder0719 {
    // 勉强 AC
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        String[] str = new String[n];
        int[] nums = new int[n];
        char[][] cc = new char[n][];
        int res = 0;
        for (int i = 0; i < n; i++) {
            str[i] = in.nextLine();
            nums[i] = isValid(str[i]);
            cc[i] = str[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if ((nums[i] + nums[j]) == 0) {
                    if (isValid2(cc[i], cc[j]))
                        res++;
                    if (i != j && isValid2(cc[j], cc[i]))
                        res++;
                }
            }
        }
        System.out.println(res);
    }

    public static boolean isValid2(char[] str, char[] str2) {
        char[] chas = str;
        char[] chas2 = str2;
        int st = 0;
        char c;
        for (int i = 0; i < chas.length + chas2.length; i++) {
            if (i < chas.length) {
                c = chas[i];
            } else {
                c = chas2[i - chas.length];
            }
            if (c == '(') {
                st++;
            } else if (c == ')') {
                st--;
            }
            if (st < 0) {
                return false;
            }
        }
        if (st == 0)
            return true;
        return false;
    }

    public static int isValid(String str) {
        char[] chas = str.toCharArray();
        int st = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == '(') {
                st++;
            } else if (chas[i] == ')') {
                st--;
            }
        }
        return st;
    }

}
