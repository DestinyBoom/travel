
package com.xawl.travel.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.travel.dao.BusinessKeepsakeMapper;
import com.xawl.travel.pojo.BusinessKeepsake;
import com.xawl.travel.utils.DefaultParam;
import com.xawl.travel.utils.ResourceUtils;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by Administrator on 2017/11/22.
 */


@Service
public class BusinessKeepsakeService {

    @Autowired
    private BusinessKeepsakeMapper businessKeepsakeMapper;

    public Result findKeepsakeByBid(String bid, Integer pn) {
        if (bid == null || bid == "") {
            return Result.fail(300, "请给出对应商家ID");
        }
        try {
            PageHelper.startPage(pn, DefaultParam.pageNum);
            List<BusinessKeepsake> businessKeepsakeList = businessKeepsakeMapper.selectKeepsakeByBid(bid);
            PageInfo<BusinessKeepsake> pageInfo = new PageInfo<BusinessKeepsake>(businessKeepsakeList);
            return Result.success(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }
    }

    public BusinessKeepsake selectKeepsakeByKid(String kid) {
        if (kid == null || kid == "") {
            return null;
        }
        try {
            BusinessKeepsake businessKeepsake = businessKeepsakeMapper.selectByPrimaryKey(kid);
            return businessKeepsake;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public int addKeepsakeByBid(BusinessKeepsake businessKeepsake) {

        return businessKeepsakeMapper.insertSelective(businessKeepsake);
    }

    public int deleteKeepsakeByKid(String ids, HttpServletRequest request) {

        String[] kids = ids.split(",");
        for (String kid : kids) {
            BusinessKeepsake businessKeepsake = businessKeepsakeMapper.selectByPrimaryKey(kid);
            if (businessKeepsake == null) {
                return 0;
            }
            try {
                ResourceUtils.deleteResource(businessKeepsake.getImgPath(), request);
            } catch (Exception e) {
                return 0;
            }

        }
        return businessKeepsakeMapper.deleteKeepsakeByKid(kids);
    }


    public int updateKeepsakeByKid(BusinessKeepsake businessKeepsake) {

        return businessKeepsakeMapper.updateByPrimaryKeySelective(businessKeepsake);
    }
}


