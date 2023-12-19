package com.edu.shopapi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * 订单表(Orders)表实体类
 *
 * @author makejava
 * @since 2023-12-05 23:51:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Orders extends Model<Orders> {
    //订单编号
    @TableId
    private String orderId;
    //购买的商品
    @TableField("products")
    //为了见名知意，我们将属性修改成了这个，但是和数据库列名不对应了，
    //因此需要添加这个注解来解决不对应的问题
    private String shopCarts;
    //临时属性
    @TableField(exist = false) //当前属性在表中不存在
    private List<Shopcart> shopcartList;
    //用户编号
    private Integer userId;
    //订单价格
    private String totalPrice;
    //下单时间
    private String createTime;
}

