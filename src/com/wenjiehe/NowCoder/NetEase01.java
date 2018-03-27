package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class NetEase01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int clockCount = in.nextInt();
        int[][] clock = new int[clockCount][2];
        for (int i = 0; i < clockCount; i++) {
            clock[i][0] = in.nextInt();
            clock[i][1] = in.nextInt();
        }

        int allTime = in.nextInt();
        int[] classTime = new int[2];
        classTime[0] = in.nextInt();
        classTime[1] = in.nextInt();

        allTime = classTime[0] * 60 + classTime[1] - allTime;

        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = clockCount - 1; i >= 0; i--) {
            int time = clock[i][0] * 60 + clock[i][1];
            if (time <= allTime && time > max) {
                max = time;
                index = i;
            }
        }

        System.out.println(clock[index][0] + " " + clock[index][1]);

    }


}
