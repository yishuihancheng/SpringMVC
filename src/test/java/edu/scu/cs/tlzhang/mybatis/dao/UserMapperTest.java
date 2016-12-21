package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import edu.scu.cs.tlzhang.mybatis.entity.Gender;
import edu.scu.cs.tlzhang.mybatis.entity.User;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:mybatis.xml"})
public class UserMapperTest extends TestCase {

    @Test
     public void testFindUserById(){
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserById(1);
        userDao.updateUser(user);
        User user2 = userDao.findUserById(1);
        System.out.println("id:" + user.getId() + "\tname:" + user.getName() + "\taddress:" + user.getAddress());

    }

    @Test
    public void testCache2(){
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserById(1);
        // sqlSession如果不关闭，是不能写到二级缓存区域的
        sqlSession.close();

        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = new User();
        user2.setId(1);
        user2.setName("Jeams");
        user2.setAddress("FBI");
        user2.setGender(Gender.male);
        user2.setBirthday(new Date());
        userDao2.updateUser(user2);
        sqlSession2.commit();
        sqlSession2.close();

        UserDao userDao1 = sqlSession1.getMapper(UserDao.class);
        User user1 = userDao1.findUserById(1);
        sqlSession1.close();

    }

    @Test
    public void testFindUserByName(){
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("tl");
        user.setGender(Gender.male);
        List<User> users = userDao.findUserByName(user);
        for(User o:users){
            System.out.println("id:" + o.getId() + "\tname:" + o.getName() + "\taddress:" + o.getAddress());
        }

    }

    @Test
    public void testFindUserByIds(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(7);
        list.add(8);
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.findUserByIds(list);
        for(User o:users){
            System.out.println("id:" + o.getId() + "\tname:" + o.getName() + "\taddress:" + o.getAddress());
        }
    }
    @Test
    public void testInsertUser(){
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setName("马化腾");
        user.setAddress("深圳腾讯计算机科技有限公司");
        user.setGender(Gender.male);
        user.setBirthday(new Date());
        userDao.insertUser(user);
    }

}
