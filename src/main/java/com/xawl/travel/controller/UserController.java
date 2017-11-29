package com.xawl.travel.controller;
import com.xawl.travel.pojo.User;
import com.xawl.travel.service.UserService;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zb on 2017/11/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询全部
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll.action")
   /* public List<User> findAll(HttpServletRequest request, HttpServletResponse response){
        return userService.findAll();
    }*/
    public Result findAll(Integer page,HttpServletRequest request, HttpServletResponse response){
        return userService.findAll(page);
    }

    /**
     * 模糊查询用户名
     */
     @ResponseBody
     @RequestMapping("/findByAccount.action")
     public List<User> findByAccount(User account){
         return userService.findByAccount(account);
     }
    /*@ResponseBody
    @RequestMapping("/findByAccount.action")
    public Result findByAccount(User account){
        return userService.findByAccount(account);
    }*/

    /**
     * 停用
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUserDisable.action")
    public Result updateUserDisable(User uid){
        return userService.updateUserDisable(uid);
    }

    /**
     * 复用
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUserAble.action")
    public Result updateUserAble(User uid){
        return userService.updateUserAble(uid);
    }
}

