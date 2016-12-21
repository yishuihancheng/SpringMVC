package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.mybatis.entity.User;

import java.util.List;

/**
 * Created by tlzhang on 2016/12/16.
 */
public interface UserDao {
    public User findUserById(Integer id);
    public List<User> findUserByName(User user);
    public List<User> findUserByIds(List<Integer> ids);
    public void insertUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
}
