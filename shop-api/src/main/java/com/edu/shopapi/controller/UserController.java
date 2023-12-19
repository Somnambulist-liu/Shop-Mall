package com.edu.shopapi.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.shopapi.dto.UserDto;
import com.edu.shopapi.entity.User;
import com.edu.shopapi.service.UserService;
import com.edu.shopapi.utils.TokenGenerator;
import com.edu.shopapi.vo.PageVo;
import com.edu.shopapi.vo.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    //用户登录方法
    @PostMapping("/login")
    public Result userLogin(@RequestBody User user){
        log.info("登录参数："+user);
        User user1 = userService.queryUserByNameAndPassword(user.getUsername(),user.getPassword());
        log.info("登录结果："+user1);

        UserDto userDto = new UserDto();
        if(user1!=null){
            userDto.setUid(user1.getUserId());
            userDto.setNickname(user1.getNickname());
            userDto.setToken(TokenGenerator.getMD5(user1.getUsername()));
            Result result = new Result(userDto);
            return result;
        }else{
            return new Result(200,"用户名或者密码错误", false);
        }
    }

    @GetMapping("/checkUserName")
    public Result checkUser(String userName) {
        boolean flag = userService.queryUserByName(userName);
        if (flag) {
            return Result.failure("用户名已存在");
        }
        else{
            return Result.failure("用户名不存在");
        }
    }

    @PostMapping("/register")
    public Result userRegister(@RequestBody User user){
        boolean flag = userService.addUser(user);
        if(flag){
            return Result.ok("注册成功");
        }else{
            return Result.failure("注册成功");
        }
    }
}

