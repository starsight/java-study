package com.wenjiehe.JZOffer;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/22.
 */
public class JZ41 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int start =1,end=2;
        int max = sum>>1;
        int tempSum = start+end;
        while(start<=max&&start<end&&end<=max+1){
            if(tempSum==sum){
                ArrayList<Integer> oneResult = new ArrayList<>();
                for(int i=start;i<=end;i++){
                    oneResult.add(i);
                }
                result.add(oneResult);
                end++;
                tempSum+=end;
            }
            else if(tempSum<sum){
                end++;
                tempSum+=end;
            }else{
                tempSum-=start;
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindContinuousSequence(100);
    }
}
