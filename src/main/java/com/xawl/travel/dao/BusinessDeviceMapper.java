package com.xawl.travel.dao;

import com.xawl.travel.pojo.BusinessDevice;

import java.util.List;

public interface BusinessDeviceMapper {
    int deleteByPrimaryKey(String did);

    int insert(BusinessDevice record);

    int insertSelective(BusinessDevice record);

    BusinessDevice selectByPrimaryKey(String did);

    List<BusinessDevice> selectDeviceByBid(String bid);

    int updateByPrimaryKeySelective(BusinessDevice record);

    int updateByPrimaryKey(BusinessDevice record);

}