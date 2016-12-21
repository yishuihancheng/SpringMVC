package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import edu.scu.cs.tlzhang.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */
public class UserDaoImp implements UserDao {
    SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)SpringContextHelper.getBean("sqlSessionFactory");

    @Override
    public User findUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.user.findUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> findUserByName(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("test.user.findUserByName", user);
        sqlSession.close();
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("test.user.insertUser", user);
        sqlSession.close();
    }

    @Override
    public void deleteUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.user.deleteUser", user);
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.user.updateUser", user);
        sqlSession.close();
    }

    @Override
    public List<User> findUserByIds(List<Integer> ids) {
        return null;
    }
}
