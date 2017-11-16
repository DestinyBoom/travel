package com.xawl.travel.dao;

import com.xawl.travel.pojo.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String uid);


    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll();
}