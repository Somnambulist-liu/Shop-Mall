package com.edu.shopapi.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.shopapi.entity.Category;
import com.edu.shopapi.service.CategoryService;
import com.edu.shopapi.vo.PageVo;
import com.edu.shopapi.vo.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 类别表(Category)表控制层
 *
 * @author makejava
 * @since 2023-12-05 23:36:11
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    /**
     * 服务对象
     */
    @Resource
    private CategoryService categoryService;

    @GetMapping("/all")
    public PageVo<Category> categoryList() {
        List<Category> categories = categoryService.queryAllCatregory();
        return new PageVo<>(categories);
    }
}

