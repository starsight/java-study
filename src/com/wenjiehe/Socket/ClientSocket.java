package com.wenjiehe.Socket;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/8/10.
 */
public class ClientSocket {
    private static final String ip = "127.0.0.1";
    private static final int port = 12457;

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(ip, port);
            socket.setSoTimeout(2000);
            OutputStream outputStream = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            Scanner sc = new Scanner(System.in);
            String s = null;
            while (!"stop".equals(s = sc.nextLine())) {
                writer.write(s);
                writer.flush();
            }
            //socket.setKeepAlive(true);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
