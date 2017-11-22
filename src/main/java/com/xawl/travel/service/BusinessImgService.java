package com.xawl.travel.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.travel.dao.BusinessImgMapper;
import com.xawl.travel.pojo.BusinessImg;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/17.
 */

@Service
public class BusinessImgService {

    @Autowired
    private BusinessImgMapper businessImgMapper;

    /*查询商家图片*/
    public Result selectImgByBid(String bid, Integer pn, Integer num) {

        if(bid == null||bid ==""){
            return Result.fail(300, "请给出对应商家ID");
        }
        try {
            PageHelper.startPage(pn, num);
            List<BusinessImg> businessImgList = businessImgMapper.selectImgByBid(bid);
            PageInfo<BusinessImg> pageInfo = new PageInfo<BusinessImg>(businessImgList);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }

    }

     /*添加图片*/
    public int uploadImg(BusinessImg businessImg) {
        
       return businessImgMapper.insertSelective(businessImg);

    }

    /*删除图片*/
    public Result deleteImages(String ids,HttpServletRequest request) {

        List<String> img_ids = new ArrayList<String>();
        BusinessImg businessImg = new BusinessImg();
        String path1 = request.getSession().getServletContext().getRealPath("/");
        String [] str_ids = ids.split(",");
        for(String str : str_ids) {
            businessImg.setImgid(str);
            businessImg = businessImgMapper.selectByPrimaryKey(businessImg);
            img_ids.add(str);
            if(businessImg == null){
                return Result.fail("删除的图片不存在");
            }
            File image= new File(path1+businessImg.getImgPath());
            if(image.exists()){
                image.delete();
            }
        }
        businessImgMapper.deleteByPrimaryKey(ids);
        return Result.success("删除成功");
    }
}
