package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class CodeM_A06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String ab = sc.nextLine();
        String[] cc= ab.split(" ");
        int a = Integer.valueOf(cc[0]);
        int b = Integer.valueOf(cc[1]);
        String s = sc.nextLine();

        System.out.println(solution(a,b,s));

    }

    public static int solution(int a, int b,String s){
        while(a>b){
            a = a>>1;
        }

        char[] ss =s.toCharArray();
        int[] arr = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            arr[i] = ss[i]-'0';
        }
        //a =10*a;
        int mod = a;
        int c = a/b;
        int index =0;
        int len = arr.length;
        int count = 0;
        int actual =0;

        while(mod!=0){
            a =10*mod;
            mod =a%b;
            c = a/b;

            if(index == len){
                return actual;
            }
            if(actual>1000000)
                return -1;

            count++;
            if(arr[index] == c){
                index++;
                if(actual==0) {
                    actual = count;
                }
            }else{
                index=0;
                actual=0;
            }

        }

        int jj=0;

        for (jj = index; jj < arr.length; jj++) {
            if(arr[jj]!=0){
                return -1;
            }
        }

        if(jj==arr.length) {
            return actual;
        }

        return -1;
    }
}
