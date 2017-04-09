package com.wenjiehe.Algorithm;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by wenjie on 2017/03/23.
 */
public class Selection {
    public static void main(String[] args) {
        int a =0;
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {//注意while处理多个case
            a = in.nextInt();
            //System.out.println(a);
        }
        String[] str = new String[a];
        //int[][] count = new int[a][255];
        int[] sum = new int[a];
        for(int i =0;i<a;i++){
            str[i] = in.next();
            for(int j=0;j<str[i].length();j++){
                //count[i][str[i].charAt(j)]++;
                sum[i] +=str[i].charAt(j);
            }
            //System.out.println(sum[i]);
        }

        Arrays.sort(sum);
        int count=1;
        for(int i=1;i<a;i++){
            if(sum[i-1]!=sum[i])
                count++;
        }
        System.out.println(count);
    }
}
