package com.wenjiehe.QiuZhao.ByteDance;

import java.util.Scanner;

public class bytedance02_03 {
    // 0%
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());

        String[] str1 = new String[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.valueOf(sc.nextLine());
            String[] str = new String[n];
            for (int j = 0; j < n; j++) {
                str[j] =sc.nextLine();
            }
            str1[i]=compare(str);
        }

        for (int i = 0; i < t; i++) {
            System.out.println(str1[i]);
        }
    }

    public static String compare(String[] str) {
        for (int i = 0; i < str.length; i++) {
            String s = str[i] + str[i];

            for (int j = i+1; j < str.length; j++) {
                if(str[i].length()!=str[j].length()){
                    continue;
                }
                if(kmp(s,str[j])!=-1){
                    //System.out.println();
                    return "Yeah";
                }
            }
            s = reverse(s);
            for (int j = i+1; j < str.length; j++) {
                if(kmp(s,str[j])!=-1){
                    //System.out.println("Yeah");
                    return "Yeah";
                }
            }
        }
        //System.out.println("Sad");
        return "Sad";
    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }


    static void getNext(String pattern, int next[]) {
        int j = 0;
        int k = -1;
        int len = pattern.length();
        next[0] = -1;

        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {

                j++;
                k++;
                next[j] = k;
            } else {

                // 比较到第K个字符，说明p[0——k-1]字符串和p[j-k——j-1]字符串相等，而next[k]表示
                // p[0——k-1]的前缀和后缀的最长共有长度，所接下来可以直接比较p[next[k]]和p[j]
                k = next[k];
            }
        }

    }

    static int kmp(String s, String pattern) {
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();

        int[] next = new int[plen];

        getNext(pattern, next);

        while (i < slen && j < plen) {

            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }

            }

            if (j == plen) {
                return i - j;
            }
        }
        return -1;

    }
}
