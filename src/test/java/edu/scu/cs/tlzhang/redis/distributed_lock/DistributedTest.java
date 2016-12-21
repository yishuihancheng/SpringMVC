package edu.scu.cs.tlzhang.redis.distributed_lock;

import com.alibaba.druid.util.StringUtils;
import edu.scu.cs.tlzhang.redis.TXTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by tlzhang on 2016/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml"})
public class DistributedTest {
    private static String prefix = "test:value";
    private Integer poolSize = 10;
    @Resource
    private RedisTemplate redisTemplate;
    @Test
    public void distributedLockTest() throws Exception {
        Executor executor = Executors.newFixedThreadPool(poolSize);
        final RedisLock redisLock = new RedisLock(prefix);

        for(int i = 0; i < poolSize; i ++){
            Runnable thread = new Runnable() {
                @Override
                public void run() {
                    Long rdm = new Random().nextLong();
                    try {
                        if(redisLock.trylock(rdm)){
                            System.out.println(Thread.currentThread().getId() + ":get the lock");
                            BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(prefix);
                            String countStr = (String)boundValueOperations.get();
                            Long count = null;
                            if(StringUtils.isEmpty(countStr)){
                                count = 0L;
                                boundValueOperations.set(String.valueOf(count));
                            } else {
                                count = Long.parseLong(countStr);
                                count ++;
                                boundValueOperations.set(String.valueOf(count));
                            }
                            System.out.println(Thread.currentThread().getId() + ":" + count);
                            redisLock.unlock(rdm);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            executor.execute(thread);
        }
    }

}
