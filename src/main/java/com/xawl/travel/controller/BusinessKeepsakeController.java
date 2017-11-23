package com.xawl.travel.controller;

import com.xawl.travel.service.BusinessKeepsakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/11/22.
 */

@Controller
@RequestMapping("/businessKeepsake")
public class BusinessKeepsakeController {

    @Autowired
    private BusinessKeepsakeService businessKeepsakeService;



}
