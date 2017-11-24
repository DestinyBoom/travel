package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessKeepsake;
import com.xawl.travel.service.BusinessKeepsakeService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.ResourceUtils;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/11/22.
 */

@Controller
@RequestMapping("/businessKeepsake")
public class BusinessKeepsakeController {

    @Autowired
    private BusinessKeepsakeService businessKeepsakeService;


    @ResponseBody
    @RequestMapping("/findKeepsakeByBid.action")
    public Result findKeepsakeByBid(String bid, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws Exception {

        Result result = businessKeepsakeService.findKeepsakeByBid(bid, pn);
        return result;
    }


    /*添加纪念品相关*/
    @ResponseBody
    @RequestMapping("/addKeepsake.action")
    public Result addKeepsake(HttpServletRequest request, HttpServletResponse response,
                              BusinessKeepsake businessKeepsake, MultipartFile multipartFile) throws Exception {

        if (multipartFile != null) {
            try {
                businessKeepsake.setImgPath(ResourceUtils.upload(request, multipartFile,
                        multipartFile.getOriginalFilename()));
            } catch (Exception e) {
                e.printStackTrace();
                return Result.fail("上传添加失败");
            }
        }
        String kid = CreateId.gitId();
        businessKeepsake.setKid(kid);
        businessKeepsake.setBid(businessKeepsake.getBid());
        businessKeepsake.setInfo(businessKeepsake.getInfo());
        try {
            int num = businessKeepsakeService.addKeepsakeByBid(businessKeepsake);
            if (num == 0) {
                return Result.fail(300, "添加失败,插入数据库失败");
            } else {
                return Result.success("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "系统错误");
        }
    }


    /*单个或批量删除纪念品*/
    @ResponseBody
    @RequestMapping("/deleteKeepsake.action")
    public Result deleteKeepsake(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") String ids)throws Exception
    {
        //批量删除
        if (ids == null || ids.equals("")){
            return Result.fail(300,"要删除的id不存在");
        }
        int delNum = businessKeepsakeService.deleteKeepsakeByKid(ids,request);
        if(delNum == 0){
            return Result.fail("删除失败");
        }else{
            return Result.success("删除成功");
        }

    }

}




