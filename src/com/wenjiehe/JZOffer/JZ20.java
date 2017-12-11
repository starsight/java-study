package com.wenjiehe.JZOffer;

import java.util.ArrayList;

/**
 * Created by yiyuan on 17/12/11.
 */
public class JZ20 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int top=0,bottom=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        ArrayList<Integer> list =new ArrayList<>();

        while(top<=bottom&&left<=right){
            if(top<=bottom){
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            }

            if(left<=right){
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            }

            if(top<=bottom){
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left<=right){
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }

        }

        return list;
    }

    public static void main(String[] args) {
        JZ20 jz20 =new JZ20();
        jz20.printMatrix(new int[][]{new int[]{1,2},new int[]{3,4}});
    }
}
