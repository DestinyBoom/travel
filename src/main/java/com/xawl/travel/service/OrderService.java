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

    public Result selectOrderByOid(Order order) {

        if (order.getBid() == null || order.getBid() == "") {
            return Result.fail(300, "请给出对应商家ID");
        }
        if (order.getOid() == null || order.getOid() == "") {
            return Result.fail(300, "请给出对应订单号");
        }
        try {
            order = orderMapper.selectByPrimaryKey(order);
            return Result.success(order);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }
    }

    public Result selectOrderByStatus(Order order) {
        
        if (order.getBid() == null||order.getBid()==""){
            return Result.fail(300, "查询对象不存在");
        }
        try {
            List<Order> orderList = orderMapper.selectOrderByStatus(order);
            return Result.success(orderList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }
    }

    public Result updateOrderStatus(Order order) {
        int orderNum = orderMapper.updateByPrimaryKeySelective(order);
        if (orderNum == 0) {
            return Result.fail("修改失败,数据有误");
        } else {
            return Result.success("修改成功");
        }
    }
}
