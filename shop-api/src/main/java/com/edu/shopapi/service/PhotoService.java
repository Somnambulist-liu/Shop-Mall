package com.edu.shopapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.shopapi.entity.Photo;

import java.util.List;

/**
 * 商品轮播图标(Photo)表服务接口
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
public interface PhotoService extends IService<Photo> {

    List<Photo> queryAllPhoto(Integer productId);
}

