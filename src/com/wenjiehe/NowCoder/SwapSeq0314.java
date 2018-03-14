package com.wenjiehe.NowCoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/14.
 */
public class SwapSeq0314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] seq = new int[n];

        for(int i = 0; i < n; i++){
            seq[i] = sc.nextInt();
        }

        int count =0;

        if(seq[0]==1){
            swap(seq,0,1);
            count++;
        }

        for(int i=1;i<n-1;i++){
            if(seq[i]==i+1){
                if(seq[i+1]==i+2){//下一个序列也相等，优先交换这两个
                    swap(seq,i,i+1);
                    count+=1;
                }else{
                    swap(seq,i-1,i);
                    count++;
                }
            }
        }

        if(seq[n-1]==n){
            count++;
        }
        System.out.println(count);
    }

    public static void swap(int[] seq,int i,int j){
        int temp =seq[i];
        seq[i] = seq[j];
        seq[j] = temp;
    }


}
