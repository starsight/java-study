package com.wenjiehe.NowCoder;

import java.util.HashMap;

public class OutputMinNum {
    public static void main(String[] args) {
        String str ="001122222333444555666777888999";
        System.out.println(outputMinNum(str));

        char[] ch = str.toCharArray();
        System.out.println(lestNum(ch));
    }

    public static int outputMinNum(String input){
        char[] c = input.toCharArray();
        int[] count = new int[10];
        for(int i=0;i<c.length;i++){
            count[c[i]-'0']++;
        }

        int min=Integer.MAX_VALUE,min_index=0;
        int secondMin =-1,secondMinIndex =0;

        for(int i=0;i<10;i++){
            if(count[i]<min){
                min = count[i];
                min_index =i;
            }else if(count[i]==min&&secondMin==-1){
                secondMin =count[i];
                secondMinIndex =i;
            }
        }
        StringBuffer sb = new StringBuffer();

        if(min_index!=0){
            sb.append(min_index);
            while (min!=0){
                sb.append(min_index);
                min--;
            }
        }else{
            if(secondMin==min){
                sb.append(secondMinIndex);
                while (secondMin!=0){
                    sb.append(secondMinIndex);
                    secondMin--;
                }
            }else {
                sb.append(1);
                while (count[0] != 0) {
                    sb.append(0);
                    count[0]--;
                }
                sb.append(0);
            }
        }
        return Integer.valueOf(sb.toString());
    }


    /**通过70%
     * */
    public static  int[] generateNumArray(char[] chArray){
        int[] num = new int[10];
        for(int i = 0 ; i < chArray.length ; i++){
            int theNum = (int)(chArray[i] - '0');
            num[theNum]++;
        }
        return  num;
    }
    public static int lestNum(char[] chArray){
        int[] num = generateNumArray(chArray);
        num[0]++;
        int index = 0;
        int min = num[0];
        for(int i = 1; i < 10 ; i++){
            if(min > num[i]){
                min = num[i];
                index = i;
            }
        }
        if(index == 0) {
            return (int) Math.pow(10, min);
        }else{
            int theNum = index;
            for(int i = 0 ; i < min ; i++){
                theNum = theNum*10 +index;
            }
            return  theNum;
        }
    }
}
