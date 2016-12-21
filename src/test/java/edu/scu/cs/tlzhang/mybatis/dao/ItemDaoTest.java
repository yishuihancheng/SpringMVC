package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.mybatis.entity.Item;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:mybatis.xml"})
public class ItemDaoTest extends TestCase {

    @Resource
    private ItemDao itemDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        Item item = new Item();
        item.setName("雪佛兰-大黄蜂");
        item.setPrice(0.1f);
        item.setDetail("我爱雪佛兰");
        itemDao.insert(item);
    }

    @Test
    public void testFindById() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }
}