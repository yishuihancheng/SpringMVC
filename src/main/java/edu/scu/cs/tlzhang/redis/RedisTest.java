package edu.scu.cs.tlzhang.redis;

import edu.scu.cs.tlzhang.helper.SpringContextHelper;
import org.springframework.data.redis.core.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static void listSort(String key){
        BoundListOperations operations = redisTemplate.boundListOps(key);
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

    // ****************************Hash test start ****************************************
    public static void hashAdd(String key, String hashKey, String value){
        BoundHashOperations operations = redisTemplate.boundHashOps(key);
        operations.put(hashKey, value);
        System.out.println("hashAdd:key-->" + key + "\thashKey-->" + hashKey + "\tvalue-->" + value );
    }

    public static void hashRemove(String key, String hashKey, String value){
        BoundHashOperations operations = redisTemplate.boundHashOps(key);
        operations.delete(hashKey);
        System.out.println("hashRemove:key-->" + key + "\thashKey-->" + hashKey);
    }

    public static void hashKeyTraverse(String key){
        BoundHashOperations operations = redisTemplate.boundHashOps(key);
        System.out.println("Method 1:map traverse");
        Map map = operations.entries();
        Iterator<Map.Entry> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry = it.next();
            System.out.println("key:" + entry.getKey() + "\tvalue:" + entry.getValue());
        }

        System.out.println("Method 2:keys traverse");
        Set<String> keys = operations.keys();
        for(String o: keys){
            System.out.println("Key:" + o);
        }

        System.out.println("Method 3:values traverse");
        List<String> values = operations.values();
        for(String o: values){
            System.out.println("Value:" + o);
        }
    }

    public static void hashGet(String key, String hashKey, String value){
        BoundHashOperations operations = redisTemplate.boundHashOps(key);
        System.out.println("key:" + key + "\thashKey:" + hashKey + "\tvalue:" + value);
    }

    public static void hashDel(String key){
        redisTemplate.delete(key);
    }

    public static void putIfAbsent(String key, String hashKey, String hashValue){
        BoundHashOperations operations = redisTemplate.boundHashOps(key);


    }
    // ****************************Hash test end ****************************************

    // ****************************ZSort test start ****************************************
    public static void zSortAdd(String key, String value, long score){
        BoundZSetOperations operations = redisTemplate.boundZSetOps(key);
        operations.add(value, score);
    }

    public static void zSortRemove(String key, String value){
        BoundZSetOperations operations = redisTemplate.boundZSetOps(key);
        operations.remove(value);
    }

    public static void zSortTraverse(String key, Long left, Long right){
        BoundZSetOperations operations = redisTemplate.boundZSetOps(key);
        Set<String> values = operations.range(left, right);
        for(String o:values){
            System.out.println("value:" + o);
        }
    }
    // ****************************ZSort test end ****************************************

    // ****************************inc dec test start ****************************************
    public static void inc(String key){
        BoundValueOperations operations = redisTemplate.boundValueOps(key);
        operations.increment(1);
    }

    public static void dec(String key){
        BoundValueOperations operations = redisTemplate.boundValueOps(key);
        operations.increment(-1);
    }

}
