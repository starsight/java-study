package com.wenjiehe.Algorithm;

public class DiffColor {
    public static long getDiffColor(int N,int M){
        long maxType =M;
        for(int i=1;i<N;i++){
            maxType*=(M-1);
        }

        long f_2=0;
        for(int i=3;i<=N;i++){
            f_2 = (long)(M*(Math.pow(M-1,i-2))-f_2);
        }
        return maxType-f_2;
    }

    public static long cal2(int N,int M)
    {
        return (long)(Math.pow(M-1,N)+Math.pow(-1,N)*(M-1));
    }

    public static long cal(int N,int M)
    {
        if(N==2){
            return M*(M-1);
        }
        return (long)(M*Math.pow(M-1,N-1)-cal(N-1,M));
    }

    public static void main(String[] args) {
        System.out.println(getDiffColor(14,7));//有问题
        System.out.println(cal2(14,7));
        System.out.println(cal(14,7));
    }
}
