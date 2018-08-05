package com.wenjiehe.NowCoder;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/5.
 */
public class PDD02 {
    //ac
    public static void main(String[] args) {
        solution();
    }

    public static void solution(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] chars = str.toCharArray();
        int count =0;
        for (int i = 0; i < chars.length-1; i++) {
            int j0 = validNum(chars,0,i);
            int j1= validNum(chars,i+1,chars.length-1);
            count+=j0*j1;
        }
        System.out.println(count);
    }

    public static int validNum(char[] chars,int l,int r){
        if(chars[l]=='0'){
            if(chars[r]=='0'&&l!=r){
                return 0;
            }else{
                return 1;
            }
        }else{
            if(chars[r]=='0'){
                return 1;
            }else{
                return r-l+1;
            }
        }
    }
}
