package com.wenjiehe.leetcode;

public class P123 {
    // [1,2,4,2,5,7,2,4,9,0] error， 思路错误
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }

        int s=0,e=0;
        int[] max = new int[2];

        for(int i=1;i<prices.length;i++){

            if(prices[i]-prices[i-1]>0){
                e=i;
                if(i==prices.length-1){
                    int gap =prices[e]-prices[s];
                    if(max[0]<gap){
                        max[0] =gap;
                        sort(max);
                    }
                    s = i;
                    e = i;
                }
            }else{
                int gap =prices[e]-prices[s];
                if(max[0]<gap){
                    max[0] =gap;

                    sort(max);
                }
                s = i;
                e = i;
            }
        }
        return max[0]+max[1];
    }

    public static void sort(int[] max){
        if(max[1]<max[0]){
            int temp =max[0];
            max[0] = max[1];
            max[1] = temp;
        }
    }

    public static  int maxProfit2(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] d = buildMaxProfitFromStart(prices);
        int[] f = buildMaxProfitFromEnd(prices);
        int maxProfit = d[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            maxProfit = Math.max(maxProfit, d[i] + f[i + 1]);
        }
        return maxProfit;

    }

    private static int[] buildMaxProfitFromStart(int[] arr) {
        int[] d = new int[arr.length];
        int local = 0;
        int global = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            local = Math.max(local + arr[i + 1] - arr[i], 0);
            global = Math.max(global, local);
            d[i] = global;
        }
        return d;
    }

    private static  int[] buildMaxProfitFromEnd(int[] arr) {
        int[] f = new int[arr.length];
        int global = 0;
        int local = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            local = Math.max(local + arr[i + 1] - arr[i], 0);
            global = Math.max(local, global);
            f[i] = global;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[]{1,5,2,7,2,9}));
    }
}
