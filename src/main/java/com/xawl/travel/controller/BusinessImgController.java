package com.xawl.travel.controller;

import com.sun.deploy.net.HttpResponse;
import com.xawl.travel.service.BusinessImgService;
import com.xawl.travel.utils.Result;
import com.xawl.travel.utils.UploadImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    public Result selectImgByBid(String bid) {
        Result result = businessImgService.selectImgByBid(bid);
        return result;
    }

   /* @ResponseBody
    @RequestMapping("/uploadImg.action")
    public String uploadImg(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file) throws Exception {

        //图片上传
        UploadImages uploadImage = new UploadImages();
        String path1 = request.getSession().getServletContext().getRealPath("/");  //上传的路径
        String path2 = "upload/BusinessImg";  //保存的文件夹
        String bigImg = uploadImage.upLoadImage(request, file, path1, path2);
        if(!bigImg.contains(".")){
            msg="未选择文件";
            request.setAttribute("msg", msg);
        }
        carousel.setValue(bigImg);
        try {
            int rows = carouselService.insertCarousel(carousel);
            if(rows == 0){
                msg="添加失败,插入数据库失败";
                request.setAttribute("msg", msg);
            }else{
                msg="添加成功";
                request.setAttribute("msg", msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg="添加失败,服务器异常";
            request.setAttribute("msg", msg);
        }

        ServletContext sc = request.getSession().getServletContext();
        String dir = sc.getRealPath("/upload");
        String type = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1, file.getOriginalFilename().length());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        String imgName = "";
        if (type.equals("jpg")) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpg";
        } else if (type.equals("png")) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".png";
        } else if (type.equals("jpeg")) {
            imgName = sdf.format(new Date()) + r.nextInt(100) + ".jpeg";
        } else {
            return null;
        }
        FileUtils.writeByteArrayToFile(new File(dir, imgName), file.getBytes());
        //返回图片的url，结合前端js回调实现上传并回显的功能
        response.getWriter().print("upload/" + imgName);
        return null;
    }*/


}
