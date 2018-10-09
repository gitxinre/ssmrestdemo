package com.ly.ssm.dufy.service.impl;

import com.ly.ssm.dufy.dao.UserDao;
import com.ly.ssm.dufy.entity.User;
import com.ly.ssm.dufy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;


    @Override
    public boolean saveUserInfoAnnotation(User user) {
        return userDao.insertUserInfoAnnotation(user) == 1;
    }

    @Override
    public boolean saveUserInfoXml(User user) {
        return userDao.insertUserInfoXml(user) == 1;
    }

    @Override
    public int saveUserBatch(List<User> userList) {

        int size = userList.size();
        int r = 0;
        if (size / 1000 > 1) {
            for (int i = 0; i < size / 1000; i++) {

                if (i != (size / 1000 - 1)) {

                    List<User> userList1 = userList.subList(i * 1000, (i + 1) * 1000);
                    r += userDao.insertUserBatch(userList1);
                }else {
                    List<User> userList1 = userList.subList(i * 1000, size);
                    r += userDao.insertUserBatch(userList1);
                }
            }
            return r;
        }else {
            return userDao.insertUserBatch(userList);
        }

    }

    @Override
    public boolean removeUserById(String id) {
        int i = userDao.deleteUserById(id);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public int removeUser() {
        return userDao.removeUser();
    }

    @Override
    public boolean updateUserById(User user) {
        int i = userDao.updateUserById(user);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }
}
