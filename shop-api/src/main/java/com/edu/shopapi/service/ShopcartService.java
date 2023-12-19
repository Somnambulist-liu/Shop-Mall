package com.edu.shopapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.shopapi.entity.Shopcart;

import java.util.List;

/**
 * 购物车表(Shopcart)表服务接口
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
public interface ShopcartService extends IService<Shopcart> {
    boolean findShopCartByUserIdAndProductId(Integer userId, Integer productId);

    Shopcart findShopCartsByUserIdAndProductId(Integer userId, Integer productId);

    boolean updateShopCart(Integer userId,Integer productId);

    //通过ids批量删除购物车商品信息
    public boolean deleteShopCartBatch(String ids);

    //根据用户id和商品ids查询购物车信息
    public List<Shopcart> queryShopCartByUserIdAndProductIds(Integer userId, String ids);

    //接口
    //根据用户id车查询购物车信息
    List<Shopcart> queryShopCartByUserId(Integer userId);

    public boolean updateShopCart(Integer userId,Integer productId,Integer num);

    //根据用户id，商品id删除购物车商品信息
    public boolean deleteShopCart(Integer pid,Integer uid);
}

