package edu.scu.cs.tlzhang.dao;

import edu.scu.cs.tlzhang.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * Created by tlzhang on 2016/11/28.
 */
@Component("userDAO")
public interface UserDAO {
    public User findUserByName(String name);
    public void insertUser(User user);
}
