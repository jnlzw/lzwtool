package com.jnlzw.lzwtool.javaIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        while (true){
            byte[] buf = new byte[32];
            int len = in.read(buf);
            if(len == -1){
                throw  new RuntimeException("连接已断开");
            }
            System.out.println("recv:" + new String(buf, 0, len));
            out.write(buf, 0, len);
        }
    }
}

