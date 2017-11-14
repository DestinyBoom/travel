package com.xawl.travel.dao;

import com.xawl.travel.pojo.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(String oid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String oid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}