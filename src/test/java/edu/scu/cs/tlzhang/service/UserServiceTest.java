package edu.scu.cs.tlzhang.service;

import edu.scu.cs.tlzhang.dao.PersonDAO;
import edu.scu.cs.tlzhang.dao.UserDAO;
import edu.scu.cs.tlzhang.entity.User;
import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:mybatis.xml"})
public class UserServiceTest extends TestCase {

    @Test
    public void testFindUserByName() throws Exception {

    }

    @Test
    public void testInsertUser() throws Exception{
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_context.xml");
        User user = new User();
        user.setName("tlzhang5");
        user.setPwd("123456");
        UserDAO userDAO = (UserDAO)SpringContextHelper.getBean("userDAO");
        if(userDAO == null){
            System.out.println("userDAO is null");
        }
        userDAO.insertUser(user);
//        new UserService().insertUser(user);

//        PersonDAO personDAO = (PersonDAO)SpringContextHelper.getBean("personDAO");
//        personDAO.println();
    }
}