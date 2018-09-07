package com.wenjiehe.QiuZhao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/9/7.
 */
public class XunFei {
    //AC AC
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    public static void solution1() {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        int[] res = new int[T];
        int num,target;
        int[] arr = null;
        for(int i=0;i<T;i++){
            num = sc.nextInt();
            target = sc.nextInt();
            arr = new int[num];
            for(int j = 0;j<num;j++){
                arr[j] = sc.nextInt();
            }
            res[i] = solution11(target,arr);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(res[i]);
        }
    }

    public static int solution11(int t, int[] arr) {
        int raw = 0;
        for (int i = 0; i < arr.length; i++) {
            raw += arr[i];
        }
        int targ = t * arr.length;
        if (targ <= raw) {
            return 0;
        } else {
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                raw += 100 - arr[i];
                if (raw >= targ) {
                    return i + 1;
                }
            }
        }
        return arr.length;
    }

    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        //Integer[] arr = new Integer[num];
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sc.nextInt());
        }
        int len = num;
        int oldLen = num;
        int count = 0;
        do {
            count++;
            oldLen = len;
            list2.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) <= list.get(i)) {
                    list2.add(list.get(i));
                }
            }
            list = list2;
            list2 = new ArrayList<>();
            //arr = (Integer [])(list.toArray());
            len = list.size();
        } while (len < oldLen);
        System.out.println(count-1);
    }
}
