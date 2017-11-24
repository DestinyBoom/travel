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
     *    通过名称模糊查询
     *    @param bname
     *    @return
     */
    @ResponseBody
    @RequestMapping("/findByBname.action")
    public List<Business> findByBname(Business bname){
        return businessService.findByBname(bname);
    }

    /**
     * 通过主键查询
     * @param bid
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectByBid.action")
    public int selectByBid(String bid){
        return businessService.selectByBid(bid);
    }

    /**
     * 注册
     * @param record
     * @return
     */
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
    public Result insertSelective(Business record){
        record.setBid(CreateId.gitId());
        record.setIsUse(false);
        Result result=businessService.insertSelective(record);
        return result;
    }

    /**
     * 通过主键修改
     * @param record
     * @return
     */
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

    /**
     * 商家停用
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateBusinessDisable.action")
    public Result updateBusinessDisable(String bid){
       return businessService.updateBusinessDisable(bid);
    }


    /**
     * 商家可以使用
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateBusinessAble.action")
    public Result updateBusinessAble(String bid){
        return businessService.updateBusinessAble(bid);
    }
}
