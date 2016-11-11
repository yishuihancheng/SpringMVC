package edu.scu.cs.tlzhang.redis;

import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import org.springframework.data.redis.core.BoundKeyOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by tlzhang on 16-11-11.
 */
public class RedisTest {
    public static String LIST_PREFIX = "test:list:";
    public static String SET_PREFIX = "test:set:";
    public static String HASH_PREFIX = "test:hash:";
    public static String SORT_SET = "test:sortset:";
    public static String STRING_PREFIX = "test:string:";
    public static RedisTemplate redisTemplate = (RedisTemplate) SpringContextHelper.getBean("redisTemplate");

    public static void strAdd(String key, String name){
        BoundValueOperations operations = redisTemplate.boundValueOps(key);
        operations.set(name);

    }

    public static void strDel(String key){
        redisTemplate.delete(key);
    }

    public static String strGet(String key){
        BoundValueOperations operations = redisTemplate.boundValueOps(key);
        return (String)operations.get();
    }
}
