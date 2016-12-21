package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.mybatis.entity.OrderDetail;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:mybatis.xml"})
public class OrderDetailDaoTest extends TestCase {

    @Resource
    private OrderDetailDao orderDetailDao;
    @Test
    public void testInsert() throws Exception {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setItemCount(4);
        orderDetail.setOrderId(2);
        orderDetail.setItemId(4);
        orderDetailDao.insert(orderDetail);
    }
}