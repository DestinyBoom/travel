package com.xawl.travel.dao;

import com.xawl.travel.pojo.BusinessImg;

import java.util.List;

public interface BusinessImgMapper {
    int deleteByPrimaryKey(String imgid);

    int insert(BusinessImg record);

    int insertSelective(BusinessImg record);

    BusinessImg selectByPrimaryKey(BusinessImg imgid);

    List<BusinessImg> selectImgByBid(String bid);

    int updateByPrimaryKeySelective(BusinessImg record);

    int updateByPrimaryKey(BusinessImg record);
}