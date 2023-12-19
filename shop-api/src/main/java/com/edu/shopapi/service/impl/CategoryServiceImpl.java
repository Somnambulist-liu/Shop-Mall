package com.edu.shopapi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.shopapi.dao.CategoryDao;
import com.edu.shopapi.entity.Category;
import com.edu.shopapi.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类别表(Category)表服务实现类
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, Category> implements CategoryService {
   @Resource
    private CategoryDao categoryDao;
    @Override
    public List<Category> queryAllCatregory() {
        List<Category> categoryList = categoryDao.selectList(null);
        return categoryList;
    }
}

