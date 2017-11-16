package com.xawl.travel.controller;

import com.xawl.travel.pojo.Business;
import com.xawl.travel.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lzp on 2017/11/15.
 */

@Controller
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    //查找全部信息
    @ResponseBody
    @RequestMapping("/findAll.action")
    public List<Business> findAll(HttpServletRequest request, HttpServletResponse response){
        return businessService.findAll();
    }

    @ResponseBody
    @RequestMapping("/findById.action")
    public Business selectByPrimaryKey(String bid){
        return businessService.selectByPrimaryKey(bid);
    }

    @ResponseBody
    @RequestMapping("/insert.action")
    public int insert(Business record){
        return businessService.insert(record);
    }

    @ResponseBody
    @RequestMapping("/insertSelective.action")
    public int insertSelective(Business record){
        return businessService.insertSelective(record);
    }

    @ResponseBody
    @RequestMapping("/updateById.action")
    public int updateByPrimaryKey(Business record){
        return  businessService.updateByPrimaryKey(record);
    }

    @ResponseBody
    @RequestMapping("/updateByIdSelective.action")
    public int updateByPrimaryKeySelective(Business record){
        return businessService.updateByPrimaryKeySelective(record);
    }
}
