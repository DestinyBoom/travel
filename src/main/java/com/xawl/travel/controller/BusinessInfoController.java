package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessInfo;
import com.xawl.travel.service.BusinessInfoService;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wt on 2017/11/22.
 */

@Controller
@RequestMapping("/businessInfo")
public class BusinessInfoController {

    @Autowired
    private BusinessInfoService businessInfoService;

    @ResponseBody
    @RequestMapping("/findInfoByBid.action")
    public Result findDeviceByBid(@RequestParam("bid")String bid)throws Exception{

        Result result = businessInfoService.findInfoByBid(bid);
        return  result;
    }

    @ResponseBody
    @RequestMapping("/addInfoByBid.action")
    public Result addInfoByBid(BusinessInfo businessInfo)throws Exception{

        businessInfo.setBid(businessInfo.getBid());
        businessInfo.setInfo(businessInfo.getInfo());
        Result result = businessInfoService.addInfoByBid(businessInfo);
        return  result;
    }

    @ResponseBody
    @RequestMapping("/deleteInfoByBid.action")
    public Result deleteInfoByBid(@RequestParam("bid")String bid){

        int delete = businessInfoService.deleteInfoByBid(bid);
        if(delete == 0){
            return Result.fail("删除失败");
        }else{
            return Result.success("删除成功");
        }
    }

    @ResponseBody
    @RequestMapping("/updateInfoByBid.action")
    public Result updateInfoByBid(BusinessInfo businessInfo){

        businessInfo.setBid(businessInfo.getBid());
        businessInfo.setInfo(businessInfo.getInfo());
        int update = businessInfoService.updateInfoByBid(businessInfo);
        if(update == 0){
            return Result.fail("修改失败");
        }else{
            return Result.success("修改成功");
        }
    }

}
