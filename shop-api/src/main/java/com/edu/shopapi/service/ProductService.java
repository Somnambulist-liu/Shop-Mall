package com.edu.shopapi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.shopapi.entity.Product;

/**
 * 商品表(Product)表服务接口
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
public interface ProductService extends IService<Product> {

    IPage selectProduct(String productName, Integer categoryId, int pageNum, int pageSize);

    Product selectProductById(Integer productId);
}

