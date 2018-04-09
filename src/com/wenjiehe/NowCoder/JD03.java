package com.wenjiehe.NowCoder;

import java.util.Scanner;

public class JD03 {
    /**30%
     *
     * 60% 已修改，未测试
    * */
    static int[] positionx= new int[8];
    static int[] positiony= new int[8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        positionx[0] = -2;
        positiony[0] = 1;

        positionx[1] = -2;
        positiony[1] = -1;

        positionx[2] = 2;
        positiony[2] = 1;

        positionx[3] = 2;
        positiony[3] = -1;

        positionx[4] = -1;
        positiony[4] = 2;

        positionx[5] = 1;
        positiony[5] = 2;

        positionx[6] = -1;
        positiony[6] = -2;

        positionx[7] = 1;
        positiony[7] = -2;

        //System.out.println(get(x,y,k));
        int[][] num1 =  new int[9][10];
        int[][] num2 =  new int[9][10];

        num1[2][1] =1;
        num1[1][2] =1;

        for (int i = 1; i < k; i++) {
            get2(num1,num2);
            //num1 = num2;
            for (int j = 0; j < 9 ; j++) {
                for (int l = 0; l < 10 ; l++) {
                    num1[j][l]=num2[j][l];
                }
            }
        }
        System.out.println(num1[x][y]);

    }

    public static int get(int x,int y ,int k){
        if(k==0){
            return (x==0&&y==0)?1:0;
        }
        if(x>=0&&x<=8&&y>=0&&y<=9){
            int sum=0;
            for(int i=0;i<8;i++){
                sum+=get(x+positionx[i],y+positiony[i],k-1)%1000000007;
            }
            return sum;
        }
        return 0;
    }

    public static void get2(int[][] num1,int[][] num2){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                num2[i][j] =0;
                for(int d=0;d<8;d++){
                    num2[i][j]+=helper(i+positionx[d],j+positiony[d],num1)%1000000007;
                }
            }
        }
    }

    public static int helper(int x,int y,int[][] num1){
        if(x>=0&&x<=8&&y>=0&&y<=9){
            return num1[x][y]%1000000007;
        }
        return 0;
    }



}
