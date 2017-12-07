package com.xawl.travel.dao;

import com.xawl.travel.pojo.BusinessCarousel;

import java.util.List;

public interface BusinessCarouselMapper {

    List <BusinessCarousel> findAll();

    int deleteByPrimaryKey(String bcid);

    int insert(BusinessCarousel record);

    int insertSelective(BusinessCarousel record);

    BusinessCarousel selectByPrimaryKey(String bcid);
    //通过名称模糊查询
    List<BusinessCarousel> findByName(BusinessCarousel name);

    int updateByPrimaryKeySelective(BusinessCarousel record);

    int updateByPrimaryKey(BusinessCarousel record);
}