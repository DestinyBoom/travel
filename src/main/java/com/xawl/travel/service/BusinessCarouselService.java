package com.xawl.travel.service;


import com.xawl.travel.dao.BusinessCarouselMapper;
import com.xawl.travel.pojo.BusinessCarousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by zb on 2017/11/14.
 */
@Service
public class BusinessCarouselService {

    @Autowired
    public BusinessCarouselMapper businessCarouselMapper;

    public BusinessCarousel selectByPrimaryKey(String bcid){return businessCarouselMapper.selectByPrimaryKey(bcid);}

    public int deleteByPrimaryKey(String bcid){return businessCarouselMapper.deleteByPrimaryKey(bcid);}

    public int insert(BusinessCarousel record){return businessCarouselMapper.insert(record);}

    public int  insertSelective(BusinessCarousel record){return businessCarouselMapper.insertSelective(record);}

    public int updateByPrimaryKeySelective(BusinessCarousel record){return businessCarouselMapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(BusinessCarousel record){return businessCarouselMapper.updateByPrimaryKey(record);}


}

