package com.wenjiehe.Algorithm;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/6/16.
 */
public class ChangeNums {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        HashMap<String,String> hashMap =new HashMap<>();
        int[] array = new int[num];
        int ii = 0;
        while (ii<num) {//注意while处理多个case
            int a = in.nextInt();
            array[ii] = a;
            ii++;
        }

        int all=0;
        HashMap<Integer,Boolean> hash = new HashMap<>();
        for (int i=0;i<num-1;i++){
            for(int j=i+1;j<num;j++){
                int sum =0;
                String str = array[i]+"-"+array[j];
                Boolean boo = hash.get(array[i]);
                if(hashMap.get(str)==null){
                    hashMap.put(str,str);
                    all++;
                }else if(array[i]!=array[j]){
                    all++;
                }

            }
        }
        System.out.println(all);
    }

}
