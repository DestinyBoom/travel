package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessImg;
import com.xawl.travel.service.BusinessImgService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.ImgUploadUtils;
import com.xawl.travel.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Created by Administrator on 2017/11/16.
 */

@Controller
@RequestMapping("/businessImg")
public class BusinessImgController {

    @Autowired
    private BusinessImgService businessImgService;

    /*通过商家id查询轮播图*/
    @ResponseBody
    @RequestMapping("/selectImgByBid.action")
    public Result selectImgByBid(String bid, @RequestParam(value = "pn") Integer pn) throws Exception {

        Result result = businessImgService.selectImgByBid(bid, pn);
        return result;
    }

    /*添加商家图片*/
    @ResponseBody
    @RequestMapping(value="/uploadBusinessImg.action",method=RequestMethod.POST)
    public Result uploadBusinessImg(HttpServletRequest request, BusinessImg businessImg ,
                                    @RequestParam(value="file",required=false) MultipartFile file)throws Exception{
            //图片上传
            String basePath = "/img/businessImg";  //保存的文件夹
            if(!file.isEmpty()){
                String imgPath = ImgUploadUtils.upload(request,file,basePath);
                String imgId = CreateId.gitId();
                businessImg.setImgid(imgId);
                businessImg.setBid(businessImg.getBid());
                businessImg.setImgPath(imgPath);
                businessImg.setCreateTime(new Date());
            }else{
                return Result.fail("文件不存在");
            }
            try {
                int rows = businessImgService.uploadImg(businessImg);
                if (rows == 0) {
                    return Result.fail(300, "添加失败,插入数据库失败");
                } else {
                    return Result.success("添加成功");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return Result.fail(500, "系统错误");
            }
    }


    /*单个或批量删除图片*/
     @ResponseBody
     @RequestMapping("/deleteImg.action")
     public Result deleteImg(HttpServletRequest request, @RequestParam("ids") String ids)throws Exception
     {
         //批量删除
        if (ids == null || ids.equals("")){
            return Result.fail(300,"要删除的id不存在");
        }
         int delCount = businessImgService.deleteImages(ids,request);
         if(delCount == 0){
             return Result.fail("删除失败");
         }else{
             return Result.success("删除成功");
         }

     }

}

