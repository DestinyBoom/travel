package com.xawl.travel.dao;

import com.xawl.travel.pojo.BusinessCarousel;

import java.util.List;

public interface BusinessCarouselMapper {

    List <BusinessCarousel> findAll();

    int deleteByPrimaryKey(String bcid);

    int insert(BusinessCarousel record);

    int insertSelective(BusinessCarousel record);

    BusinessCarousel selectByPrimaryKey(String bcid);

    int updateByPrimaryKeySelective(BusinessCarousel record);

    int updateByPrimaryKey(BusinessCarousel record);
}