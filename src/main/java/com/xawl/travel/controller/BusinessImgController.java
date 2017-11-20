package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessImg;
import com.xawl.travel.service.BusinessImgService;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/11/16.
 */

@Controller
@RequestMapping("/businessImg")
public class BusinessImgController {

    @Autowired
    private BusinessImgService businessImgService;
    @ResponseBody
    @RequestMapping("/selectImgByBid.action")
    public Result selectImgByBid(HttpServletRequest request, HttpServletResponse response, String bid){

        Result result = businessImgService.selectImgByBid(bid);
        result.success("成功");
        System.out.println(result.toString());
        return result;
    }

    @ResponseBody
    @RequestMapping("/addImg.action")
    public Result addImg(HttpServletRequest request, HttpServletResponse response, BusinessImg businessImg, MultipartFile file){

        Result result = businessImgService.addImg(businessImg);
        return  result;
    }


}
