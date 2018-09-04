package cxf.server;

import javax.xml.ws.Endpoint;

import cxf.ws.DataTypeImpl;

public class ServerTest {
    public static void main(String[] args) {
        String address = "http://192.168.1.104:8888/com/datatypews";
        Endpoint.publish(address, new DataTypeImpl());
        System.out.println("发布陈宫");
    }
}
