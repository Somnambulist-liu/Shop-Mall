package com.edu.shopapi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 购物车表(Shopcart)表实体类
 *
 * @author makejava
 * @since 2023-12-05 23:51:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Shopcart extends Model<Shopcart> {
    //购物车ID
    @TableId
    private Integer shopcartId;
    //商品ID
    private Integer productId;
    @TableField(exist = false)
    private Product product;
    //用户编号
    private Integer userId;
    //商品数量
    private Integer num;
}

