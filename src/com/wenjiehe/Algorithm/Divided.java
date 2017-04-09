package com.wenjiehe.Algorithm;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

/**
 * Created by wenjie on 2017/03/23.
 */
public class Divided {

    public static void main(String[] args) {
        int a = 0,b=0;
        int c =0;
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {//注意while处理多个case
            a = in.nextInt();
            b = in.nextInt();
            c =in.nextInt();
        }
        int count=0;
        if(a==0){
            a=1;
            count++;
        }

        if(a>0) {
            count += div(a, b, c);
            System.out.println(count);
            return;
        }else if(a<0&&b>0){
            count++;//=0的
            count+=div(1,Math.abs(b),c);
            count+=div(1,Math.abs(a),c);
            System.out.println(count);
            return;
        }else if(b<=0){
            if(b==0){
                b=-1;
            }
            count++;

            count+=div(Math.abs(b),Math.abs(a),c);
            System.out.println(count);
            return;
        }

    }

    public static int div(int a,int b,int c){
        if(c>a){
            int s =c;int count =0;
            if(s>b){
                count++;
            }
            while(s<=b){
                s = (++count)*c;
            }
            return (count-1);
        }
        else{
            int mod =a/c;
            int s =c;
            int count =0;
            if(mod*c==a){
                count++;
            }
            if(s>b){
                count++;
            }
            while(s<=b){
                s = (++mod)*c;
                count++;
            }
            return (count-1);
        }
    }
}
