package com.huchx.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @UDP
 *a、是面向无连接, 将数据及源的封装成数据包中,不需要建立建立连接
 *b、每个数据报的大小在限制64k内
 *c、因无连接,是不可靠协议
 *d、不需要建立连接,速度快
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("UDP Server启动服务.....");
        DatagramSocket ds = new DatagramSocket(8080);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        ds.receive(dp);
        System.out.println("来源："+dp.getAddress().getHostAddress()+",port:"+dp.getPort());
        String str = new String(dp.getData(),0,dp.getLength());
        System.out.println("客户端发送得数据："+str);
        ds.close();
        System.out.println("UDP Server关闭服务.....");
    }
}
