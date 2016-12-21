package edu.scu.cs.tlzhang.dao;

import edu.scu.cs.tlzhang.entity.FactoryUser;
import edu.scu.cs.tlzhang.entity.FactoryUserExample;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:mybatis.xml"})
public class FactoryUserMapperTest extends TestCase {
    @Resource
    private FactoryUserMapper factoryUserMapper;
    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        FactoryUser factoryUser = new FactoryUser();
        factoryUser.setName("tlzhang");
        factoryUser.setAge(18);
        factoryUserMapper.insert(factoryUser);
    }

    @Test
    public void testInsertSelective() throws Exception {


    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        FactoryUser factoryUser = new FactoryUser();
        factoryUser.setId(1L);
        FactoryUser user = factoryUserMapper.selectByPrimaryKey(factoryUser.getId());
        System.out.println("id:" + user.getId() + "\tname:" + user.getName());
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {


    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }

    @Test
    public void testSelectByExample() throws Exception{
        FactoryUserExample example = new FactoryUserExample();
        FactoryUserExample.Criteria criteria = example.createCriteria();
        criteria.andIdBetween(0L,10L);
        List<FactoryUser> userList = factoryUserMapper.selectByExample(example);
        for(FactoryUser user: userList){
            System.out.println("id:" + user.getId() + "\tname:" + user.getName());
        }
    }
}