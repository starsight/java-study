package com.wenjiehe.leetcodecn;

import java.util.Arrays;

public class P7 {

    public static int betterReverse(int x) {
        long n = 0;//  注意类型
        while (x != 0) {
            n = x % 10 + n * 10;
            x = x / 10;
        }
        // 很巧妙
        return (int) n == n ? (int) n : 0;
    }

    public static int betterReverse2(int x) {
        int flag = x > 0 ? 1 : -1;

        try {
            String xToStr = String.valueOf(Math.abs(x));
            return flag * Integer.parseInt((new StringBuilder(xToStr)).reverse().toString());
        } catch (Exception e) {
            return 0;
        }

    }

    public static void main(String[] args) {
        betterReverse2(-2147483648);
        System.out.printf(String.valueOf(reverse(2147483647)));
        System.out.printf(String.valueOf(reverse(-1223)));

    }

    public static int reverse(int x) {
        boolean isFuShu = x < 0;
        String toStr = String.valueOf(Math.abs(x));

        if (toStr.length() == 1) {
            return x;
        }

        char[] toChar = toStr.toCharArray();
        char temp;
        for (int i = 0, j = toStr.length() - 1; i < j; i++, j--) {
            temp = toChar[i];
            toChar[i] = toChar[j];
            toChar[j] = temp;
        }
        if (!isFuShu) {
            if (greaterMAXVALUE(toChar)) {
                return 0;
            }
        } else {
            if (smallerMINVALUE(toChar)) {
                return 0;
            }
        }
        int reverseX = Integer.parseInt(String.valueOf(toChar));

        return isFuShu ? -reverseX : reverseX;

    }

    private static boolean smallerMINVALUE(char[] char1) {
        char[] minValueChar = String.valueOf(Integer.MIN_VALUE).toCharArray();
        if (minValueChar.length > 1 + char1.length) {
            return false;
        }
        for (int i = 1; i < minValueChar.length; i++) {
            if (minValueChar[i] < char1[i - 1]) {
                return true;
            } else if (minValueChar[i] > char1[i - 1]) {
                return false;
            }
        }
        return false;
    }

    private static boolean greaterMAXVALUE(char[] char1) {
        char[] maxValueChar = String.valueOf(Integer.MAX_VALUE).toCharArray();
        if (maxValueChar.length > char1.length) {
            return false;
        }
        for (int i = 0; i < maxValueChar.length; i++) {
            if (maxValueChar[i] < char1[i]) {
                return true;
            } else if (maxValueChar[i] > char1[i]) {
                return false;
            }
        }
        return false;
    }


}
