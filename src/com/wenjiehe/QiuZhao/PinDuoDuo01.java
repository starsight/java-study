package com.wenjiehe.QiuZhao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PinDuoDuo01 {

    static class node
    {
        int x,y,h;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int c = in.nextInt();

            int maxn = 105;
            int a[][] = new int[maxn][maxn];
            int dp[][] = new int[maxn][maxn];
            node[] A = new node[maxn*maxn];

            int num = 0;
            for(int i = 1 ; i <=n ; i++)
            {
                for(int j = 1 ; j <= c ; j++)
                {
                    a[i][j]= in.nextInt();
                    A[num] = new node();
                    A[num].x=i;
                    A[num].y=j;
                    A[num++].h = a[i][j];
                    dp[i][j] = 1 ;
                }
            }

            Arrays.sort(A, new Comparator<node>() {
                @Override
                public int compare(node a, node b) {
                    if(a==null||b==null)
                        return 0;

                    if(a.h>b.h){
                        return 1;
                    }
                    else if(a.h<b.h){
                        return -1;
                    }
                    return 0;
                }
            });
            for(int k = 0 ; k < num ; k++)
            {
                int i = A[k].x;
                int j = A[k].y;
                if(a[i][j]>a[i-1][j]) dp[i][j] = Math.max(dp[i][j],dp[i-1][j]+1);
                if(a[i][j]>a[i][j-1]) dp[i][j] = Math.max(dp[i][j],dp[i][j-1]+1);
                if(a[i][j]>a[i+1][j]) dp[i][j] = Math.max(dp[i][j],dp[i+1][j]+1);
                if(a[i][j]>a[i][j+1]) dp[i][j] = Math.max(dp[i][j],dp[i][j+1]+1);
            }
            int ans = 0 ;
            for(int i = 1 ; i <= n ; i++)
            {
                for(int j = 1 ; j <= c ; j++)
                {
                    ans = Math.max(ans,dp[i][j]);
                }
            }

            System.out.println(ans);
        }

    }
}
