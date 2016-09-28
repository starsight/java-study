package com.wenjiehe.JavaSE;

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

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
