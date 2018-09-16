package com.wenjiehe.QiuZhao.Tencent;

import java.util.Scanner;

public class TX02 {
    //ac 不知道怎么就过了……
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = in.nextInt();
        }

        int sum = 1;
        int indexNoZero;
        for (indexNoZero = 0; indexNoZero < N; ) {
            if (num[indexNoZero] == 0) {
                indexNoZero++;
            } else {
                break;
            }
        }
        if (indexNoZero == N) {
            System.out.println(0);
            return;
        }

        int[] res = new int[]{1, 1};
        for (int i = indexNoZero + 1; i < N; i++) {
            res[1] = i + 1;
            if (num[i] == 0) {
                res = solution(num, i);
            }
            sum *= res[0];
            i = res[1] - 1;
            res[0] = 1;

        }
        System.out.println(sum);
    }

    // return [0] count, [1] next index
    public static int[] solution(int[] num, int before0) {
        int[] res = new int[]{1, before0 + 1};
        if (before0 == num.length - 1) {
            return new int[]{1, before0 + 1};
        }

        for (int i = before0; i < num.length; i++) {
            if (num[i] != 0) {
                res[1] = i;
                res[0] = i - before0 + 1;
                break;
            }
        }
        return res;
    }
}