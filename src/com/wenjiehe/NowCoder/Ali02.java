package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class Ali02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        if(q%(2*p)==0) {
            System.out.println(q/p);
        }else if(m%p==0){
            System.out.println(0);
        }
    }

    /*public static int solution(int m,int n,int p, int q){

    }

    public static int[] goTop(int m,int n,int p, int q,int x,int y){

    }*/
}
