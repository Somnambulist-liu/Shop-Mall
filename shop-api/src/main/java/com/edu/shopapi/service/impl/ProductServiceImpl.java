package com.edu.shopapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.shopapi.dao.ProductDao;
import com.edu.shopapi.entity.Product;
import com.edu.shopapi.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * 商品表(Product)表服务实现类
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Service("productService")
public class ProductServiceImpl extends ServiceImpl<ProductDao, Product> implements ProductService {
    //注入ProductDao
    @Resource
    private ProductDao productDao;
    @Override
    public IPage selectProduct(String productName, Integer categoryId, int pageNum, int pageSize) {
        //创建分页对象
        IPage<Product> page = new Page<>(pageNum,pageSize);
        //分页查询
        QueryWrapper qr = new QueryWrapper();
        qr.eq(categoryId!=null&&categoryId!=0,"category_id",categoryId);
        qr.like(productName!=null&&productName!="","product_name",productName);
        productDao.selectPage(page,qr);
        return page;
    }

    @Override
    public Product selectProductById(Integer productId) {
        QueryWrapper qr = new QueryWrapper();
        qr.eq("product_id",productId);
        return productDao.selectOne(qr);
    }

}

