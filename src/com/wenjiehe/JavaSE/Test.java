package com.wenjiehe.JavaSE;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by yiyuan on 2016/9/24.
 */
public class Test extends JavaSE{
    private int i =0;
    static Test tt = new Test();
    {
        System.out.println("子类代码块");
    }
    static
    {
        System.out.println("子类静态代码块");
    }

    Test(){
        System.out.println("子类构造函数");
    }


    void show(){
        //Arrays.copyOf();
        //Array a -new Array();
        i=44;
    }
    public String replaceSpace(StringBuffer str) {
       // super.clone();
        while(str.indexOf(" ")>=0) {
            int i = str.indexOf(" ");
            str.replace(i, i + 1, "%20");
        }
        return str.toString();
    }

    @Override
    public  Test clone() throws CloneNotSupportedException {
        Test test = (Test)super.clone();
        test.date = (Date)date.clone();
        return  test;
    }
}