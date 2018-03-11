package com.wenjiehe.Thread;

import java.util.concurrent.Future;

public class CreateThread {

    public static void main(String[] args) {
        Thread thread =new Thread(){
            public void run(){
                System.out.println("start");
            }
        };

        thread.start();


        Thread thread1 =new Thread(new Thread1(),"");
        thread1.start();

        thread.interrupt();
        Thread.interrupted();
    }


}

class Thread1 implements Runnable{
    public void run(){
        System.out.println("thread1 start");
    }
}

