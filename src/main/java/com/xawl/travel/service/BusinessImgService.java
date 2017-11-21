package com.xawl.travel.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.travel.dao.BusinessImgMapper;
import com.xawl.travel.pojo.BusinessImg;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */

@Service
public class BusinessImgService {

    @Autowired
    private BusinessImgMapper businessImgMapper;

    public Result selectImgByBid(String bid, Integer pn, Integer num) {

        if(bid == null||bid ==""){
            return Result.fail(300, "请给出对应商家ID");
        }
        try {
            PageHelper.startPage(pn, num);
            List<BusinessImg> businessImgList = businessImgMapper.selectImgByBid(bid);
            PageInfo<BusinessImg> pageInfo = new PageInfo<BusinessImg>(businessImgList);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }

    }



    public int uploadImg(BusinessImg businessImg) {


       return businessImgMapper.insertSelective(businessImg);

    }
}
