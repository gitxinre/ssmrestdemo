package com.ly.ssm.webservice.client.service;

import com.ly.ssm.webservice.server.service.HelloWorld;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author Administrator
 */
public class HelloWorldClient {
    public static void main(String[] args) {
        String address = "http://localhost:8081/helloWorld";
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(HelloWorld.class);
        jaxWsProxyFactoryBean.setAddress(address);
        HelloWorld helloWorld = (HelloWorld) jaxWsProxyFactoryBean.create();
        String yf = helloWorld.sayHi("yf");
        System.out.println(yf);
    }
}
