package com.xawl.travel.controller;

import com.xawl.travel.service.BusinessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wt on 2017/11/22.
 */

@Controller
@RequestMapping("/businessInfo")
public class BusinessInfoController {

    @Autowired
    private BusinessInfoService businessInfoService;

}
