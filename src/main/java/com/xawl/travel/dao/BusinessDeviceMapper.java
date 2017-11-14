package com.xawl.travel.dao;

import com.xawl.travel.pojo.BusinessDevice;

public interface BusinessDeviceMapper {
    int deleteByPrimaryKey(String did);

    int insert(BusinessDevice record);

    int insertSelective(BusinessDevice record);

    BusinessDevice selectByPrimaryKey(String did);

    int updateByPrimaryKeySelective(BusinessDevice record);

    int updateByPrimaryKey(BusinessDevice record);
}