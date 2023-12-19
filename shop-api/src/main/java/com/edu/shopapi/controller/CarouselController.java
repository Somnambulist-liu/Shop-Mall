package com.edu.shopapi.controller;



import com.edu.shopapi.entity.Carousel;
import com.edu.shopapi.service.CarouselService;
import com.edu.shopapi.vo.PageVo;
import com.edu.shopapi.vo.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 首页轮播图表(Carousel)表控制层
 *
 * @author makejava
 * @since 2023-12-05 23:36:09
 */
@RestController
@RequestMapping("carousel")
public class CarouselController {
    /**
     * 服务对象
     */
    @Resource
    private CarouselService carouselService;

    @GetMapping("/list")
    public PageVo<Carousel> queryAll() {
        List<Carousel> carousels = carouselService.queryAll();
        return new PageVo<>(carousels);
    }
}

