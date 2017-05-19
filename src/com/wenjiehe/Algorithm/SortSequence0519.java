package com.wenjiehe.Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/19.
 */
public class SortSequence0519 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        int fir =0;

        if(arr[0]-arr[1]<0)
            fir=1;
        else if(arr[0]==arr[1]){
            fir=0;
        }else{
            fir=-1;
        }

        int count=1;
        for(int i=2;i<n;i++){

            if(needDivide(arr[i-1],arr[i],fir)){
                count++;
                if(i+2<=n){
                    if(arr[i]>arr[i+1]){
                        fir =-1;
                    }else if(arr[i]==arr[i+1]){
                        fir=0;
                    }else
                        fir=1;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean needDivide(int a ,int b,int  value){
        int  bigger =0;
        if(a>b){// smaller
            bigger = -1;
        }else if(a==b){
            return false;
        } else {
            bigger = 1;
        }
        if(bigger==value)
            return false;
        else
            return true;

    }

}
