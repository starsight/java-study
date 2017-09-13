package com.wenjiehe.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */
public class P118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0)
            return list;

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list.add(list1);
        if(numRows==1)
            return list;

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);

        list.add(list2);

        if(numRows==2)
            return list;


        for(int i=2;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> last = list.get(i-1);
            for(int j=1;j<i;j++){
                int res = last.get(j-1)+last.get(j);
                temp.add(res);
            }
            temp.add(1);
            list.add(temp);
        }

        return list;
    }

    public static void main(String[] args) {
        generate(5);
    }

}
