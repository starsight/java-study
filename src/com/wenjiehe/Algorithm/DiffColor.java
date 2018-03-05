package com.wenjiehe.Algorithm;

public class DiffColor {
    public static int getDiffColor(int N,int M){
        int maxType =M;
        for(int i=1;i<N;i++){
            maxType*=(M-1);
        }

        int f_2=0;
        for(int i=3;i<=N;i++){
            f_2 = (int)(M*(Math.pow(M-1,i-2))-f_2);
        }
        return maxType-f_2;
    }

    public static int cal2(int N,int M)
    {
        return (int)(Math.pow(M-1,N)+Math.pow(-1,N)*(M-1));
    }

    public static void main(String[] args) {
        System.out.println(getDiffColor(14,3));
        System.out.println(cal2(14,3));
    }
}
