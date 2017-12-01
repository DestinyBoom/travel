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

    /*lzp*/
    List<User> findAll();

    List<User> findByAccount(User account);
    /* User findByAccount(User account);*/
    /*int selectByUid(User uid);*/

    int updateUserDisable(String uid);

    int updateUserAble(String uid);

}