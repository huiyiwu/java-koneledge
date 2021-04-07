package com.huchx.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @三次握手
 * 第一次握手:建立连接时，客户端发送SYN包(SYN=J)到服务器，并进入SYN_SEND状态，等待服务器确认； 
 * 第二次握手:服务器收到SYN包，必须确认客户的SYN（ACK=J+1），同时自己也发送一个SYN包（SYN=K），即SYN+ACK包，此时服务器V状态； 
 * 第三次握手:客户端收到服务器的SYN＋ACK包，向服务器发送确认包ACK(ACK=K+1)，此包发送完毕，客户端和服务器进入ESTABLISHED状态，完成三次握手。
 * 完成三次握手，客户端与服务器开始传送数据，
 *
 * @四次分手：
 * 由于TCP连接是全双工的，因此每个方向都必须单独进行关闭。这个原则是当一方完成它的数据发送任务后就能发送一个FIN来终止这个方向的连接。收到一个 FIN只意味着这一方向上没有数据流动，一个TCP连接在收到一个FIN后仍能发送数据。首先进行关闭的一方将执行主动关闭，而另一方执行被动关闭。
 * （1）客户端A发送一个FIN，用来关闭客户A到服务器B的数据传送。
 * （2）服务器B收到这个FIN，它发回一个ACK，确认序号为收到的序号加1。和SYN一样，一个FIN将占用一个序号。
 * （3）服务器B关闭与客户端A的连接，发送一个FIN给客户端A。
 * （4）客户端A发回ACK报文确认，并将确认序号设置为收到序号加1。
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("socket服务器端启动......");
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();
        byte[] buf = new byte[1024];
        int len = is.read(buf);
        String string = new String(buf,0,len);
        System.out.println("str:"+string);
        serverSocket.close();
    }
}
