package com.xawl.travel.dao;

import com.xawl.travel.pojo.Business;

public interface BusinessMapper {
    int deleteByPrimaryKey(String bid);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(String bid);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
}