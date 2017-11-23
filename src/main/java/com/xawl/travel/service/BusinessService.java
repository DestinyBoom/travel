package com.xawl.travel.service;

import com.xawl.travel.dao.BusinessMapper;
import com.xawl.travel.pojo.Business;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzp on 2017/11/15.
 */
@Service
public class BusinessService {
    @Autowired
    BusinessMapper businessMapper;

    /**
     * 查询全部
     * @return
     */
    public List<Business> findAll(){

        return businessMapper.findAll();
    }

    /**
     * 通过名称模糊查询
     * @param bname
     * @return
     */
   public List<Business> findByBname(Business bname) {
       /* try{
            businessMapper.findByBname(bname);
            return Result.success(bname);
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail(405,"没有相关的查询记录");
       }*/
       return businessMapper.findByBname(bname);
    }

    public Business selectByPrimaryKey(String bid){
        return businessMapper.selectByPrimaryKey(bid);
    }

    public Result insert(Business record){
        try {
            businessMapper.insert(record);
            return Result.success(record);
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(405,"注册失败");
        }
    }

    public Result insertSelective(Business record){
        try{
            businessMapper.insertSelective(record);
            return Result.success(record);
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail(405,"注册失败");
        }
    }

    public int updateByPrimaryKey(Business record){
        return  businessMapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(Business record){
        return businessMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 停用
     */
   /* public Result updateBusinessDisable(Business record){
        try{
            businessMapper.updateBusinessDisable(record);
            return Result.success("");
        }catch (Exception e){

        }
        return
    }*/
}
