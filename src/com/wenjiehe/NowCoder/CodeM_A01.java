package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class CodeM_A01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String str = sc.nextLine();
            System.out.println(solution(str));
        }
    }

    public static int solution(String str){
        char[] arr = str.toCharArray();
        int[] from = new int[2];
        int[] to = new int[2];
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            to = index(arr[i]);
            count += solution_helper(from,to);
            from = to;
        }

        return count;
    }

    public static int solution_helper(int[] from, int[] to){
       return  Math.abs(to[0]-from[0])+Math.abs(to[1]-from[1]);
    }

    public static int[] index(char a){
        int[] i =new int[2];
        switch (a){
            case 'A':
            case 'B':
            case 'C':
                i[0]=0;
                i[1]=1;
                break;
            case 'D':
            case 'E':
            case 'F':
                i[0]=0;
                i[1]=2;
                break;
            case 'G':
            case 'H':
            case 'I':
                i[0]=1;
                i[1]=0;
                break;
            case 'J':
            case 'K':
            case 'L':
                i[0]=1;
                i[1]=1;
                break;
            case 'M':
            case 'N':
            case 'O':
                i[0]=1;
                i[1]=2;
                break;
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                i[0]=2;
                i[1]=0;
                break;
            case 'T':
            case 'U':
            case 'V':
                i[0]=2;
                i[1]=1;
                break;
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                i[0]=2;
                i[1]=2;
                break;
            default:
                 break;
        }

        return i;
    }
}
