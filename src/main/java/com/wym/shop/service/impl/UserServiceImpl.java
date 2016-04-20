package com.wym.shop.service.impl;

import com.wym.shop.dao.UserDao;
import com.wym.shop.entity.User;
import com.wym.shop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/4/20.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUser(Integer id) {

        User user=userDao.getUserById(id);
        return user;
    }
}
