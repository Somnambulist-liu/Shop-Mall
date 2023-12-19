package com.edu.shopapi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户表(User)表实体类
 *
 * @author makejava
 * @since 2023-12-05 23:51:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {
    //用户ID
    @TableId
    private Integer userId;
    //账号
    private String username;
    //密码
    private String password;
    //昵称
    private String nickname;
}

