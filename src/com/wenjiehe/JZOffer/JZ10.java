package com.wenjiehe.JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/25.
 */
public class JZ10 {

    public static void main(String[] args) {
        int i = numberOf0(9583156);
        int j =NumberOf0(9583156);
        numberOf1(10);

        int d =1;
        int count=0;
        while(d!=0){
            d=d<<1;
            count++;
        }
        System.out.println(count);

    }

    public static int numberOf1(int n){
        int count =0;
        int i =1;
        while(i!=0){
            if((i&n)==i){
                count++;
            }
            i=i<<1;
        }

        return count;
    }

    /**
     * 二进制0的个数
     * 网易面试题
     * */
    public static int NumberOf0(int num){
        int count =0;

        int flag0 = 0;
        int flag1 = 1;

        int movecount =0;
        int max =0;

        for(;;){
            if((num&flag1)==0){
                count++;
            }else{
                flag0 =~flag1;
                max = 1<<movecount;
                max--;//构造次大值
                if(Math.abs(num&flag0)<=max)//不要忘了绝对值
                    break;
            }
            flag1 = flag1<<1;
            movecount++;
        }

        return count;
    }

    public static int numberOf0(int num){

        int count=0;
        if(num<0){
            int i=1;
            while(i!=0){
                if((i&num)==0){
                    count++;
                }
                i=i<<1;
            }
            return  count;
        }

        while(num!=0){
            int mod = num%2;
            if(mod==0)
                count++;
            num = num/2;
        }
        return count;
    }
}
