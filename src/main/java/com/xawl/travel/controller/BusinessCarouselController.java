package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessCarousel;
import com.xawl.travel.service.BusinessCarouselService;
import com.xawl.travel.utils.UploadImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        System.out.println(businessCarouselService.findAll());
        return businessCarouselService.findAll();
    }

    @ResponseBody
    @RequestMapping("/selectByPrimaryKey.action")
    public BusinessCarousel selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response, String bcid) {
        //System.out.println(bcid);
        //System.out.println(businessCarouselService.selectByPrimaryKey);
        return businessCarouselService.selectByPrimaryKey(bcid);
    }

    @ResponseBody
    @RequestMapping("/deleteByPrimaryKey.action")
    public List<BusinessCarousel> deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response, String bcid) {
        String ids = request.getParameter("bcid");
        System.out.println(bcid);
        String msg;
        if (ids.length() != 0) {
            int rows = businessCarouselService.deleteByPrimaryKey(bcid);
            if (rows == 0) {
                msg = "删除失败,此id不存在";
                request.setAttribute("msg", msg);
            } else {
                msg = "删除成功";
                request.setAttribute("msg", msg);
            }
            // Object s=request.getAttribute("msg");
            // System.out.println(s);
        }
        return businessCarouselService.findAll();
    }

    @ResponseBody
    @RequestMapping("/insert.action")
    public int insert(HttpServletRequest request, HttpServletResponse response, BusinessCarousel record) {
        return businessCarouselService.insert(record);
    }

    @ResponseBody
    @RequestMapping("/insertSelective.action")
    public List<BusinessCarousel> insertSelective(HttpServletRequest request, HttpServletResponse response, BusinessCarousel record, MultipartFile file) {
            String msg;
       if(record.getName() == null || record.getName().equals("")) {
            msg = "添加失败，数据名不能为空";
            request.setAttribute("msg", msg);
            Object s = request.getAttribute("msg");
            System.out.println(s);
            return businessCarouselService.findAll();
        }
        //图片上传
        UploadImages uploadImage = new UploadImages();
        String path1 = request.getSession().getServletContext().getRealPath("/");  //上传的路径
        String path2 = "businessCarouselImages";  //保存的文件夹
        String bigImg = uploadImage.upLoadImage(request, file, path1, path2);
        if (!bigImg.contains(".")) {
            msg = "未选择文件";
            request.setAttribute("msg", msg);
            Object s1 = request.getAttribute("msg");
            System.out.println(s1);
        }
       record.setImgpath("bigImg");
        try {
            int rows = businessCarouselService.insertSelective(record);
            if (rows == 0) {
                msg = "添加失败,插入数据库失败";
                request.setAttribute("msg", msg);
            } else {
                msg = "添加成功";
                request.setAttribute("msg", msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "添加失败,服务器异常";
            request.setAttribute("msg", msg);
        }
        Object s2 = request.getAttribute("msg");
        System.out.println(s2);
        return businessCarouselService.findAll();
    }

    /*
    @ResponseBodyt
    @RequestMapping("/updateByPrimaryKeySelective.action")
    public String  updateByPrimaryKeySelective(HttpServletRequest request, HttpServletResponse response,BusinessCarousel record){
        String msg;
        if(record.getName()==null||record.getName().equals("")){
            msg="修改失败，数据名不能为空";
            request.setAttribute("msg",msg);
           return businessCarouselService.findAll();
        }
        //图片上传
        UploadImages uploadImage = new UploadImages();
        String path1 = request.getSession().getServletContext().getRealPath("/");  //上传的路径
        String path2 = "businessCarouselImages";  //保存的文件夹
        String bigImg = uploadImage.upLoadImage(request, file, path1, path2);
        if(!bigImg.contains(".")){
        	 record.setImgpath(null);
        }else{
        	BusinessCarousel businessCarousel2 = new BusinessCarousel();
        	businessCarousel2 = BusinessCarousellService.SelectCarouselByCaid(businessCarousel);
        	File image= new File(path1+carousel2.getImgpath());
        	System.out.println(image);
        	if(image.exists()){
        		image.delete();
        	}
        	carousel.setImgpath(bigImg);
        }
        try {
        	int rows = BusinessCarousellService.updateBusinessCarousel(carousel);
        	if(rows == 0){
        		msg="修改失败,注入数据库失败";
                request.setAttribute("msg", msg);
        	}else{
        		msg="修改成功";
                request.setAttribute("msg", msg);
        	}
        } catch (Exception e) {
            e.printStackTrace();
            msg="修改失败,服务器异常";
            request.setAttribute("msg", msg);
        }
        return businessCarouselService.findAll();
    }
    @ResponseBody
    @RequestMapping("/updateByPrimaryKey.action")
    public int  updateByPrimaryKey(HttpServletRequest request, HttpServletResponse response,BusinessCarousel record){
        return businessCarouselService.updateByPrimaryKey(record);
    }
*/
}

