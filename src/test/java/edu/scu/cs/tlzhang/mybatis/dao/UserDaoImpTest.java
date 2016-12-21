package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.mybatis.entity.Gender;
import edu.scu.cs.tlzhang.mybatis.entity.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:mybatis.xml"})
public class UserDaoImpTest extends TestCase {

    @Test
    public void testFindUserById() throws Exception {
        UserDao userDao = new UserDaoImp();
        User user = userDao.findUserById(1);
        System.out.println("id:" + user.getId() + "\tname:" + user.getName() + "\taddress:" + user.getAddress() + "\tgender:" + user.getGender());
    }

    @Test
    public void testFindUserByName() throws Exception {

    }

    @Test
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setName("马化腾");
        user.setAddress("深圳腾讯计算机科技有限公司");
        user.setGender(Gender.male);
        user.setBirthday(new Date());

    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testUpdateUser() throws Exception {

    }
}