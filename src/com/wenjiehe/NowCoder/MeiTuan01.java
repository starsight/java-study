package com.wenjiehe.NowCoder;

import java.util.HashMap;
import java.util.Scanner;

public class MeiTuan01 {

    /*
    90%
    * */
    public static void  main(String []args) {

        Scanner sc = new Scanner(System.in);

        while(true){
            String n = sc.nextLine();
            System.out.println(solution(n));
            System.out.println(solution2(n));
        }
    }

    public static long solution2(String n){
        int[] A = new int[4];
        String[] strA = n.split(" ");
        for (int i = 0; i < strA.length; i++) {
            A[i] = Integer.valueOf(strA[i]);
        }
        //A[1]=p,A[x]=(A[x-1]+153)%p        N n m p
        int[] a = new int[A[0]];

        a[0]=A[3];//p
        for (int i = 1; i < a.length; i++) {
            a[i] = (a[i-1]+153)%a[0];
        }

        long sum =0;
        for (int i = 1; i <=A[1] ; i++) {
            for (int j = 1; j <=A[2]; j++) {
                int gcd =maxCommonDivisor(i,j);
                sum+=a[gcd-1];
            }
        }
        return sum;
    }

    public static long solution(String n){
        int[] A = new int[4];
        String[] strA = n.split(" ");
        for (int i = 0; i < strA.length; i++) {
            A[i] = Integer.valueOf(strA[i]);
        }
        //A[1]=p,A[x]=(A[x-1]+153)%p        N n m p
        int[] a = new int[A[0]];

        a[0]=A[3];//p
        for (int i = 1; i < a.length; i++) {
            a[i] = (a[i-1]+153)%a[0];
        }

        long sum =0;
        HashMap<String,Integer> hashMap = new HashMap<>();

        for (int i = 1; i <=A[1] ; i++) {
            for (int j = 1; j <=A[2]; j++) {
                String str = i<j?i+"-"+j:j+"-"+i;
                if(hashMap.containsKey(str)){
                    sum+=a[hashMap.get(str)-1];
                }else {
                    int gcd =maxCommonDivisor(i,j);
                    sum+=a[gcd-1];
                    hashMap.put(str,gcd);
                }

            }
        }


        return sum;
    }

    // 循环法求最大公约数
    public static int maxCommonDivisor(int m, int n) {

        if (m < n) {// 保证m>n,若m<n,则进行数据交换
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {// 在余数不能为0时,进行循环
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;// 返回最大公约数
    }

}
