package com.wenjiehe.NowCoder;

import java.util.Scanner;

/**
 * @author wenjie
 */
public class CodeM02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        long[] res = new long[k];
        long max = Long.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < k; i++) {
            res[i] = m*sc.nextInt();
            res[i] += (n-m)*sc.nextInt();
            if(max<res[i]){
                max = res[i];
                index = i;
            }
        }

        for (int i = 0; i < k; i++) {
            if(i!=index) {
                System.out.print("0");
            }else{
                System.out.print(k);
            }

            if(i != k-1){
                System.out.print(" ");
            }
        }
    }
}
