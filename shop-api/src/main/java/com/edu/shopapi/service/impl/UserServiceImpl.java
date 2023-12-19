package com.edu.shopapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.shopapi.dao.UserDao;
import com.edu.shopapi.entity.User;
import com.edu.shopapi.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",name);
        queryWrapper.eq("password",password);
        return userDao.selectOne(queryWrapper);
    }
    @Override
    public boolean queryUserByName(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",name);
        User user =userDao.selectOne(queryWrapper);
        return user!=null?true:false;
    }

    @Override
    public boolean addUser(User user) {
        int i = userDao.insert(user);
        return i>0;
    }
}

