package com.xawl.travel.service;

import com.xawl.travel.dao.BusinessInfoMapper;
import com.xawl.travel.pojo.BusinessInfo;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/11/22.
 */

@Service
public class BusinessInfoService {

    @Autowired
    private BusinessInfoMapper businessInfoMapper;

    public Result findInfoByBid(String bid) {

        if (bid == null || bid == "") {
            return Result.fail(300, "请给出对应商家ID");
        }
        try {
            BusinessInfo businessInfoList = businessInfoMapper.selectByPrimaryKey(bid);
            return Result.success(businessInfoList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }
    }

    public Result addInfoByBid(BusinessInfo businessInfo) {
        try {
            businessInfoMapper.insertSelective(businessInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("添加失败");
        }
        return Result.success("添加成功");
    }

    public int deleteInfoByBid(String bid) {

        return businessInfoMapper.deleteByPrimaryKey(bid);

    }

    public int updateInfoByBid(BusinessInfo businessInfo) {
        return businessInfoMapper.updateByPrimaryKeySelective(businessInfo);
    }
}

