package com.wenjiehe.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private int i =0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        final Counter cas = new Counter();

        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100 ; j++) {
            Thread t = new Thread(() -> {
                for (int i = 0; i < 10000 ; i++) {
                    cas.safeCount();
                    cas.count();
                }
            });

            ts.add(t);
        }

        for (Thread t :ts
             ) {
            t.start();
        }
        for (Thread t: ts
             ) {
            try{
                t.join();
            }catch(Exception e){
             e.printStackTrace();
            }
        }

        System.out.println(cas.i);
        System.out.println(cas.atomicInteger.get());
        System.out.println(System.currentTimeMillis()-start);
    }

    private void safeCount(){
        for(;;){
            int i =atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i,++i);
            if(suc){
                break;
            }else{
                System.out.println("");
            }
        }
    }

    private void count(){
        i++;
    }
}
