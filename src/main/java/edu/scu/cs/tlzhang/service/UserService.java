package edu.scu.cs.tlzhang.service;

import edu.scu.cs.tlzhang.dao.UserDAO;
import edu.scu.cs.tlzhang.entity.User;

import javax.annotation.Resource;

/**
 * Created by tlzhang on 2016/11/28.
 */
public class UserService {
    @Resource
    private UserDAO userDAO;
    public User findUserByName(String name){
        User user = userDAO.findUserByName(name);
        System.out.println("name:" + user.getName() + "\tpwd:" + user.getPwd());
        return user;
    }

    public void insertUser(User user){
        if(userDAO == null){
            System.out.println("userDAO is null");
        }
        userDAO.insertUser(user);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
