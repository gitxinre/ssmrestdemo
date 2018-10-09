package com.ly.ssm.webservice.server.service.impl;


import javax.xml.ws.Endpoint;


public class HelloWorldImplTest {


    public static void main(String[] args) {
        String address = "http://localhost:8081/helloWorld";
        System.out.println("web service start!");
        HelloWorldImpl helloWorld = new HelloWorldImpl();
        Endpoint.publish(address, helloWorld);
        System.out.println("web service started");
    }

}