package com.xawl.travel.service;

import com.xawl.travel.dao.UserMapper;
import com.xawl.travel.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zb on 2017/11/14.
 */
@Service
public class UserService {

    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }
}
