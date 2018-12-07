package com.socket;

import org.junit.Test;

import java.io.*;
import java.net.*;

/**
 * 一、网络基础知识（参考计算机网络）
 关于计算机网络部分可以参考相关博客：
 《TCP/IP协议栈及OSI参考模型详解》
 http://wangdy.blog.51cto.com/3845563/1588379
 1、两台计算机间进行通讯需要以下三个条件：
 IP地址、协议、端口号
 2、TCP/IP协议：
 是目前世界上应用最为广泛的协议，是以TCP和IP为基础的不同层次上多个协议的集合，也成TCP/IP协议族、或TCP/IP协议栈
 TCP：Transmission Control Protocol 传输控制协议
 IP：Internet Protocol 互联网协议
 3、TCP/IP五层模型
 应用层：HTTP、FTP、SMTP、Telnet等
 传输层：TCP/IP
 网络层：
 数据链路层：
 物理层：网线、双绞线、网卡等
 4、IP地址
 为实现网络中不同计算机之间的通信，每台计算机都必须有一个唯一的标识---IP地址。
 32位二进制
 5、端口
 区分一台主机的多个不同应用程序，端口号范围为0-65535，其中0-1023位为系统保留。
 如：HTTP：80  FTP：21 Telnet：23
 IP地址+端口号组成了所谓的Socket，Socket是网络上运行的程序之间双向通信链路的终结点，是TCP和UDP的基础
 6、Socket套接字：
 网络上具有唯一标识的IP地址和端口组合在一起才能构成唯一能识别的标识符套接字。
 Socket原理机制：
 通信的两端都有Socket
 网络通信其实就是Socket间的通信
 数据在两个Socket间通过IO传输
 7、Java中的网络支持
 针对网络通信的不同层次，Java提供了不同的API，其提供的网络功能有四大类：
 InetAddress:用于标识网络上的硬件资源，主要是IP地址
 URL：统一资源定位符，通过URL可以直接读取或写入网络上的数据
 Sockets：使用TCP协议实现的网络通信Socket相关的类
 Datagram:使用UDP协议，将数据保存在用户数据报中，通过网络进行通信。

 * @author: yangmengjun
 * @date: 2018\12\7 0007 15:31
 */
public class InetAddressDemo {

    @Test
    public void test(){
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostAddress());
            System.out.println(inetAddress.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void urlDemo(){
        //创建一个URL的实例
        URL baidu = null;
        try {
            baidu = new URL("http://www.baidu.com");
            URL url =new URL(baidu,"/index.html?username=tom#test");//？表示参数，#表示锚点
            String protocol = url.getProtocol();//获取协议
            url.getHost();//获取主机
            url.getPort();//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
            url.getPath();//获取文件路径
            url.getFile();//文件名，包括文件路径+参数
            url.getRef();//相对路径，就是锚点，即#号后面的内容
            url.getQuery();//查询字符串，即参数

            InputStream is = url.openStream();
            InputStreamReader reader = new InputStreamReader(is,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while(line!=null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void serverSocketDemo(){
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            serverSocket = new ServerSocket(10086);
            //accept方法会阻塞服务端，可以一直从客户端读取内容
            socket = serverSocket.accept();

            reader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(reader);
            String line = null;
            while((line = bufferedReader.readLine())!=null){
                System.out.println("我是服务端，从客户端读取到了："+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                reader.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void clientSocketDemo(){
        Socket socket = null;
        OutputStream os = null;
        PrintWriter pw = null;
        InputStream is = null;
        BufferedReader reader = null;

        try {
            socket = new Socket("127.0.0.1",10086);

            os = socket.getOutputStream();
            pw = new PrintWriter(os);
            pw.print("我是客户端，这是我发送的文本内容");
            pw.flush();
            socket.shutdownOutput();

            //读取服务端反馈的内容
            is = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String data = null;
            while((data=reader.readLine())!=null){
                System.out.println("从服务端读取到："+data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                pw.close();
                is.close();
                reader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void datagramDemo(){
        try {
            DatagramSocket socket = new DatagramSocket(12563);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
