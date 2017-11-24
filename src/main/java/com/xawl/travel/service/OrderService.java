package com.xawl.travel.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.travel.dao.OrderMapper;
import com.xawl.travel.pojo.Order;
import com.xawl.travel.utils.DefaultParam;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public Result selectOrderByBid(String bid, Integer pn) {
        if (bid == null || bid == "") {
            return Result.fail(300, "请给出对应商家ID");
        }
        try {
            PageHelper.startPage(pn, DefaultParam.pageNum);
            List<Order> businessOrderList = orderMapper.selectOrderByBid(bid);
            PageInfo<Order> pageInfo = new PageInfo<Order>(businessOrderList);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }
    }
}
