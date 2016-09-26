package com.wenjiehe.JavaSE;

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
        i=44;
    }
    String replaceSpace(StringBuffer str) {
        while(str.indexOf(" ")>=0) {
            int i = str.indexOf(" ");
            str.replace(i, i + 1, "%20");
        }
        return str.toString();
    }


}