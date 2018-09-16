package com.wenjiehe.QiuZhao.Tencent;

import java.util.Scanner;

public class TX01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        String[] res= new String[t];
        for (int i = 0; i <t ; i++) {
            int obj = in.nextInt();
            res[i] = solution(obj);
        }
        for (int i = 0; i < t; i++) {
            System.out.println(res[i]);
        }
    }
    public static String solution(int obj){
        String s = obj+"";
        int sum =0;
        for (int i = 0; i <s.length() ; i++) {
            sum+=s.charAt(i)-'0';
        }
        if(obj%sum==0){
            return "Yes";
        }else
            return  "No";
    }
}
