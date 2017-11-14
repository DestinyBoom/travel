package com.xawl.travel.dao;

import com.xawl.travel.pojo.BusinessKeepsake;

public interface BusinessKeepsakeMapper {
    int deleteByPrimaryKey(String kid);

    int insert(BusinessKeepsake record);

    int insertSelective(BusinessKeepsake record);

    BusinessKeepsake selectByPrimaryKey(String kid);

    int updateByPrimaryKeySelective(BusinessKeepsake record);

    int updateByPrimaryKeyWithBLOBs(BusinessKeepsake record);

    int updateByPrimaryKey(BusinessKeepsake record);
}