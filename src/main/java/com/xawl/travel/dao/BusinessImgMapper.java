package com.xawl.travel.dao;

import com.xawl.travel.pojo.BusinessImg;

public interface BusinessImgMapper {
    int deleteByPrimaryKey(String imgid);

    int insert(BusinessImg record);

    int insertSelective(BusinessImg record);

    BusinessImg selectByPrimaryKey(String imgid);

    BusinessImg selectImgByBid(String bid);

    int updateByPrimaryKeySelective(BusinessImg record);

    int updateByPrimaryKey(BusinessImg record);
}