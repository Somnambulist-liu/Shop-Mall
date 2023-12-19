package com.edu.shopapi.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 商品轮播图标(Photo)表实体类
 *
 * @author makejava
 * @since 2023-12-05 23:51:32
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Photo extends Model<Photo> {
    //图片ID
    @TableId
    private Integer photoId;
    //图片路径
    private String photoUrl;
    //商品编号
    private Integer productId;
}

