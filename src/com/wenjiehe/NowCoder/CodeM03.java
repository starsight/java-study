package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class CodeM03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] input = new double[16][16];

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                input[i][j] = sc.nextDouble();
            }
        }

        double[] result = new double[16];
        double[] result1 = new double[16];
        double[] result2 = new double[16];

        for (int i = 0; i < 16; i+=2) {
            result[i] = input[i][i+1];
            result[i+1] = input[i+1][i];
        }

        for (int i = 0; i < 16; i++) {
            result1[i] = result[i];
        }

        for (int i = 0; i <= 12; ) {
            result1[i] *=(result[i+2]*input[i][i+2] + result[i+3]*input[i][i+3] );
            i++;
            result1[i]  *= (result[i+1]*input[i][i+1] + result[i+2]*input[i][i+2] );
            i++;
            result1[i] *=(result[i-1]*input[i][i-1] + result[i-2]*input[i][i-2] );
            i++;
            result1[i] *=(result[i-2]*input[i][i-2] + result[i-3]*input[i][i-3] );
            i++;
        }

        for (int i = 0; i < 16; i++) {
            result2[i] = result1[i];
        }

        for (int i = 0; i <= 8; ) {
            result2[i] *=(result1[i+4]*input[i][i+4] + result1[i+5]*input[i][i+5] + result1[i+6]*input[i][i+6]+result1[i+7]*input[i][i+7]);
            i++;
            result2[i] *=(result1[i+4]*input[i][i+4] + result1[i+5]*input[i][i+5] + result1[i+6]*input[i][i+6]+result1[i+3]*input[i][i+3]);
            i++;
            result2[i] *=(result1[i+4]*input[i][i+4] + result1[i+5]*input[i][i+5] + result1[i+2]*input[i][i+2]+result1[i+3]*input[i][i+3]);
            i++;
            result2[i] *=(result1[i+4]*input[i][i+4] + result1[i+2]*input[i][i+2] + result1[i+1]*input[i][i+1]+result1[i+3]*input[i][i+3]);
            i++;

            result2[i] *=(result1[i-1]*input[i][i-1] + result1[i-2]*input[i][i-2] + result1[i-3]*input[i][i-3]+result1[i-4]*input[i][i-4]);
            i++;
            result2[i] *=(result1[i-5]*input[i][i-5] + result1[i-2]*input[i][i-2] + result1[i-3]*input[i][i-3]+result1[i-4]*input[i][i-4]);
            i++;
            result2[i] *=(result1[i-5]*input[i][i-5] + result1[i-6]*input[i][i-6] + result1[i-3]*input[i][i-3]+result1[i-4]*input[i][i-4]);
            i++;
            result2[i] *=(result1[i-5]*input[i][i-5] + result1[i-6]*input[i][i-6] + result1[i-7]*input[i][i-7]+result1[i-4]*input[i][i-4]);
            i++;
        }

        for (int i = 0; i < 16; i++) {
            result[i] = result2[i];
        }

        for (int i = 0; i < 8; i++) {
            double temp =0.0;
            for (int j = 0; j < 8; j++) {
                temp += result2[8+j]*input[i][8+j];
            }
            result[i] *= temp;


            temp =0.0;
            for (int j = 0; j < 8; j++) {
                temp += result2[8-j-1]*input[i+8][8-j-1];
            }
            result[i+8] *= temp;
        }

        for (int i = 0; i <16 ; i++) {
            System.out.println(result[i]);
        }

    }
}
