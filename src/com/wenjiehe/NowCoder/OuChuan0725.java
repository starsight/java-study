package com.wenjiehe.NowCoder;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/25.
 */
public class OuChuan0725 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();

        for(int i=str.length()-1;i>=2;i--){
            String temp =str.substring(0,i);
            if(isOuChuan(temp)){
                System.out.println(temp.length());
                return;
            }
        }

    }
    private static boolean isOuChuan(String str){
        String str1 = str.substring(0,str.length()/2);
        String str2= str.substring(str.length()/2);

        if(str1.equals(str2))
            return true;
        return false;
    }
}
