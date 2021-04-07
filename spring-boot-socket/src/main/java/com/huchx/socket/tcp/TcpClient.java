package com.huchx.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("socket启动......");
        Socket s = new Socket("10.2.96.154",8080);
        OutputStream os = s.getOutputStream();
        os.write("客户端发送数据..".getBytes());
        s.close();
    }
}
