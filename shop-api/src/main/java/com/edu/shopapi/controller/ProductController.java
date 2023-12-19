package com.edu.shopapi.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.shopapi.entity.Product;
import com.edu.shopapi.service.ProductService;
import com.edu.shopapi.vo.PageVo;
import com.edu.shopapi.vo.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 商品表(Product)表控制层
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;
    @GetMapping("/search")
    public PageVo<Product> selectProduct(String product_name, Integer category_id, Integer pageIndex, Integer pageSize) {
//        log.info("商品名称："+product_name+"商品分类："+category_id+"当前页："+pageIndex+"每页显示："+pageSize);
        IPage page = productService.selectProduct(product_name, category_id, pageIndex, pageSize);
        //商品信息,当前页,总记录数
        //获取商品信息
        List<Product> productList = page.getRecords();
        //获取总记录数
        long total = page.getTotal();
        PageVo<Product> resultVo = new PageVo<>(200,true,"查询成功",productList,(int)total,pageIndex);
        return resultVo;
    }

    @GetMapping("/one")
    public Result productDetail(Integer product_id){
        Product product = productService.selectProductById(product_id);
        Result<Product> productResult = new Result<>();
        productResult.setCode(200);
        productResult.setSuccess(true);
        productResult.setMessage("查询成功");
        productResult.setData(product);
        return productResult;
    }
}

