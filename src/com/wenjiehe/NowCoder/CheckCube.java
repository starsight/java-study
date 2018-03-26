package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class CheckCube {
    /**未测试
     * */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] x =new int[4];
        int[] y =new int[4];

        while (count!=0) {
            count--;

            for(int i=0;i<4;i++){
                x[i] = in.nextInt();
            }
            for(int i=0;i<4;i++){
                y[i] = in.nextInt();
            }

            System.out.println(check(x,y));
        }
    }

    public static boolean check(int[]x,int[]y){
        int x1 = x[1]-x[0];
        int x2 = x[3]-x[2];

        int y1 = y[1]-y[0];
        int y2 = y[3]-y[2];

        if(x1*x2+y1*y2==0){
            return x1*y2==x2*y1;
        }else{
            return x1*x2+y1*y2==0;
        }
    }
}
