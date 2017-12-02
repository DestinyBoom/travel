package com.xawl.travel.dao;

import com.xawl.travel.pojo.Order;

import java.util.HashMap;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String oid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Order order);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectOrderByBid(String bid);

    List<Order> selectOrderByStatus(Order order);
}