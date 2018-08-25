package com.wenjiehe.QiuZhao.ByteDance;

import java.util.Arrays;
import java.util.Scanner;

public class bytedance02_04 {
    //50%
    public static void main(String[] args) {
        //System.out.println(Integer.MAX_VALUE);
        int len = LongestSubString1(new int[]{10,10,10});
        //System.out.println(lengthOfLIS(new int[]{10,10,10}));
        System.out.println(len);
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int t =sc.nextInt();
        int[] res = new int[n*t];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }

        for (int i = n; i < res.length; i++) {
            res[i] = res[i%n];
        }
        System.out.println(LongestSubString1(res));
    }

    public static void generateLIS(int arr[],int dp[])
    {
        int k=0;
        int index=0;
        int len=0;
        for(int i=0;i<arr.length;i++)
        {
            if(dp[i]>len)
            {
                len=dp[i];
                index=i;
                //找到递增子序列中的最后一个元素[10,22,33,41,60,80]中的80，
            }
        }
        int subArr[]=new int[len];
        subArr[k++]=arr[index];
        for(int j=index-1;j>=0;j--)
        {
            if((dp[index]==dp[j]+1)&&(arr[index]>arr[j]))
            {
                //从后向前,将属于递增子序列的元素加入到subArr中。
                subArr[k++]=arr[j];
                index=j;
            }
        }
        for(int j=subArr.length-1;j>=0;j--)
        {
            System.out.print(subArr[j]+" ");
        }

    }

    public static int LongestSubString1(int arr[])
    {
        if(arr==null||arr.length==0)
            return 0;
        int l=0,r=0,right=0;
        int len=0;
        int ends[]=new int[arr.length];
        int dp[]=new int[arr.length];
        dp[0]=1;
        ends[0]=arr[0];
        //ends[0]开始时存放arr[0],
        for(int i=1;i<arr.length;i++)
        {
            l=0;
            r=right;
            //如果arr[i]比 ends 数组中的所有元素都大则放到 ends 后面，
            //否则用arr[i]代替ends数组中第一个比arr[i]大的数，保持 ends 递增。
            while(l<=r)
            {
                int mid=(l+r)/2;
                if(arr[i]>=ends[mid])
                {
                    l=mid+1;
                }
                else {
                    r=mid-1;
                }
            }
            right=Math.max(l,right);
            ends[l]=arr[i];
            dp[i]=l+1;
            //arr[i]在数组 ends 中的位置，就是以arr[i]结尾的最长单调子序列的长度。
        }
        len=right+1;
        //generateLIS(arr,dp);
        return len;
    }
}
