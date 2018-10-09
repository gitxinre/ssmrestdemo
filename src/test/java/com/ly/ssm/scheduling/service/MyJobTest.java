package com.ly.ssm.scheduling.service;

import com.ly.ssm.dufy.util.BaseJunit4Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

@RunWith(BaseJunit4Test.class)
@ContextConfiguration(locations = "classpath:config/application-context.xml")
public class MyJobTest {


    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/application-context.xml");
    }

}