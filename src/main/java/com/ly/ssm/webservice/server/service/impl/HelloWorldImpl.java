package com.ly.ssm.webservice.server.service.impl;

import com.ly.ssm.webservice.server.service.HelloWorld;

import javax.jws.WebService;

/**
 * @author Administrator
 */
@WebService(endpointInterface = "com.ly.ssm.webservice.server.service.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHi(String text) {
        return "hello " + text;
    }
}
