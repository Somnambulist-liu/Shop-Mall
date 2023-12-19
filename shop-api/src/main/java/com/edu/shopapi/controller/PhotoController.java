package com.edu.shopapi.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.shopapi.entity.Photo;
import com.edu.shopapi.service.PhotoService;
import com.edu.shopapi.vo.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品轮播图标(Photo)表控制层
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@RestController
@RequestMapping("photo")
public class PhotoController {
    /**
     * 服务对象
     */
    @Resource
    private PhotoService photoService;


    @GetMapping("/getPhotos")
    public Result getAllPhoto(Integer product_id){
        List<Photo> photos = photoService.queryAllPhoto(product_id);
        return new Result(photos);
    }
}

