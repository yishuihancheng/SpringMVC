package edu.scu.cs.tlzhang.redis;

import edu.scu.cs.tlzhang.helper.DateUtils;
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
        String key = RedisTest.STRING_PREFIX + "20161114:";
        RedisTest.strAdd(key, "20161111");

    }

    @Test
    public void strDel() throws Exception {
        String key = RedisTest.STRING_PREFIX + "20161114:";
        RedisTest.strDel(key);
    }

    @Test
    public void strGet() throws Exception {
        String key = RedisTest.STRING_PREFIX + "20161114:";
        System.out.println(RedisTest.strGet(key));
    }

    @Test
    public void listLeftPush() throws Exception{
        String key = RedisTest.LIST_PREFIX + "20161114:";
        RedisTest.listLeftPush(key, DateUtils.nowDateTime().toString());
    }

    @Test
    public void listRightPush() throws Exception{
        String key = RedisTest.LIST_PREFIX + "20161114:";
        RedisTest.listRightPush(key, DateUtils.nowDateTime().toString());
    }

    @Test
    public void listLeftPop() throws Exception{
        String key = RedisTest.LIST_PREFIX + "20161114:";
        RedisTest.listLeftPop(key);
    }

    @Test
    public void listRightPop() throws Exception{
        String key = RedisTest.LIST_PREFIX + "20161114:";
        RedisTest.listRightPop(key);
    }

    @Test
    public void listClear() throws Exception{
        String key = RedisTest.LIST_PREFIX + "20161114:";
        RedisTest.listClear(key);
    }


    @Test
    public void setAdd() throws Exception{
        String key = RedisTest.SET_PREFIX + "20161114:";
        RedisTest.setAdd(key, "20161117");
    }

    @Test
    public void setRemove() throws Exception{
        String key = RedisTest.SET_PREFIX + "20161114:";
        RedisTest.setRemove(key, "20161114");
    }

    @Test
    public void setDel() throws Exception{
        String key = RedisTest.SET_PREFIX + "20161114:";
        RedisTest.setDel(key);
    }


    @Test
    public void hashAdd() throws Exception{
        String key = RedisTest.HASH_PREFIX + "20161115:";
        String hashValue = "4";
        RedisTest.hashAdd(key, hashValue, hashValue);
    }

    @Test
    public void hashRemove() throws Exception{
        String key = RedisTest.HASH_PREFIX + "20161115:";
        String hashValue = "1";
        RedisTest.hashRemove(key, hashValue, hashValue);
    }

    @Test
    public void hashTraverse() throws Exception{
        String key = RedisTest.HASH_PREFIX + "20161115:";
        String hashValue = "1";
        RedisTest.hashKeyTraverse(key);
    }


    @Test
    public void zSortAdd() throws Exception{
        String key = RedisTest.SORT_SET + "20161114:";
        RedisTest.zSortAdd(key, "1", 1);
        RedisTest.zSortAdd(key, "2", 2);
        RedisTest.zSortAdd(key, "3", 3);
        RedisTest.zSortAdd(key, "4", 4);
        RedisTest.zSortAdd(key, "5", 5);
        RedisTest.zSortAdd(key, "6", 6);
        RedisTest.zSortAdd(key, "7", 7);
        RedisTest.zSortAdd(key, "8", 8);
        RedisTest.zSortAdd(key, "9", 9);
        RedisTest.zSortAdd(key, "10", 10);
    }

    @Test
    public void zSortRemove() throws Exception{
        String key = RedisTest.SORT_SET + "20161114:";
        RedisTest.zSortRemove(key, "2");
    }

    @Test
    public void zSortTraverse() throws Exception{
        String key = RedisTest.SORT_SET + "20161114:";
        RedisTest.zSortTraverse(key, 1L, 9L);
    }

}