package com.wenjiehe.Socket;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/8/10.
 */
public class ServerSocket {
    //static ReentrantLock lock = new ReentrantLock();
    static ByteBuffer byteBuffer;
    public static void main(String[] args)  {
        ServerService ss = new ServerService();
        ss.startServe();
        Scanner sc = new Scanner(System.in);
         byteBuffer =  ByteBuffer.allocate(100);
        while (true) {
            String str = sc.nextLine();
            if(ss.selectionKey!=null){
            //lock.lock();
                byteBuffer.put(str.getBytes());
                ss.selectionKey.attach(byteBuffer);
            //lock.unlock()
                // ss.sc.write(byteBuffer);
            }
        }
    }
}
