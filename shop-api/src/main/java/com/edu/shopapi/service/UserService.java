package com.edu.shopapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.shopapi.entity.User;

/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
public interface UserService extends IService<User> {

    User queryUserByNameAndPassword(String name, String password);

    boolean queryUserByName(String name);

    boolean addUser(User user);
}

