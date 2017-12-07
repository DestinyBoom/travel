package com.xawl.travel.service;


import com.xawl.travel.dao.BusinessCarouselMapper;
import com.xawl.travel.pojo.BusinessCarousel;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by zb on 2017/11/14.
 */
@Service
public class BusinessCarouselService {

    @Autowired
    public BusinessCarouselMapper businessCarouselMapper;

    public List<BusinessCarousel> findAll(){
        return businessCarouselMapper.findAll();
    }

    public BusinessCarousel selectByPrimaryKey(String bcid){return businessCarouselMapper.selectByPrimaryKey(bcid);}

    public List<BusinessCarousel> findByName(BusinessCarousel name) {
        return businessCarouselMapper.findByName(name);
    }

    public int deleteByPrimaryKey(String bcid){return businessCarouselMapper.deleteByPrimaryKey(bcid);}

    public int insert(BusinessCarousel record){return businessCarouselMapper.insert(record);}

    public int insertSelective(BusinessCarousel record){return businessCarouselMapper.insertSelective(record);}

    public int updateByPrimaryKeySelective(BusinessCarousel record){return businessCarouselMapper.updateByPrimaryKeySelective(record);}

    public int updateByPrimaryKey(BusinessCarousel record){return businessCarouselMapper.updateByPrimaryKey(record);}


}

