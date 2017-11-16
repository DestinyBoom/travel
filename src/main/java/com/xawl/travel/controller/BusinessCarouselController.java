package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessCarousel;
import com.xawl.travel.service.BusinessCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zb on 2017/11/14.
 */
@Controller
@RequestMapping("/businessCarousel")
public class BusinessCarouselController {

    @Autowired
    private BusinessCarouselService businessCarouselService;
    @ResponseBody
    @RequestMapping("/selectByPrimaryKey.action")
    public BusinessCarousel selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response,String bcid){
        return businessCarouselService.selectByPrimaryKey(bcid);
    }

}

