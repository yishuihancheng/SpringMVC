package edu.scu.cs.tlzhang.dao;

import edu.scu.cs.tlzhang.entity.FactoryUser;
import edu.scu.cs.tlzhang.entity.FactoryUserExample;
import java.util.List;

public interface FactoryUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FactoryUser record);

    int insertSelective(FactoryUser record);

    List<FactoryUser> selectByExample(FactoryUserExample example);

    FactoryUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FactoryUser record);

    int updateByPrimaryKey(FactoryUser record);
}