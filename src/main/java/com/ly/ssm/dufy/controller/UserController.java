package com.ly.ssm.dufy.controller;

import com.ly.ssm.dufy.entity.User;
import com.ly.ssm.dufy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/9/11 15:09
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    // 测试

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String sayHello() {
        return "hello!";
    }

    // Create

    @RequestMapping(method = RequestMethod.POST)
    public boolean saveUser(@RequestBody User user) {
        boolean b = userService.saveUserInfoAnnotation(user);
        System.out.println("b = " + b);
        return b;
    }

    @RequestMapping(value = "batch", method = RequestMethod.POST)
    public int saveUserBatch(@RequestBody List<User> userList) {

        int i = userService.saveUserBatch(userList);
        System.out.println("i = " + i);
        System.out.println("userList = " + userList);
        return i;
    }

    // Retrieve

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") String id) {
        return null;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {

        List<User> users = userService.listUsers();
        return users;
    }

    // Update

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public int updateUserById(@PathVariable("id") String id) {
        return 0;
    }

    // Delete

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable("id") String id) {
        System.out.println("RestController  id = " + id);
        boolean b = userService.removeUserById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public int deleteUser() {
        return userService.removeUser();
    }




}
