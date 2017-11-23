package com.xawl.travel.controller;

import com.xawl.travel.pojo.Business;
import com.xawl.travel.service.BusinessService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.Result;
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

    /**
     *    查找全部信息
     */
    @ResponseBody
    @RequestMapping("/findAll.action")
    public List<Business> findAll(HttpServletRequest request, HttpServletResponse response){
        return businessService.findAll();
    }

    /**
     *通过名称模糊查询
     * @param bname
     * @return
     */
    @ResponseBody
    @RequestMapping("/findByBname.action")
    public List<Business> findByBname(HttpServletRequest request, HttpServletResponse response,String bname){
      return businessService.findByBname(bname);
    }

    @ResponseBody
    @RequestMapping("/findById.action")
    public Business selectByPrimaryKey(String bid){
        return businessService.selectByPrimaryKey(bid);
    }

    @ResponseBody
    @RequestMapping("/insert.action")
    public Result insert(Business record){
        record.setBid(CreateId.gitId());
        record.setIsUse(false);
        Result result=  businessService.insert(record);
        return result ;
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
