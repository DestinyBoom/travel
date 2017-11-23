package com.xawl.travel.service;

import com.xawl.travel.dao.BusinessDeviceMapper;
import com.xawl.travel.pojo.BusinessDevice;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */

@Service
public class BusinessDeviceService {

    @Autowired
    private BusinessDeviceMapper businessDeviceMapper;

    public Result findDeviceByBid(String bid) {

        if (bid == null || bid == "") {
            return Result.fail(300, "请给出对应商家ID");
        }
        try {
            List<BusinessDevice> businessDeviceList = businessDeviceMapper.selectDeviceByBid(bid);
            return Result.success(businessDeviceList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }

    }

    public Result addDeviceByBid(BusinessDevice businessDevice) {
        try {
            businessDeviceMapper.insertSelective(businessDevice);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("添加失败");
        }
        return Result.success("添加成功");
    }

    public int delDeviceByDid(String did) {

        return businessDeviceMapper.deleteByPrimaryKey(did);
    }
}