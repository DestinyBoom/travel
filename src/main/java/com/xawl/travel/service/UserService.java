package com.xawl.travel.service;

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
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 模糊查询用户
     * @param account
     * @return
     */
    public List<User> findByAccount(User account){
        return userMapper.findByAccount(account);
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
    public Result updateUserDisable(User  uid){
        try{
            if(userMapper.selectByUid(uid)!=0){
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
    public Result updateUserAble(User  uid){
        try{
            if(userMapper.selectByUid(uid)!=0){
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
