package com.wenjiehe.QiuZhao.Tencent;

import java.util.ArrayList;
import java.util.Scanner;

public class TX03 {
    //50%
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        String P = in.nextLine();

        int res = 0;
        long sum = 0;
        int resTemp = 0;
        int resTemp2 = 0;

        for (int i = 0; i < S.length(); i++) {
            res = S.indexOf(P, i);
            if (res == -1) {
                break;
            }
            resTemp = res;
            resTemp2 = res;

            while (resTemp2 - resTemp <= P.length()) {
                resTemp = resTemp2;
                resTemp2 = S.indexOf(P, resTemp + 1);
                if(resTemp2==-1)
                    break;
            }

            int sq = resTemp - res + P.length();
            sum += sq * sq;
            i = resTemp;
        }
        System.out.println(sum);
        solution(S,P);
    }

    //据说别人AC的代码
    public static void solution(String S,String P){
        //Scanner sc = new Scanner(System.in);
        //String S = sc.nextLine();
        //String P = sc.nextLine();
        String str = S;
        ArrayList<Integer> start_list = new ArrayList<Integer>();
        int k=0;
        while(str.indexOf(P)>=0) {
            //System.out.println(str);
            start_list.add(str.indexOf(P)+k);
            k=str.indexOf(P)+k+1;	//下次查找要跳过的长度
            //System.out.println(k);
            str=S.substring(k);

        }
        //合并操作
        long energySum = 0;
        int combine_start = 0;	//进行组合的起始索引
        for(int i=0;i<start_list.size();i++) {
            if(i>0&&start_list.get(i)-start_list.get(i-1)>P.length()) {
                //不发生合并，则重新开始组合操作
                energySum+=(start_list.get(i-1)-combine_start+P.length())*(start_list.get(i-1)-combine_start+P.length());	//上一个字符串的起始位置-combine_start+P.length()
                //System.out.println(energySum);
                combine_start = start_list.get(i);
            }else if(i>0) {
                //发生合并，什么也不做
            }else {	//第一个匹配字符串
                //不进行操作
                combine_start = start_list.get(i);
            }
        }
        //特殊处理最后一个匹配字符串
        energySum+=(start_list.get(start_list.size()-1)-combine_start+P.length())*(start_list.get(start_list.size()-1)-combine_start+P.length());
        System.out.println(energySum);

    }
}
