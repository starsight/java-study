package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class JD01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String str = sc.nextLine();
        String[] input = str.split(" ") ;

        int count=0;
        for(int i =0;i<n;i++){
            String[] two = input[i].split(":");
            int first = Integer.valueOf(two[0]);
            int second = Integer.valueOf(two[1]);
            int first0 = first/10;
            int first1 = first%10;
            int second0 = second/10;
            int second1 = second%10;

            if(first0==second0&&first1==second1){
                count++;
            }else if(first0==first1&&second0==second1){
                count++;
            }else if(first0==second1&&first1==second0){
                count++;
            }
        }

        System.out.println(count);
    }

}
