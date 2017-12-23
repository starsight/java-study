package com.wenjiehe.JZOffer;

/**
 * Created by Administrator on 2017/12/23.
 */
public class JZ42 {
    public static String LeftRotateString(String str,int n) {
        char[] character = str.toCharArray();
        if(character.length==0)
            return "";
        if(n>=character.length)
            n=n%character.length;

        reverseArray(character,0,n-1);
        reverseArray(character,n,character.length-1);
        reverseArray(character,0,character.length-1);

        return new String(character);
    }
    public static void reverseArray(char[] array,int start,int end){
        char temp ='0';
        while(start<end){
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        LeftRotateString("adcdeXYZ",9);
    }
}
