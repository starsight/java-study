package com.wenjiehe.QiuZhao;

import java.util.Scanner;

public class XieCheng {
    public static void main(String[] args) {
        solution3();
    }

    public static void solution1() {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        int i = 0;
        for (int k = 0; k < str.length; k++) {
            i += binaryToDec(str[k]);
        }

        System.out.println(decToBinary(i));
    }

    //二进制转十进制数字
    public static int binaryToDec(String binaryValue) {
        int dec = 0;
        for (int i = 0; i < binaryValue.length(); i++) {
            dec = dec * 2 + (binaryValue.charAt(i) - '0');
        }
        return dec;
    }

    //十进制转二进制字符串
    public static String decToBinary(int decValue) {
        StringBuilder binaryValue = new StringBuilder();
        do {
            int temp = decValue % 2;
            binaryValue.append((char) (temp + '0'));
            decValue /= 2;
        } while (decValue != 0);
        return binaryValue.reverse().toString();
    }


    public static void solution2() {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("@");
        char[] char1 = str[0].toCharArray();
        char[] char2 = str[1].toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int k = 0; k < char2.length; k++) {
            if (i < char1.length && char1[i] == ' ') {
                k--;
                i++;
                continue;
            }

            if (i < char1.length && char1[i] == char2[k]) {
                i++;
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        if (i == char1.length) {
            System.out.println(sb.toString());
        } else {
            StringBuilder sb1 = new StringBuilder();
            for (int j = 0; j < char2.length; j++) {
                sb1.append("0");
            }
            System.out.println(sb1.toString());
        }
    }

    public static void solution3() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        double[] argb = new double[4];
        double[][] matric = new double[][]{
                {1, 0, 0, 0, 0},
                {0, 1, 0.1f, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0.2f, 0, 1, 0},
                {0.2f, 0.1f, 0.1f, 0.5f, 1}
        };

        for (int i = 0; i < 8; i += 2) {
            argb[i >> 1] = 1.0 * Integer.valueOf(str.substring(i, i + 2),16) / 255;
        }

        int[] res = new int[4];
        String result = "";
        for (int i = 0; i < 4; i++) {
            double t = 255 * (argb[0] * matric[i][0] + argb[1] * matric[i][1] + argb[2] * matric[i][2] + argb[3] * matric[i][3]);
            res[i] = (int) (t % 255);
            String s =Integer.toHexString(res[i]);
            result += s.length()==2?s:"0"+s;
        }
        System.out.println(result.toUpperCase());
    }

}
