package com.xawl.travel.controller;

import com.xawl.travel.pojo.Order;
import com.xawl.travel.service.OrderService;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by Administrator on 2017/11/22.
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 根据商家id查询订单
     * @param bid
     * @param pn
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/selectOrderByBid.action")
    public Result selectOrderByBid(@RequestParam("bid") String bid, @RequestParam(value = "pn") Integer pn) throws Exception {

        Result result = orderService.selectOrderByBid(bid, pn);
        return result;
    }


    /**
     * 根据订单号查询
     * @param oid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/selectOrderByOid.action")
    public Result selectOrderByOid(Order order) throws Exception {

        Result result = orderService.selectOrderByOid(order);
        return result;
    }


    /**
     * 通过订单状态查询订单
     * @param order
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/selectOrderByStatus.action")
    public Result selectOrderByStatus(Order order) throws Exception {

        /*HashMap<String,String> maps = new HashMap<String, String>();
        maps.put("status",status);
        maps.put("bid",bid);*/
        order.setBid(order.getBid());
        order.setStatus(order.getStatus());
        Result result = orderService.selectOrderByStatus(order);
        return result;
    }

    /**
     * 修改订单状态
     * @param order  oid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/updateOrderStatus.action")
    public Result updateOrderStatus(short status,Order order) throws Exception{

        if(status == 0){
            order.setStatus((short)0);
            order.setOid(order.getOid());
            order.setBid(order.getBid());
            order.setCreateTime(order.getCreateTime());
            order.setPayTime(order.getPayTime());
            order.setUid(order.getUid());
            order.setTotalprice(order.getTotalprice());
            Result result = orderService.updateOrderStatus(order);
            return result;
        }else if(status == 1){
            order.setStatus((short)1);
            order.setOid(order.getOid());
            order.setBid(order.getBid());
            order.setCreateTime(order.getCreateTime());
            order.setPayTime(order.getPayTime());
            order.setUid(order.getUid());
            order.setTotalprice(order.getTotalprice());
            Result result = orderService.updateOrderStatus(order);
            return result;
        }else if(status == 2) {
            order.setStatus((short) 2);
            order.setOid(order.getOid());
            order.setBid(order.getBid());
            order.setCreateTime(order.getCreateTime());
            order.setPayTime(order.getPayTime());
            order.setUid(order.getUid());
            order.setTotalprice(order.getTotalprice());
            Result result = orderService.updateOrderStatus(order);
            return result;
        }else{
            return Result.fail("订单有误,修改失败");
        }
    }

}
