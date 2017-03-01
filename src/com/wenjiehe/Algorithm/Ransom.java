package com.wenjiehe.Algorithm;

import java.util.HashMap;

/**
 * Created by wenjie on 17/03/01.
 */
public class Ransom {

    public static boolean canConstruct(String ransomNote, String magazine) {
        //magazine.contains(ransomNote);
        //System.out.println(magazine.indexOf("1"));
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char num = magazine.charAt(i);
            System.out.println(num);
            Integer temp =map.get(num);
            if(temp==null){
                map.put(num,1);
            }
            else{
                map.put(num,++temp);
            }
        }
        //System.out.println(map);
        for(int i = 0; i < ransomNote.length(); i++){
            char num = ransomNote.charAt(i);
            Integer c = map.get(num);
            if(c!=null&&c>0){
                System.out.println(map);
                map.put(num,c-1);
            }
            else
                return false;
        }
/*
        int[] charcnt =new int[26];
        //统计magazine中每个字符出现次数
        for(int i=0;i<magazine.length();i++)
            charcnt[magazine.charAt(i)-'a']++;
        //统计ransomNote中每个字符出现次数
        for(int i=0;i<ransomNote.length();i++)
            charcnt[ransomNote.charAt(i)-'a']--;
        //检查是否ransomNote中的数量是否都小于magazine中的！
        for(int i=0;i<ransomNote.length();i++)
            if(charcnt[ransomNote.charAt(i)-'a'] < 0)
                return false;
        return true;
        */

        return true;
    }

    public static void main(String[] args){
        System.out.println(canConstruct("333","3231"));



    }
}
