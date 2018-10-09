package com.ly.ssm.webservice.server.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author Administrator
 */
@WebService
public interface HelloWorld {
    /**
     * sayHi
     *
     * @param text
     * @return
     */
    String sayHi(@WebParam(name = "text") String text);

    //String sayHiToUser(User user);
}
