package com.wenjiehe.NowCoder;

import java.util.HashMap;
import java.util.Scanner;

public class WAP02 {
    // 70%
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        int len[] = new int[n];
        int mod[] = new int[n];
        HashMap<Double, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            len[i] = getNumLenght(a[i]);
            mod[i] = a[i] % 7;
            hashMap.put((double) a[i], a[i] % 7);
        }
        long ans = 0;
        //write your code

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    continue;
                }
                if (mod[i] != 0) {
                    int x = mod[i];
                    double num = Math.pow(10, len[j]) * x + a[j];
                    int ret;
                    if(hashMap.containsKey(num)){
                        ret = hashMap.get(num);
                    }else{
                        ret = is7(num);
                        hashMap.put(num,ret);
                    }
                    if(ret==0){
                        ans++;
                    }
                } else {
                    if (mod[j] == 0) {
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static int is7(double num) {
        return (int) (num % 7);
    }

    private static int getNumLenght(long num) {
        num = num > 0 ? num : -num;
        return String.valueOf(num).length();
    }
}
