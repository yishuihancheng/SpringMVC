package edu.scu.cs.tlzhang.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * Created by tlzhang on 16-11-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml"})
public class TXTestTest {
    @Test
    public void transactionTest() throws Exception {
        TXTest.transactionTest();
    }

    @Test
    public void transactionExcTest() throws Exception {
        TXTest.transactionExcTest();
    }

    @Test
    public void setValue() throws Exception {

    }

    @Test
    public void setExcValue() throws Exception {

    }

}