package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/6.
 */
public class P121 {
    public static void main(String args[]) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;

        int temp = 0, maxprice = 0;
        int max=-1;
        int min =65535;

        int maxx[] =new int[length];

        if(length<=1)
            return 0;

        maxx[length-1]=prices[length-1];

        for (int i = length-2; i >=0; i--){
            if(prices[i]>maxx[i+1])
                maxx[i]=prices[i];
            else
                maxx[i]=maxx[i+1];
        }

        for (int i = 0; i < length; i++) {//卖出

            if(prices[i]<min)
                min=prices[i];

            if(maxx[i]-min>maxprice)
                maxprice = maxx[i]-min;
        }

        return maxprice;
    }
}
