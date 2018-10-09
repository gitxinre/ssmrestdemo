package com.ly.ssm.dufy.service.impl;

import com.ly.ssm.dufy.entity.User;
import com.ly.ssm.dufy.service.UserService;
import com.ly.ssm.dufy.util.BaseJunit4Test;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import javax.lang.model.SourceVersion;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(BaseJunit4Test.class)
@ContextConfiguration(locations = "classpath:config/application-context.xml")
public class UserServiceImplTest extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void testSaveUserInfoAnnotation() {

        User user = this.getUser();
        user.setAddress("annotation方式");
        boolean b = userService.saveUserInfoAnnotation(user);
        log.debug("annotation方式保存用户结果为：{}", b);

    }

    @Test
    public void testSaveUserInfoXml() {

        User user = this.getUser();
        user.setAddress("XML方式");
        boolean b = userService.saveUserInfoXml(user);
        log.debug("XML方式保存用户结果为：{}", b);
    }

    @Test
    public void testAnnotationAndXml() {
        this.testSaveUserInfoAnnotation();
        this.testSaveUserInfoXml();
    }

    @Test
    public void testDeleteUserById() {
        boolean b = userService.removeUserById("000040d3b26d45a2ae5eb8e567957ef0");

        System.out.println("b = " + b);
    }

    @Test
    public void testUpdateUserById() {
        User user = this.getUser();
        user.setId("0004e6d0b97f4563b8535df674b40b07");

        boolean b = userService.updateUserById(user);
        System.out.println("b = " + b);
    }

    @Test
    public void testGetUserById() {
        User user = userService.getUserById("0004e6d0b97f4563b8535df674b40b07");
        System.out.println("user = " + user);
    }

    @Test
    public void testListUsers() {
        List<User> users = userService.listUsers();
        int i = 0;
        for (User user :
                users) {
            i++;
            if (i % 50000 == 0) {
                System.out.println("user = " + user);
            }
        }
    }

    @Test
    public void testSaveUserBatch() {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < 500000; i++) {
            User u = new User();
            u.setId(UUID.randomUUID().toString());
            u.setName("name_2018100800" + i);
            u.setAddress("address_2018100800" + i);
            userList.add(u);
        }

        int i = userService.saveUserBatch(userList);
        System.out.println("i = " + i);

    }


    private User getUser() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setName("flyfnihaoa");
        user.setAge(30);
        user.setAddress("高家庄");
        return user;
    }


}