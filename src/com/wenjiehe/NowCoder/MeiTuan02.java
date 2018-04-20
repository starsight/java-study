package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class MeiTuan02 {
    /**ac
     * */
    public static void  main(String []args) {

        //System.out.println(solutionBefore(3));

        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < n ; i++) {
            String input =sc.nextLine();
            System.out.println(solution(input));
        }
       
        
    }
    public static long solution(String input){

        int len = input.length();
        int n = Integer.valueOf(input);

        long sum =0;
        for (int i = 1; i <=len-1; i++) {
            sum+=solutionBefore(i);
        }

        long min = (long)Math.pow(10,len-1);
        sum+=len*(n-min+1);

        return sum;

    }

    public static long solutionBefore(int bit){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <bit ; i++) {
            sb.append("9");
        }

        long min = (long)Math.pow(10,bit-1);

        long max = Long.valueOf(sb.toString());

        return bit*(max-min+1);
    }

}
