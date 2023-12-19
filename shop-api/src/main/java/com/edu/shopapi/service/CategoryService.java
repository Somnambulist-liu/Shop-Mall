package com.edu.shopapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.shopapi.entity.Category;

import java.util.List;

/**
 * 类别表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
public interface CategoryService extends IService<Category> {

    List<Category> queryAllCatregory();
}

