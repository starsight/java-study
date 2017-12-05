package com.wenjiehe.Algorithm;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */
public class TwoFen
{

    private int num;

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }

        int re = findX(list,6,0,list.size()-1);
        System.out.println(re);
    }

    public static int findX(ArrayList<Integer> list, int num,int first,int last){
        if(first+1==last){
            int x = list.get(first);
            int y = list.get(last);
            if(x==num)
                return first;

            if(y==num)
                return last;
            return -1;
        }

        int middleIndex = first+(last-first)/2;
        int middleResult = list.get(middleIndex);
        if(middleResult>num){
            last = middleIndex-1;
        }
        else if(middleResult==num)
        {
            return middleIndex;
        }else{
            first = middleIndex+1;
        }

        return findX(list,num,first,last);
    }
}
