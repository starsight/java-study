package com.wenjiehe.NowCoder;

import java.util.Arrays;
import java.util.Scanner;

public class Tencent03 {
    /*
     * ac
     * */
    public static void main(String[] args) {
        Tencent03 tencent03 =new Tencent03();
        tencent03.solve();
    }

    public void solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int d =0;

        for(int i=arr.length-1;i>0;){
            d+= arr[i]-arr[i-1];
            i-=2;
        }

        if(n%2==1){
            //奇数
            d+=arr[0];
        }

        System.out.println(d);
    }

}
