package com.wenjiehe.JZOffer;

/**
 * Created by Administrator on 2017/12/21.
 */
public class JZ28 {
    public static void printAllSubsquence(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        process(chs, i+1);
        chs[i] = tmp;
    }

    public static void main(String[] args) {
        String test = "abcde";
        printAllSubsquence(test);
    }
}
