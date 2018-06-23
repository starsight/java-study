package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class CodeM_B03 {
    public static long lowbit(int r){
        int count =0;
        while(count<=31){
            if((r&1)==1){
                return  (long)Math.pow(2,count);
            }else{
                count++;
                r= r>>>1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int [][] f= new int[n][n];

    }
}
