package com.edu.shopapi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品表(Product)表实体类
 *
 * @author makejava
 * @since 2023-12-05 23:51:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Product extends Model<Product> {
    //商品编号
    @TableId
    private Integer productId;
    //商品名称
    private String productName;
    //商品简介
    private String productTitle;
    //商品详细介绍
    private String productIntro;
    //商品价格
    private Double productPrice;
    //商品售价
    private Double productSellPrice;
    //商品图片
    private String productPic;
    //商品类别
    private Integer categoryId;
}

