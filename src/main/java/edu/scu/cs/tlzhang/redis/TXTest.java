package edu.scu.cs.tlzhang.redis;

import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlzhang on 16-11-14.
 * Redis事务测试
 */
public class TXTest {
    public static RedisTemplate redisTemplate = (RedisTemplate)SpringContextHelper.getBean("redisTemplate");
    public static String NAME_PREFIX = "test:name:";
    public static String AGE_PREFIX = "test:age:";
    public static String SCHOOL_PREFIX = "test:school:";

    public static void transactionTest(){
        List<String> keys = new ArrayList<String>();
        keys.add(NAME_PREFIX);
        keys.add(AGE_PREFIX);
        keys.add(SCHOOL_PREFIX);

        redisTemplate.multi();
        setValue(NAME_PREFIX, "name");
        setValue(AGE_PREFIX, "age");
        setValue(SCHOOL_PREFIX, "school");

        redisTemplate.exec();
    }

    public static void transactionExcTest(){
        List<String> keys = new ArrayList<String>();
        keys.add(NAME_PREFIX);
        keys.add(AGE_PREFIX);
        keys.add(SCHOOL_PREFIX);

        redisTemplate.multi();
        setValue(NAME_PREFIX, "name");
        setExcValue(AGE_PREFIX, "age");
        setValue(SCHOOL_PREFIX, "school");

        redisTemplate.exec();
    }

    public static void setValue(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public static void setExcValue(String key, String value){
        redisTemplate.boundListOps(key).leftPush(value);
    }
}
