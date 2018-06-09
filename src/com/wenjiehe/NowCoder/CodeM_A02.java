package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class CodeM_A02 {


        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr=new int[n];

            for(int i = 0; i < n; i++){
                int temp1=sc.nextInt();
                arr[i]=temp1;
            }
            int[] arr2=new int[n];
            for(int j = 0; j < n; j++){
                int temp2=sc.nextInt();
                arr2[j]=temp2;
            }


            long res=0;
            long sum=0;

            for(int k=n-1;k>=0;k--){
                if(arr2[k]==arr[k]){
                    continue ;
                }else if(arr2[k]<arr[k]&&k>0){
                    long num=arr[k]-arr2[k];
                    arr[k-1]+=num;
                    res+=num;
                }else{
                    long num2=arr2[k]-arr[k];
                    sum+=num2*k;
                }
            }

            System.out.print(res+sum);

        }
    }

