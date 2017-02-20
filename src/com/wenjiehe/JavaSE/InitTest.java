package com.wenjiehe.JavaSE;

/**
 * Created by yiyuan on 17/2/14.
 */
public class InitTest {
    {
        price =2;
    }


    InitTest(){
    price  = 3;
    }

    public static void main(String args[]){
        InitTest it = new InitTest();
    }

    public int price = 1;

}
