package com.wenjiehe.QiuZhao.Netease;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/11.
 */
public class Netease0811_01 {
    //0% 修改后100%
    public static void main(String[] args) {
        solution();
    }
    public static void solution(){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
//        String s1 = sc.nextLine();
//        String[] ss1 = s1.split(" ");
//        int n = Integer.valueOf(ss1[0]);
//        int k = Integer.valueOf(ss1[1]);
//        Integer[] arr = new Integer[n];
//        s1 = sc.nextLine();
//        ss1 = s1.split(" ");
//        for (int i = 0; i < n; i++) {
//            arr[i] = Integer.valueOf(ss1[i]);
//        }

        int count =k;
        int[] res;
        String[] str = new String[k];
        for (int i = 0; i < k; i++) {
            res = maxmin(arr);
            if(res[0]==res[1]){
                count =i;
                break;
            }
            arr[res[0]]--;
            arr[res[1]]++;
            res[0]++;
            res[1]++;
            str[i] = res[0]+" "+res[1];
        }

        res= maxmin(arr);
        //System.out.println(res[0]-res[1]+" "+count);//写错了
        System.out.println(arr[res[0]]-arr[res[1]]+" "+count);//正确

        for (int i = 0; i < count; i++) {
            System.out.println(str[i]);
        }

    }

    public static int[] maxmin(Integer[] arr){
        int[] res = new int[2];
        int max =Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(max<arr[i]){
                max = arr[i];
                res[0] =i;
            }
            if(min>arr[i]){
                min = arr[i];
                res[1] =i;
            }
        }
        return res;
    }


}
