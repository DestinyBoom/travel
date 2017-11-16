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
    private BusinessCarouselMapper businessCarouselMapper;
    public BusinessCarousel selectByPrimaryKey(String bcid){
        return businessCarouselMapper.selectByPrimaryKey(bcid);
    }

}

