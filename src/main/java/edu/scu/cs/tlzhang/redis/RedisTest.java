package edu.scu.cs.tlzhang.redis;

import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import org.springframework.data.redis.core.*;

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

    // ****************************String test start ****************************************
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
    // ****************************String test end ****************************************

    // ****************************List test end ****************************************
    public static void listLeftPush(String key, String oneValue){
        System.out.println("listLeftPush:key-->" + key + "\tvalue-->" + oneValue);
        BoundListOperations operations = redisTemplate.boundListOps(key);
        operations.leftPush(oneValue);
    }
    public static void listRightPush(String key, String oneValue){
        System.out.println("listRightPush:key-->" + key + "\tvalue-->" + oneValue);
        BoundListOperations operations = redisTemplate.boundListOps(key);
        operations.rightPush(oneValue);
    }
    public static void listLeftPop(String key){
        BoundListOperations operations = redisTemplate.boundListOps(key);
        String value = (String)operations.leftPop();
        System.out.println("listLeftPop:key-->" + key + "\tvlaue-->" + value);
    }
    public static void listRightPop(String key){
        BoundListOperations operations = redisTemplate.boundListOps(key);
        String value = (String)operations.rightPop();
        System.out.println("listRightPop:key-->" + key + "\tvlaue-->" + value);
    }

    public static void listClear(String key){
        redisTemplate.delete(key);
    }
    // ****************************List test end ****************************************

    // ****************************Set test start ****************************************
    public static void setAdd(String key, String value){
        BoundSetOperations operations = redisTemplate.boundSetOps(key);
        operations.add(value);
        System.out.println("setAdd:key-->" + key + "\tvalue-->" + value);
    }

    public static void setRemove(String key, String value){
        BoundSetOperations operations = redisTemplate.boundSetOps(key);
        operations.remove(value);
        System.out.println("setRemove:key-->" + key + "\tvalue-->" + value);
    }

    public static void setDel(String key){
        redisTemplate.delete(key);
        System.out.println("setDel:key-->" + key);
    }

    // ****************************Set test end ****************************************

}
