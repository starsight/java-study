package com.wenjiehe.NowCoder;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/25.
 */
public class CaiSeCiZhuan0725 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        char current ='X';
        char lastcurrent ='X';
        boolean lastEqual =false;
        int count =0;
        for(int i=0;i<str.length();i++){
            current = str.charAt(i);
            if(current==lastcurrent){
                if(lastEqual){
                    lastEqual =false;
                }else{
                    count++;
                    lastEqual =true;
                }
            }else {
                lastEqual =false;
            }

            lastcurrent =current;
        }

        System.out.println(count);
    }
}
