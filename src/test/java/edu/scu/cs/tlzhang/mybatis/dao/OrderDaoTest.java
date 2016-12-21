package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.mybatis.entity.CustomOrder;
import edu.scu.cs.tlzhang.mybatis.entity.Order;
import edu.scu.cs.tlzhang.mybatis.entity.User;
import edu.scu.cs.tlzhang.mybatis.entity.UserAndItem;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring_context.xml", "classpath:mybatis.xml"})
public class OrderDaoTest extends TestCase {

    @Resource
    private OrderDao orderDao;
    @Test
    public void testInsert() throws Exception {
        Order order = new Order();
        order.setUid(2);
        orderDao.insert(order);
    }

    @Test
    public void testFindUserOrder(){
        List<CustomOrder> orders = orderDao.findUserOrder();
        System.out.println("Execute finished");
    }

    @Test
    public void testFindUserOrderResultMap(){
        List<Order> orders = orderDao.findUserOrderResultMap();
        System.out.println("Execute finished");
    }

    @Test
    public void testFindUserOrderDetailResultMap(){
        List<Order> orders = orderDao.findUserOrderDetailResultMap();
        System.out.println("Execute finished");
    }

    @Test
    public void testFindUserAndItems(){
        List<UserAndItem> list = orderDao.findUserAndItems();
        System.out.println("Execute finished");
    }

    @Test
    public void testFindOrdersUserLazyLoding(){
        // 注意，延迟加载，在断点除查看user内部其实已经调用了getUser已经调用了相关的sql语句
        List<Order> orders = orderDao.findOrdersUserLazyLoding();
        for(Order order: orders){
            User user = order.getUser();
            System.out.println("user:name-->" + user.getName() + "\taddress-->" + user.getAddress());
        }
    }
}