package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import edu.scu.cs.tlzhang.mybatis.entity.Gender;
import edu.scu.cs.tlzhang.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:mybatis.xml"})
public class UserDaoTest {
    @Test
    public void testFindUserById() throws IOException {
        SqlSession sqlSession = null;
        SqlSessionFactory sqlSessionFactory = null;

        // 配置文件资源定位
        // String resource = "mybatis.xml";
        // 获取配置文件流
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        // 通过工厂得到SqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        User user = sqlSession.selectOne("test.user.findUserById", 1);

        System.out.println("id:" + user.getId() +"\tname:" + user.getName());

        // 释放连接
        sqlSession.close();



    }

    @Test
    public void testFindUserByName() throws IOException {
        SqlSession sqlSession = null;
        SqlSessionFactory sqlSessionFactory = null;

        // 配置文件资源定位
        // String resource = "mybatis.xml";
        // 获取配置文件流
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        // 通过工厂得到SqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        User object = new User();
        object.setName("tlzhang");
        List<User> userList = sqlSession.selectList("test.user.findUserByName", object);
        for(User user:userList){
            System.out.println("id:" + user.getId() +"\tname:" + user.getName());
        }

        // 释放连接
        sqlSession.close();
    }

    @Test
    public void testInsertUser() throws IOException {
        SqlSession sqlSession = null;
        SqlSessionFactory sqlSessionFactory = null;

        // 配置文件资源定位
        // String resource = "mybatis.xml";
        // 获取配置文件流
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        // 通过工厂得到SqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        User object = new User();
        object.setName("xwxia");
        object.setAddress("科大讯飞股份有限公司测试组");
        object.setGender(Gender.male);
        object.setBirthday(new Date());
        sqlSession.insert("test.user.insertUser", object);

        // 释放连接
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() throws IOException {
        SqlSession sqlSession = null;
        SqlSessionFactory sqlSessionFactory = null;

        // 配置文件资源定位
        // String resource = "mybatis.xml";
        // 获取配置文件流
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        // 通过工厂得到SqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        User object = new User();
        object.setId(4);
        object.setName("xwxia");
        object.setAddress("科大讯飞股份有限公司测试组");
        object.setGender(Gender.male);
        object.setBirthday(new Date());
        sqlSession.insert("test.user.deleteUser", object);

        // 释放连接
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() throws IOException {
        SqlSession sqlSession = null;
        SqlSessionFactory sqlSessionFactory = null;

        // 配置文件资源定位
        // String resource = "mybatis.xml";
        // 获取配置文件流
        // InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建会话工厂
        sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");
        // 通过工厂得到SqlSession
        sqlSession = sqlSessionFactory.openSession();
        // 通过sqlSession操作数据库
        User object = new User();
        object.setId(6);
        object.setName("夏兴万");
        object.setAddress("科大讯飞股份有限公司Test");
        object.setGender(Gender.male);
        object.setBirthday(new Date());
        sqlSession.insert("test.user.updateUser", object);

        // 释放连接
        sqlSession.close();
    }

}
