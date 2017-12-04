package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessKeepsake;
import com.xawl.travel.service.BusinessKeepsakeService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.ImgUploadUtils;
import com.xawl.travel.utils.ResourceUtils;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Result findKeepsakeByBid(String bid, @RequestParam(value = "pn") Integer pn) throws Exception {

        Result result = businessKeepsakeService.findKeepsakeByBid(bid, pn);
        return result;
    }


    /*添加纪念品相关*/
    @ResponseBody
    @RequestMapping(value="/addKeepsake.action",method= RequestMethod.POST)
    public Result addKeepsake(HttpServletRequest request, BusinessKeepsake businessKeepsake,
                              @RequestParam(value="file",required=false) MultipartFile multipartFile) throws Exception {

        String basePath = "/travel/businessImg";  //保存的文件夹
        if(!multipartFile.isEmpty()){
            String kid = CreateId.gitId();
            businessKeepsake.setKid(kid);
            businessKeepsake.setBid(businessKeepsake.getBid());
            businessKeepsake.setInfo(businessKeepsake.getInfo());
            businessKeepsake.setImgPath(ImgUploadUtils.upload(request,multipartFile,basePath));
        }else{
            return Result.fail("文件不存在");
        }
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
    public Result deleteKeepsake(HttpServletRequest request, @RequestParam("ids") String ids)throws Exception
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


    @ResponseBody
    @RequestMapping("/updateKeepsake.action")
    public Result updateKeepsake(HttpServletRequest request, BusinessKeepsake businessKeepsake,
                                 MultipartFile multipartFile) throws Exception {
        if(multipartFile != null){
            String basePath = "/travel/businessImg";  //保存的文件夹
            businessKeepsake = businessKeepsakeService.selectKeepsakeByKid(businessKeepsake.getKid());
            ImgUploadUtils.deleteFile(businessKeepsake.getImgPath());
            businessKeepsake.setImgPath(ImgUploadUtils.upload(request,multipartFile,basePath));
        }else{
            return Result.fail("修改失败，文件不存在");
        }
        try {
            businessKeepsake.setKid(businessKeepsake.getKid());
            businessKeepsake.setBid(businessKeepsake.getBid());
            businessKeepsake.setInfo(businessKeepsake.getInfo());
            int num = businessKeepsakeService.updateKeepsakeByKid(businessKeepsake);
            if (num == 0) {
                return Result.fail(300, "修改失败,插入数据库失败");
            } else {
                return Result.success("修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "系统错误");
        }
    }

}




