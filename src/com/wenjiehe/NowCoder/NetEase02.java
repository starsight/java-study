package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class NetEase02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.valueOf(in.nextLine());
        //int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            int num = Integer.valueOf(in.nextLine());
            String str = in.nextLine();
            System.out.println(solve(str, num));
        }


    }

    public static int solve(String str, int num) {
        char[] c = str.toCharArray();
        int index = 0;
        int count = 0;
        boolean shouldSet = false;


        while (index <= c.length - 1) {
            if (shouldSet) {
                count++;
                index += 2;
                shouldSet = false;
                continue;
            }

            if (c[index] == '.') {
                if (index >= c.length - 2) {
                    count++;
                    break;
                }
                shouldSet = true;
                index++;
            } else
                index++;
        }

        return count;

    }
}
