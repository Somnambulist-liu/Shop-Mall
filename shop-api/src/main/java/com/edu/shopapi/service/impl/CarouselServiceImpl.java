package com.edu.shopapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.shopapi.dao.CarouselDao;
import com.edu.shopapi.entity.Carousel;
import com.edu.shopapi.service.CarouselService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页轮播图表(Carousel)表服务实现类
 *
 * @author makejava
 * @since 2023-12-05 23:36:11
 */
@Service("carouselService")
public class CarouselServiceImpl extends ServiceImpl<CarouselDao, Carousel> implements CarouselService {

    @Resource
    private CarouselDao carouselDao;
    @Override
    public List<Carousel> queryAll() {
        List<Carousel> carousels =carouselDao.selectList(null);
        return carousels;
    }
}

