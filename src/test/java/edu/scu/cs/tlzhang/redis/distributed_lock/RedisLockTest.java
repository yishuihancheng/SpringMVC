package edu.scu.cs.tlzhang.redis.distributed_lock;

import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by tlzhang on 2016/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml"})
public class RedisLockTest extends TestCase {
//    private RedisTemplate redisTemplate = (RedisTemplate)SpringContextHelper.getBean("redisTemplate");
    private String key = "test:value";
    @Test
    public void testTrylock() throws Exception {
        RedisLock redisLock = new RedisLock(key);
        redisLock.trylock(123456L);
    }
    @Test
    public void testUnlock() throws Exception {
        RedisLock redisLock = new RedisLock(key);
        redisLock.unlock(123456L);
    }
}