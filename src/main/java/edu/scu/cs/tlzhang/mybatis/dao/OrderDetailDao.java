package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.mybatis.entity.Vo;

import java.util.List;

/**
 * Created by tlzhang on 2016/12/19.
 */
public interface OrderDetailDao<T extends Vo, R extends Vo> {
    public void insert(Vo T);
    public R findById(Vo T);
    public List<R> findAll();


}
