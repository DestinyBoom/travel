package com.xawl.travel.controller;

import com.xawl.travel.pojo.BusinessCarousel;
import com.xawl.travel.service.BusinessCarouselService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.ImgUploadUtils;
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
/**
 *查询全部
 */
    @ResponseBody
    @RequestMapping("/findAll.action")
    public List<BusinessCarousel> findAll(HttpServletRequest request, HttpServletResponse response) {

        return businessCarouselService.findAll();
    }

    /**
     *通过bcid查询
     * @param request
     * @param response
     * @param bcid
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectByPrimaryKey.action")
    public BusinessCarousel selectByPrimaryKey(HttpServletRequest request, HttpServletResponse response, String bcid) {
       //System .out.println(name);
        return businessCarouselService.selectByPrimaryKey(bcid);
    }
    /**
     * 通过名称模糊查询
     *
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/findByName.action")
    public List<BusinessCarousel> findByName(HttpServletRequest request, HttpServletResponse response,BusinessCarousel name) {
        return businessCarouselService.findByName(name);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @param bcid
     * @return
     */
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

    /**
     * 插入
     * @param request
     * @param response
     * @param record
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertSelective.action")
    public Result insertSelective(HttpServletRequest request, HttpServletResponse response, BusinessCarousel record, MultipartFile file) throws Exception {
        String basePath = "/businessCarousel";  //保存的文件夹
        if(!file.isEmpty()){
            String bcid = CreateId.gitId();
            record.setBcid(bcid);
            record.setName(record.getName());
            record.setBid(record.getBid());
            record.setType(record.getType());
            record.setStatus(record.getStatus());
            record.setImgpath(ImgUploadUtils.upload(request,file,basePath));
        }else{
            return Result.fail("文件不存在");
        }
        try {
            int num = businessCarouselService.insertSelective(record);
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

    /**
     * 修改
     * @param request
     * @param response
     * @param record
     * @param file
     * @return
     */
   @ResponseBody
    @RequestMapping("/updateByPrimaryKeySelective.action")
    public Result updateByPrimaryKeySelective(HttpServletRequest request, HttpServletResponse response,BusinessCarousel record,MultipartFile file)throws Exception{

       if(file != null){
           String basePath = "/businessCarousel";  //保存的文件夹
           record = businessCarouselService.selectByPrimaryKey(record.getBcid());
           ImgUploadUtils.deleteFile(record.getImgpath());
           record.setImgpath(ImgUploadUtils.upload(request,file,basePath));
           }else{
               return Result.fail("文件不存在");
           }
       try {
           record.setBcid(record.getBcid());
           record.setName(record.getName());
           record.setBid(record.getBid());
           record.setType(record.getType());
           record.setStatus(record.getStatus());
           int num = businessCarouselService.updateByPrimaryKeySelective(record);
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

    @ResponseBody
    @RequestMapping("/updateByPrimaryKey.action")
    public int  updateByPrimaryKey(HttpServletRequest request, HttpServletResponse response,BusinessCarousel record){
        return businessCarouselService.updateByPrimaryKey(record);
    }

}

