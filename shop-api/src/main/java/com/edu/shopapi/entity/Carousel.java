package com.edu.shopapi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 首页轮播图表(Carousel)表实体类
 *
 * @author makejava
 * @since 2023-12-05 23:51:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Carousel extends Model<Carousel> {
    //轮播ID
    @TableId
    private Integer carouselId;
    //轮播地址
    private String carouselUrl;
}

