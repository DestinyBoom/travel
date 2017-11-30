package com.xawl.travel.controller;

import com.xawl.travel.pojo.Business;
import com.xawl.travel.service.BusinessService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
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
     * 登录
     *
     */
    @ResponseBody
    @RequestMapping("/login.action")
    public Result login(String bid,String pass){
        return businessService.login(bid,pass);
    }

    /**
     *    查找全部信息
     */
    @ResponseBody
    @RequestMapping("/findAll.action")
   /* public List<Business> findAll(HttpServletRequest request, HttpServletResponse response){
        return businessService.findAll();
    }*/
    public Result findAll(Integer page){
        return businessService.findAll(page);
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
    @RequestMapping("/selectByPrimaryKey.action")
    public Business selectByPrimaryKey(String bid){
        return businessService.selectByPrimaryKey(bid);
    }

    @ResponseBody
    @RequestMapping("/selectByBid.action")
    public int selectByBid(String bid){
        return businessService.selectByBid(bid);
    }

    /**
     * 添加
     * @param record
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert.action")
    public Result insert(Business record,MultipartFile file,HttpServletRequest request){
        Result result=  businessService.insert(record,request,file);
        return result;
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
