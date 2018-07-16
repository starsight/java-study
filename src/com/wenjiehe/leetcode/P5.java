package com.wenjiehe.leetcode;

public class P5 {
    // 通过，效率偏低
    public static void main(String[] args) {
        System.out.println("".length());
        System.out.println(longestPalindrome("bananas"));
    }

    public static String longestPalindrome(String s) {
        if(s==null||s.equals("")||s.length()==1) {
            return s;
        }
        char[] str = s.toCharArray();
        int[] dp = new int[str.length];

        int maxindex=0;
        int maxLen =1;
        dp[0] = -1;
        dp[1] = str[0]==str[1]?0:-1;
        if(dp[1]==0){
            maxLen=2;
        }
        for (int i = 2; i < str.length; i++) {
            if(dp[i-1]!=-1){
                /*if(dp[i-1]>0&&str[dp[i-1]-1]==str[i]){
                    dp[i] = dp[i-1]-1;
                }else if(check(str,dp[i-1],i)){
                    dp[i] = dp[i-1];
                }else{
                    dp[i]=-1;
                }*/
                for(int j=0;j<i;j++){
                    if(check(str,j,i)){
                        dp[i] =j;
                        break;
                    }
                    if(i-1==j){
                        dp[i] =-1;
                    }
                }

            }else{
                if(str[i-2]==str[i]){
                    dp[i] = i-2;
                }else if(str[i-1]==str[i]){
                    dp[i] = i-1;
                }else{
                    dp[i] = -1;
                }
            }
            if(dp[i]!=-1){
                if(maxLen<i-dp[i]+1){
                    maxindex = dp[i];
                    maxLen = i-dp[i]+1;
                }
            }

        }

        return s.substring(maxindex,maxindex+maxLen);
    }

    public static boolean check(char[] str,int s,int e){
        while(s<=e){
            if(str[s]==str[e]){
                s++;
                e--;
            }else{
                return false;
            }
        }
        return true;

    }


}
