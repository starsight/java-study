package com.wenjiehe.JavaSE;

import java.util.Date;

/**
 * Created by yiyuan on 2016/9/28.
 */
public class Pair <T> {
    T first;
    T second;

    Pair(){

    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }




    void test(){

    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
