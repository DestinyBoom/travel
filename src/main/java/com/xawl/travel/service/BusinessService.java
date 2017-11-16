package com.xawl.travel.service;

import com.xawl.travel.dao.BusinessMapper;
import com.xawl.travel.pojo.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lzp on 2017/11/15.
 */
@Service
public class BusinessService {

    BusinessMapper businessMapper;

    public List<Business> findAll(){
        return businessMapper.findAll();
    }

    public Business selectByPrimaryKey(String bid){
        return businessMapper.selectByPrimaryKey(bid);
    }

    public int insert(Business record){
        return businessMapper.insert(record);
    }

    public int insertSelective(Business record){
        return businessMapper.insertSelective(record);
    }

    public int updateByPrimaryKey(Business record){
        return  businessMapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(Business record){
        return businessMapper.updateByPrimaryKeySelective(record);
    }
}
