package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class JD02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count =1;
        for (int i = 0; i < n; i++) {
            long num = sc.nextLong();
            long temp =num;
            while((num&1)!=1&&count<=63){
                num=num>>1;
                count++;
            }
            if(temp==num){
                System.out.println("No");
            }else{
                System.out.println(num+" "+temp/num);
            }
            count=1;

        }
    }
}
