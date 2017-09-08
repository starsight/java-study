package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/8.
 */
public class P605 {
    public static  boolean  canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==1)
            if(flowerbed[0]==0)
                return n<=1?true:false;
            else
                return n==0?true:false;

        int len =flowerbed.length;

        int count =0;

        for(int i=0;i<flowerbed.length;i++){
            boolean left=true;
            boolean right=true;

            if(flowerbed[i]==0){
                if(i>0){
                    if(flowerbed[i-1]==1)
                        left=false;
                }

                if(i<len-1){
                    if(flowerbed[i+1]==1)
                        right=false;
                }

                if(left&&right){
                    flowerbed[i]=1;
                    count++;
                }

            }

        }

        return count>=n?true:false;
    }

    public static void main(String[] args) {
        canPlaceFlowers(new int[]{0,0,1,0,0},1);
    }
}
