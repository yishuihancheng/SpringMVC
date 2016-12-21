package edu.scu.cs.tlzhang.mybatis.dao;

import edu.scu.cs.tlzhang.mybatis.entity.Vo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tlzhang on 2016/12/19.
 */
public interface ItemDao<T extends Vo, R extends Vo> {
    public void insert(T t);
    public R findById(Integer id);
    public List<R> findAll(T t);
}
