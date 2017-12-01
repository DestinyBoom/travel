package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessCarousel;
import com.xawl.travel.service.BusinessCarouselService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.Result;
import com.xawl.travel.utils.UploadImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by zb on 2017/11/14.
 */
@Controller
@RequestMapping("/businessCarousel")
public class BusinessCarouselController {
    @Autowired
    public BusinessCarouselService businessCarouselService;

    @ResponseBody
    @RequestMapping("/findAll.action")
    public List<BusinessCarousel> findAll(HttpServletRequest request, HttpServletResponse response) {

        return businessCarouselService.findAll();
    }

    @ResponseBody
    @RequestMapping("/selectByPrimaryKey.action")
    public BusinessCarousel selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response, String bcid) {

        return businessCarouselService.selectByPrimaryKey(bcid);
    }

    @ResponseBody
    @RequestMapping("/deleteByPrimaryKey.action")
    public Result deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response, String bcid) {
        String ids = request.getParameter("bcid");
      /*  System.out.println(bcid);
        String msg;*/
        try {
            if (ids.length() != 0) {
                int rows = businessCarouselService.deleteByPrimaryKey(bcid);
                if (rows == 0) {
                    return Result.fail(300, "删除失败");
                } else {
                    return Result.success("删除成功");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "系统错误");
        }
        // Object s=request.getAttribute("msg");
        // System.out.println(s);
        // return businessCarouselService.findAll();
        return Result.fail(500, "系统错误");
    }

    @ResponseBody
    @RequestMapping("/insert.action")
    public int insert(HttpServletRequest request, HttpServletResponse response, BusinessCarousel record) {
        return businessCarouselService.insert(record);
    }

    @ResponseBody
    @RequestMapping("/insertSelective.action")
    public Result insertSelective(HttpServletRequest request, HttpServletResponse response, BusinessCarousel record, MultipartFile file) {
           /* String msg;
       if(record.getName() == null || record.getName().equals("")) {
            msg = "添加失败，数据名不能为空";
            request.setAttribute("msg", msg);
            Object s = request.getAttribute("msg");
            System.out.println(s);
            return businessCarouselService.findAll();
        }*/
        record.setBcid(CreateId.gitId());
        //record.setBid(new Business().getBid());
        //图片上传
        UploadImages uploadImage = new UploadImages();
        String path1 = request.getSession().getServletContext().getRealPath("/");  //上传的路径
        String path2 = "img/CarouselImages"; //保存的文件夹
        String bigImg = uploadImage.upLoadImage(request, file, path1, path2);
        if (!bigImg.contains(".")) {
            return Result.fail("未选择上传文件");
        }
       record.setImgpath(bigImg);
        try {
            int rows = businessCarouselService.insertSelective(record);
            if (rows == 0) {
                return Result.fail(300, "添加失败,插入数据库失败");
            } else {
                return Result.success("添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "系统错误");
        }
       /* Object s2 = request.getAttribute("msg");
        System.out.println(s2);
        return businessCarouselService.findAll();*/
    }

   @ResponseBody
    @RequestMapping("/updateByPrimaryKeySelective.action")
    public Result updateByPrimaryKeySelective(HttpServletRequest request, HttpServletResponse response,BusinessCarousel record, String bcid,MultipartFile file){

        //图片上传
        UploadImages uploadImage = new UploadImages();
        String path1 = request.getSession().getServletContext().getRealPath("/");  //上传的路径
        String path2 = "businessCarouselImages";  //保存的文件夹
        String bigImg = uploadImage.upLoadImage(request, file, path1, path2);
        if (!bigImg.contains(".")) {
            record.setImgpath(null);
        }else{
            BusinessCarousel record2 = new BusinessCarousel();
            record2 = businessCarouselService.selectByPrimaryKey(bcid);
            File image= new File(path1+record2.getImgpath());
            System.out.println(image);
           if(image.exists()){
               System.out.println(image);
               System.out.println(1);
                image.delete();
            }
            record.setImgpath(bigImg);
        }
       try {
           int rows = businessCarouselService.updateByPrimaryKeySelective(record);
           if (rows == 0) {
               return Result.fail(300, "修改失败");
           } else {
               return Result.success("修改成功");
           }
       } catch (Exception e) {
           e.printStackTrace();
           return Result.fail(500, "系统错误");
       }
       //return businessCarouselService.findAll();
    }
    @ResponseBody
    @RequestMapping("/updateByPrimaryKey.action")
    public int  updateByPrimaryKey(HttpServletRequest request, HttpServletResponse response,BusinessCarousel record){
        return businessCarouselService.updateByPrimaryKey(record);
    }

}

