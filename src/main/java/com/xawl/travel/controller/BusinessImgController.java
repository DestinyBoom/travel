package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessImg;
import com.xawl.travel.service.BusinessImgService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.Result;
import com.xawl.travel.utils.UploadImages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


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
    public Result selectImgByBid(String bid, @RequestParam(value = "pn", defaultValue = "1") Integer pn) throws Exception {

        Result result = businessImgService.selectImgByBid(bid, pn);
        return result;
    }

    /*添加商家图片*/
    @ResponseBody
    @RequestMapping(value="/uploadBusinessImg.action",method=RequestMethod.POST)
    public Result uploadBusinessImg(HttpServletRequest request, BusinessImg businessImg ,
                                    @RequestParam(value="file",required=false) MultipartFile file)throws Exception{

            //图片上传
            //获得物理路径webapp所在路径
            String pathRoot = request.getSession().getServletContext().getRealPath("");
            String imgPath="";
            if(!file.isEmpty()){
                //生成uuid作为文件名称
                String uuid = UUID.randomUUID().toString().replaceAll("-","");
                //获得文件类型（可以判断如果不是图片，禁止上传）
                String contentType=file.getContentType();
                //获得文件后缀名称
                String path = pathRoot+"/img/businessImg/";
                String imageName=contentType.substring(contentType.indexOf("/")+1);
                imgPath="/img/businessImg/"+uuid+"."+imageName;
                SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM");
                File tfile = new File(path+sm.format(new Date())+"/");
                if (!tfile.exists()) {
                    tfile.mkdirs();
                }
                file.transferTo(new File(pathRoot+imgPath));
            }
                String imgId = CreateId.gitId();
                businessImg.setImgid(imgId);
                businessImg.setBid(businessImg.getBid());
                businessImg.setImgPath(imgPath);
                businessImg.setCreateTime(new Date());
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

        /*UploadImages uploadImage = new UploadImages();
        String path1 = request.getSession().getServletContext().getRealPath("/");  //上传的路径
        String path2 = "img\\businessImg";  //保存的文件夹
        System.out.println(path1+path2);
        String imgPath = uploadImage.upLoadImage(request, file, path1, path2);
        if (!imgPath.contains(".")) {
            return Result.fail("未选择上传文件");
        }*/
       /* String imgId = CreateId.gitId();
        businessImg.setImgid(imgId);
        businessImg.setBid(businessImg.getBid());
        businessImg.setImgPath(imgPath);
        businessImg.setCreateTime(new Date());

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
        }*/


    /*单个或批量删除图片*/
     @ResponseBody
     @RequestMapping("/deleteImg.action")
     public Result deleteImg(HttpServletRequest request, HttpServletResponse response, @RequestParam("ids") String ids)throws Exception
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

