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

    // (str.lastIndexOf(" ")==-1)?str:str.substring(str.lastIndexOf(" ")+1) +" "+ReverseSentence(str.substring(0,str.lastIndexOf(" ")));

    /*
    * 翻转单词顺序列
    * */


    public static String ReverseSentence(String str) {
        if(str==null)
            return null;
        char[] data =str.toCharArray();
        if(data.length==0)
            return "";
        int leftMin=0,rightMax=data.length-1;

        while(leftMin<=data.length-1&&data[leftMin]==' '){
            leftMin++;
        }
        while(rightMax>=0&&data[rightMax]==' '){
            rightMax--;
        }

        reverseArray(data,leftMin,rightMax);

        int left=leftMin,right=leftMin;
        while(right<=rightMax){
            if(data[right]==' '||right==rightMax){
                if(right==rightMax)
                    reverseArray(data,left,right);
                else
                    reverseArray(data,left,right-1);
                left=right+1;
                right++;
            }else if(data[left]==' '){
                left++;
            }else{
                right++;
            }
        }
        return new String(data);
    }

    public static  String ReverseSentence2(String str) {
        if(str==null)
            return null;
        char[] data =str.toCharArray();
        if(data.length==0)
            return "";
        int leftMin=0,rightMax=data.length-1;

        reverseArray(data,leftMin,rightMax);

        int left=0,right=0;
        while(right<data.length){
            if(data[right]==' '||right==data.length-1){
                if(right==data.length-1&&data[right]!=' ')
                    reverseArray(data,left,right);
                else
                    reverseArray(data,left,right-1);
                left=right+1;
                right++;
            }else if(data[left]==' '){
                left++;
            }else{
                right++;
            }
        }

        return new String(data);
    }

    public static void main(String[] args) {
        LeftRotateString("adcdeXYZ",9);
        ReverseSentence(" ");
        ReverseSentence2(" ");
    }
}
