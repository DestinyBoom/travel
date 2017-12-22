package com.xawl.travel.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xawl.travel.dao.UserMapper;
import com.xawl.travel.pojo.User;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zb on 2017/11/14.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    /*lzp*/

    /**
     * 查询全部
     * @return
     */
    /*public List<User> findAll() {
        return userMapper.findAll();
    }*/
    public Result findAll(Integer page) {
        PageHelper.startPage(page,7);
        List<User> list=userMapper.findByAccount(null);
        PageInfo pageInfo=new PageInfo(list);
        Result result=new Result();
        if(page<=pageInfo.getLastPage()){
            result.setStatus(200);
            result.setMsg("查询成功");
            result.setData(pageInfo);
        }else{
            result.setStatus(403);
            result.setMsg("没有记录数");
        }
        return result;
    }

    /**
     * 模糊查询用户
     * @param account
     * @return
     */
    public Result findByAccount(Integer page,User account){
        PageHelper.startPage(page,7);
        List<User> list=userMapper.findByAccount(account);
        PageInfo pageInfo=new PageInfo(list);
        Result result=new Result();
        if(page<=pageInfo.getLastPage()){
            result.setStatus(200);
            result.setMsg("查询成功");
            result.setData(pageInfo);
        }else{
            result.setStatus(403);
            result.setMsg("没有找到记录数");
        }
        return result ;
    }
    /*public Result findByAccount(User account){
        try{
            if(!userMapper.findByAccount(account).getUid().equals(0)){
                userMapper.findByAccount(account);
                return Result.success();
            }
            return Result.fail(403,"查询不到用户");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(403,"查询不到用户");
        }
    }*/

    /**
     * 停用
     */
    public Result updateUserDisable(String  uid){
        try{
            if(userMapper.selectByPrimaryKey(uid).getUid()!=null){
                userMapper.updateUserDisable(uid);
                return Result.success();
            }
            return Result.fail(403,"查询不到用户");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(403,"停用失败");
        }
    }

    /**
     * 复用
     */
    public Result updateUserAble(String  uid){
        try{
            if(userMapper.selectByPrimaryKey(uid).getUid()!=null){
                userMapper.updateUserAble(uid);
                return Result.success();
            }
            return Result.fail(403,"查询不到用户");
        }catch (Exception e){
            e.printStackTrace();
            return Result.fail(403,"复用失败");
        }
    }
}
