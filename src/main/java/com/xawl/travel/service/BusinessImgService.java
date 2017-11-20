package com.xawl.travel.service;


import com.xawl.travel.dao.BusinessImgMapper;
import com.xawl.travel.pojo.BusinessImg;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/17.
 */

@Service
public class BusinessImgService {

    @Autowired
    private BusinessImgMapper businessImgMapper;

    public Result selectImgByBid(String bid) {
        BusinessImg businessImg;
        businessImg = businessImgMapper.selectImgByBid(bid);
        return Result.success(businessImg);
    }

    public Result addImg(BusinessImg businessImg) {

        businessImgMapper.insertSelective(businessImg);
        return Result.success();
    }
}
