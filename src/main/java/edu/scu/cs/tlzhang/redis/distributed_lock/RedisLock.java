package edu.scu.cs.tlzhang.redis.distributed_lock;

import com.alibaba.druid.util.StringUtils;
import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by tlzhang on 2016/12/14.
 */
public class RedisLock {
    private Long timeout = 10L;
    private String lockPrefix = "lock:";
    private Long sleepTime = 50L;
    private String key;
    private RedisTemplate redisTemplate = (RedisTemplate)SpringContextHelper.getBean("redisTemplate");

    public RedisLock(String key) {
        this.key = key;
    }

    public Boolean trylock(Long rdm) throws InterruptedException {
        String prefix = lockPrefix + key;
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(prefix);
        while(true){
            System.out.println(Thread.currentThread().getId() + ":try to get lock again");
            if(boundValueOperations.setIfAbsent(String.valueOf(rdm))){
                boundValueOperations.expire(timeout, TimeUnit.SECONDS);
                return true;
            }else {
                Thread.sleep(sleepTime);
            }
        }
    }

    public Boolean unlock(Long rdm){
        String prefix = lockPrefix + key;
        BoundValueOperations boundValueOperations = redisTemplate.boundValueOps(prefix);
        if(!StringUtils.isEmpty((String)boundValueOperations.get())){
            Long digit = Long.parseLong((String)boundValueOperations.get());
            if(digit == rdm){
                redisTemplate.delete(prefix);
            }

            return true;
        }
        return false;
    }
}
