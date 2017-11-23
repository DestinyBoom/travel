package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessDevice;
import com.xawl.travel.service.BusinessDeviceService;
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
@RequestMapping("/businessDevice")
public class BusinessDeviceController {

    @Autowired
    private BusinessDeviceService businessDeviceService;


    @ResponseBody
    @RequestMapping("/findDeviceByBid.action")
    public Result findDeviceByBid(@RequestParam("bid")String bid)throws Exception{

        Result result = businessDeviceService.findDeviceByBid(bid);
        return  result;
    }

    @ResponseBody
    @RequestMapping("/addDeviceByBid.action")
    public Result addDeviceByBid(@RequestParam("did")String did,BusinessDevice businessDevice)throws Exception{

        if (did == null || did == "") {
            return Result.fail(300, "请给出要添加的商家设备ID");
        }
        businessDevice.setDid(did);
        businessDevice.setBid(businessDevice.getBid());
        Result result = businessDeviceService.addDeviceByBid(businessDevice);
        return  result;
    }

    @ResponseBody
    @RequestMapping("/delDeviceByDid.action")
    public Result delDeviceByBid(@RequestParam("did")String did){

        int delNum = businessDeviceService.delDeviceByDid(did);
        if(delNum == 0){
            return Result.fail("删除失败");
        }else{
            return Result.success("删除成功");
        }
    }


}
