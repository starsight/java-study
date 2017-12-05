package com.wenjiehe.JZOffer;

/**
 * Created by Administrator on 2017/11/25.
 */
public class JZ10 {

    public static void main(String[] args) {
        NumberOf0(-10);
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
                max--;
                if(Math.abs(num&flag0)<=max)
                    break;
            }
            flag1 = flag1<<1;
            movecount++;
        }

        return count;
    }
}
