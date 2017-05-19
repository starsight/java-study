package com.wenjiehe.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/19.
 */
public class ShenQiShu0519 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int first=0,end=0;
        first = in.nextInt();
        end = in.nextInt();


        int count =0;
        if(first<=10){
            first=11;
        }

        for(int i=first;i<=end;i++){
            if(isShenQiShu(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isShenQiShu(int num){
        String x =num+"";

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<x.length();i++){
            int a = x.charAt(i)-48;
            list.add(a);
        }

        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int fir = list.get(i);
                int sec = list.get(j);
                if(fir!=0&&sec%2!=0) {
                    int zhen = fir * 10 + sec;
                    if (isPrime(zhen))
                        return true;
                }
                if(sec!=0&&fir%2!=0) {
                    int fan = sec * 10 + fir;
                    if (isPrime(fan))
                        return true;
                }
            }
        }

    return false;
    }

    public static boolean isPrime(int n){
        for(int i=2;i<=n/2;i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
