package com.edu.shopapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.shopapi.dao.ShopcartDao;
import com.edu.shopapi.entity.Product;
import com.edu.shopapi.entity.Shopcart;
import com.edu.shopapi.service.ProductService;
import com.edu.shopapi.service.ShopcartService;
import jakarta.annotation.Resource;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 购物车表(Shopcart)表服务实现类
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Service("shopcartService")
@Slf4j
public class ShopcartServiceImpl extends ServiceImpl<ShopcartDao, Shopcart> implements ShopcartService {
    @Resource
    private ShopcartDao shopcartDao;
    @Resource
    private ProductService productService;
    @Override
    public boolean findShopCartByUserIdAndProductId(Integer userId, Integer productId) {
        List<Shopcart> list = null;
        if (userId!= null && productId!= null) {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("user_id", userId);
            qw.eq("product_id", productId);
            list = shopcartDao.selectList(qw);
        }
        if (list!= null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Shopcart findShopCartsByUserIdAndProductId(Integer userId, Integer productId) {
        Shopcart shopcart = null;
        if (userId!= null && productId!= null) {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("user_id", userId);
            qw.eq("product_id", productId);
            shopcart = shopcartDao.selectOne(qw);
        }
        return shopcart;
    }

    @Override
    public boolean updateShopCart(Integer userId, Integer productId) {
        if (userId!= null && productId!= null) {
            //获取购物车中原有商品数量
            Shopcart shopcart = findShopCartsByUserIdAndProductId(userId, productId);
            if (shopcart!= null) {
                shopcart.setNum(shopcart.getNum()+1);
                shopcartDao.updateById(shopcart);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteShopCartBatch(String ids) {
        QueryWrapper qw = new QueryWrapper();
        String[] pids = ids.split(",");
        qw.in("product_id",pids);
        return shopcartDao.delete(qw)>0;
    }

    @Override
    public List<Shopcart> queryShopCartByUserIdAndProductIds(Integer userId, String ids) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        qw.in("product_id", ids.split(","));
        List<Shopcart> shopcartList = shopcartDao.selectList(qw);
        //给购物车中的商品属性product赋值
        for (Shopcart shopcart : shopcartList) {
            Product product = productService.selectProductById(shopcart.getProductId());
            shopcart.setProduct(product);
        }
        return shopcartList;
    }

    @Override
    public List<Shopcart> queryShopCartByUserId(Integer userId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("user_id", userId);
        List<Shopcart> shopcartList = shopcartDao.selectList(qw);
        //当前这个shopcartList集合中的product属性还是为空的,需要我们将该属性赋值,
        //根据商品id查询商品信息，然后赋值就可以了。
        for (Shopcart shopcart : shopcartList) {
            log.info("shopcart.getProductId() = " + shopcart.getProductId());
            Product product = productService.selectProductById(shopcart.getProductId());
            shopcart.setProduct(product);
        }
        return shopcartList;
    }

    @Override
    public boolean updateShopCart(Integer userId, Integer productId, Integer num) {
        if (userId!= null && productId!= null) {
            //获取购物车中原有商品数量
            Shopcart shopcart = findShopCartsByUserIdAndProductId(userId, productId);
            if (shopcart!= null) {
                shopcart.setNum(num);
                shopcartDao.update(shopcart, new QueryWrapper<Shopcart>().eq("user_id", userId).eq("product_id", productId));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteShopCart(Integer pid, Integer uid) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("product_id",pid);
        qw.eq("user_id",uid);
        return shopcartDao.delete(qw)>0;
    }

}

