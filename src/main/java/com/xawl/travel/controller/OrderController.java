package com.xawl.travel.controller;

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

    @ResponseBody
    @RequestMapping("/selectOrderByBid.action")
    public Result selectOrderByBid(@RequestParam("bid") String bid, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws Exception {

        Result result = orderService.selectOrderByBid(bid, pn);
        return result;
    }

}
