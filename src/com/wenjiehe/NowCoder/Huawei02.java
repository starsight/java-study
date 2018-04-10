package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class Huawei02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lineNum=in.nextInt();
        int[] arr=new int[lineNum];
        for(int i=0;i<lineNum;i++)
        {
            arr[i]=in.nextInt();
        }
        if(arr.length==0)
        {
            System.out.println(0);
        }
        int jump=0;
        int cur=0;
        int next=0;
        for(int i=0;i<arr.length;i++)
        {
            if(cur<i)
            {
                jump++;
                cur=next;
            }
            next=Math.max(next,i+arr[i]);
        }
        System.out.println(jump);
    }
}
