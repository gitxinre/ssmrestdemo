package com.ly.ssm.dufy.util;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import java.io.FileNotFoundException;

public class BaseJunit4Test extends SpringJUnit4ClassRunner{

    static {
        try {
            Log4jConfigurer.initLogging("classpath:config/properties/log4j.properties");
        } catch (FileNotFoundException e) {
            System.out.println("Cannot Initalize log4j ! ");
            e.getMessage();
        }
    }
    public BaseJunit4Test(Class<?> clazz) throws InitializationError {
        super(clazz);
    }
}
