package com.wenjiehe.NowCoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/14.
 */
public class Wood0314 {

    /***
     * case通过50%
     * @param args
     */
    public static void  main(String []args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int P,Q,K=0;
        for(int i =0;i<M;i++){
            P = in.nextInt();
            Q = in.nextInt();
            K = in.nextInt();

            if(hashMap.containsKey(P)){
                if(hashMap.get(P)>K){
                    hashMap.put(P,K);
                }
            }else
                hashMap.put(P,K);

            if(hashMap.containsKey(Q)){
                if(hashMap.get(Q)>K){
                    hashMap.put(Q,K);
                }
            }else
                hashMap.put(Q,K);
        }

        int max = -1;
        for(int i =1;i<=N;i++){
            P =hashMap.get(i);
            if(P==0)
                continue;
            if(max<P)
                max=P;
        }
        System.out.println(max);
    }


}
