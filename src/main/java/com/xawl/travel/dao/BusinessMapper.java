package com.xawl.travel.dao;

import com.xawl.travel.pojo.Business;

import java.util.List;

public interface BusinessMapper {

    //查询
    List<Business> findAll();

    Business selectByPrimaryKey(String bid);

    int deleteByPrimaryKey(String bid);

    int insert(Business record);

    int insertSelective(Business record);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);

}