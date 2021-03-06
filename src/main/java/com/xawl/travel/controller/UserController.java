package com.xawl.travel.controller;
import com.xawl.travel.pojo.User;
import com.xawl.travel.service.UserService;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAll.action")
   /* public List<User> findAll(HttpServletRequest request, HttpServletResponse response){
        return userService.findAll();
    }*/
    public Result findAll(@RequestParam(value="page",defaultValue="1")Integer page){
        return userService.findAll(page);
    }

    /**
     * 模糊查询用户名
     */
     @ResponseBody
     @RequestMapping("/findByAccount.action")
     public Result findByAccount(@RequestParam(value="page",defaultValue="1")Integer page,User account){
         return userService.findByAccount(page,account);
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
    public Result updateUserDisable(String uid){
        return userService.updateUserDisable(uid);
    }

    /**
     * 复用
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUserAble.action")
    public Result updateUserAble(String uid){
        return userService.updateUserAble(uid);
    }
}

