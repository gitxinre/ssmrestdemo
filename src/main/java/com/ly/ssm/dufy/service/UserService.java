package com.ly.ssm.dufy.service;

import com.ly.ssm.dufy.entity.User;

import java.util.List;

/**
 * @author mfl
 */
public interface UserService {

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    boolean saveUserInfoAnnotation(User user);

    boolean saveUserInfoXml(User user);

    int saveUserBatch(List<User> userList);

    boolean removeUserById(String id);

    int removeUser();

    boolean updateUserById(User user);

    List<User> listUsers();

    User getUserById(String id);

}
