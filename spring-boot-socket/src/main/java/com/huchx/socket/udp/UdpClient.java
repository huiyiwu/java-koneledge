package com.huchx.socket.udp;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("udp 发送数据");
        DatagramSocket ds = new DatagramSocket();
        String str = "客户端发送的数据....";
        byte[] bytes = str.getBytes();
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("10.2.96.154"),8080);
        ds.send(dp);
        ds.close();
    }
}
