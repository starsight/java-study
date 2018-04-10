package com.wenjiehe.NowCoder;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/4/10.
 */
public class Xiaomi03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            String n = sc.nextLine();
            ArrayList<String> list = new ArrayList<>();
            solution(n,0,list);

            StringBuffer sb = new StringBuffer();
            int i=0;
            for (String str:list) {
                i++;
                if(i==list.size()){
                    sb.append(str);
                }else{
                    sb.append(str).append(" ");
                }
            }
            System.out.println(sb.toString());
        }

    }

    static char convert(String c){
        int temp = Integer.valueOf(c)-1;
        return (char)(temp+'a');
    }

    static void solution(String n,int index, ArrayList<String> list) {
        if(index>=n.length()) {
            list.add("");
            return;
        }

        if(index==n.length()-1){
            list.add(convert(n.charAt(index)+"")+"");
            return;
        }

        ArrayList<String> list1 = new ArrayList<>();
        solution(n,index+1,list1);
        char n1 = convert(n.charAt(index)+"");

        for (String str:list1) {
            list.add(n1+str);
        }

        ArrayList<String> list2 = new ArrayList<>();
        solution(n,index+2,list2);
        int n2 = Integer.valueOf(n.substring(index,index+2));
        char n3 =  convert(n2+"");
        for (String str:list2) {
            list.add(n3+str);
        }
    }

}
