package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class Ali01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int len = in.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len ; i++) {
            arr[i] = in.nextInt();
        }

        int max = solution(arr,0);
        System.out.println(max);
    }

    public static int solution(int[] arr,int n){
        if(n==arr.length-1) {
            return arr[n];
        }else if(n>=arr.length){
            return 0;
        }

        int s1 = solution(arr,n+1);

        int s2 = arr[n]+solution(arr,n+2);

        return s1>s2?s1:s2;
    }
}
