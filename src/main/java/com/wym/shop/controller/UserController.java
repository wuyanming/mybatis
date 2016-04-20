package com.wym.shop.controller;

import com.wym.shop.entity.User;
import com.wym.shop.service.UserService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * Created by Administrator on 2016/4/20.
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value="user/{id}")
    public User gerUser(
            @PathParam(value = "id")Integer id
    ){
        User user=userService.getUser(1);
        System.out.println(user);
        return  user;
    }

    @RequestMapping(value="user")
    public String gerUser(
            ModelMap modelMap
    ){
        User user=userService.getUser(1);
        modelMap.addAttribute("user", user);
        return  "user";
    }
}
