package com.wenjiehe.NowCoder;

import java.math.BigDecimal;
import java.util.Scanner;

public class CodeM01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m,n;
        n = in.nextInt();
        m = in.nextInt();

        int[][] buy = new int[10][2];
        int[][] discount = new int[10][2];
        for (int i = 0; i < n; i++){
            buy[i][0] = in.nextInt();
            buy[i][1] = in.nextInt();
        }

        for (int i = 0; i < m; i++){
            discount[i][0] = in.nextInt();
            discount[i][1] = in.nextInt();
        }

        double min = Double.MAX_VALUE;
        double res = 0.0;
        int resNoDis = 0;
        int all = 0;

        for (int i = 0; i < n; i++){
            all += buy[i][0];
            if (buy[i][1] == 1)
                res += buy[i][0];
            else
                resNoDis += buy[i][0];
        }
        double temp = resNoDis + res * 0.8;
        if (temp < min)
            min = temp;
        //use 满减

        for (int i = 0; i < m; i++){
            if (all < discount[i][0])
                continue;
            temp = all - discount[i][1];
            if (temp < min)
                min = temp;
        }
        //DecimalFormat df = new DecimalFormat("0.00");
        //System.out.println(df.format(min));
        BigDecimal num = new BigDecimal(min).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(num);
    }
}
