package com.edu.shopapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.shopapi.entity.Carousel;

import java.util.List;

/**
 * 首页轮播图表(Carousel)表服务接口
 *
 * @author makejava
 * @since 2023-12-05 23:36:11
 */
public interface CarouselService extends IService<Carousel> {

    List<Carousel> queryAll();
}

