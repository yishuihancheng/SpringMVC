package edu.scu.cs.tlzhang.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by tlzhang on 16-11-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml"})
public class RedisTestTest {
    @Test
    public void strAdd() throws Exception {
        String key = RedisTest.STRING_PREFIX + "20161111:";
        RedisTest.strAdd(key, "20161111");

    }

    @Test
    public void strDel() throws Exception {
        String key = RedisTest.STRING_PREFIX + "20161111:";
        RedisTest.strDel(key);
    }

    @Test
    public void strGet() throws Exception {
        String key = RedisTest.STRING_PREFIX + "20161111:";
        System.out.println(RedisTest.strGet(key));
    }

}