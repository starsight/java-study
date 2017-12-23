package com.wenjiehe.JZOffer;

import java.util.LinkedList;

/**
 * Created by Administrator on 2017/12/23.
 */
public class JZ45 {
    public static int LastRemaining_Solution(int n, int m) {
        if(n<=0||m<=0)
            return -1;

        LinkedList<Integer> list  = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index =-1;
        while(list.size()>1){
            index = (index+m)%n;
            list.remove(index);
            n--;
            index--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        LastRemaining_Solution(5,3);
    }

}
