package com.wenjiehe.NowCoder;

import java.util.HashMap;
import java.util.Scanner;

public class Huawei01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input=in.nextLine();
        String output="";
        int[] ch=new int[128];
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<input.length();i++)
        {
            int c=input.charAt(i);
            ch[c]++;
        }
        //输出
        while (true)
        {
            boolean empty=false;
            for(int i=0;i<128;i++)
            {
                if(ch[i]!=0)
                {
                    output+=(char)i;
                    ch[i]--;
                    empty=true;
                }
            }
            if(!empty)
            {
                break;
            }
        }
        System.out.println(output);

    }

}
