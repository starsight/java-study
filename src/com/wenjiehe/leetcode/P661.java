package com.wenjiehe.leetcode;

/**
 * Created by Administrator on 2017/9/7.
 */
public class P661 {
    public static void main(String[] args) {
        imageSmoother(new int[][]{{2,2,2},{2,2,2},{2,2,2}});
    }

    public static int[][] imageSmoother(int[][] M) {
        int[][] ave = new int[M.length][M[0].length];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                int count =0;
                if(j>0){
                    ave[i][j]+=M[i][j-1];
                    count++;
                }

                if(j<M[i].length-1){
                    ave[i][j]+=M[i][j+1];
                    count++;
                }

                if(i>0){
                    ave[i][j]+=M[i-1][j];
                    count++;
                    if(j>0){
                        ave[i][j]+=M[i-1][j-1];
                        count++;
                    }

                    if(j<M[i].length-1){
                        ave[i][j]+=M[i-1][j+1];
                        count++;
                    }
                }

                if(i<M.length-1){
                    ave[i][j]+=M[i+1][j];
                    count++;
                    if(j>0){
                        ave[i][j]+=M[i+1][j-1];
                        count++;
                    }

                    if(j<M[i].length-1){
                        ave[i][j]+=M[i+1][j+1];
                        count++;
                    }
                }

                ave[i][j]+=M[i][j];
                ave[i][j]/=count;
            }
        }

        return ave;
    }
    }
