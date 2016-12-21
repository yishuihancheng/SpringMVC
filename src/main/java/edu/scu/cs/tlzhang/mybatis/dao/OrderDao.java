package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.mybatis.entity.Vo;

import java.util.List;

/**
 * Created by tlzhang on 2016/12/19.
 */
public interface OrderDao<T extends Vo, M extends Vo> {
    public void insert(T vo);
    public M findById(Integer id);
    public List<M> findAll();
    public List<M> findUserOrder();
    public List<M> findUserOrderResultMap();
    public List<M> findUserOrderDetailResultMap();
    public List<M> findUserAndItems();
    public List<M> findOrdersUserLazyLoding();

}
