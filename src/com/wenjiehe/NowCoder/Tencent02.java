package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class Tencent02 {
    /*
    * 20%
    * 这个版本未测试
    * */
    public static void main(String[] args) {
        Tencent02 tencent02 = new Tencent02();
        tencent02.solve();
    }

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//day
        int m = sc.nextInt();//cho

        double sum = 0;
        sum = Math.pow(2, n) - 1;


        int temp =0;

        if(sum>m){
            //很大情况下，sum>m
            for (int i = n; i >0 ; i--) {
                int x = n+ (int)Math.pow(2,n-i)-1;
                if(x<=m)
                    temp=(int)(Math.pow(2,n-i-1));
                else
                    break;
            }

            System.out.println(temp);
            return;
        }

        int base = (int) (Math.pow(2, n - 1));
        int start = base * ((int) (m / sum));
        int end = (base) * (1 + (int) (m / sum));

        for (int i = end - 1; i >= start; i--) {
            if (check(i, n, m)) {
                System.out.println(i);
                return;
            }
        }


    }

    public boolean check(int index, int day, int cho) {
        int i = 0;
        int sum = 0;
        for (i = 0; i < day; i++) {
            if (index % 2 == 0) {
                sum += index;
                index = index >> 1;
            } else {
                sum += index;
                index = (index + 1) >> 1;
            }
        }

        if (i == day && sum <= cho) {
            return true;
        }
        return false;
    }
}
