package com.edu.shopapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.shopapi.entity.Orders;

import java.util.List;

/**
 * 订单表(Orders)表服务接口
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
public interface OrdersService extends IService<Orders> {
    //生成订单
    boolean addOrder(Orders orders);
    //根据用户Id来查询订单
    List<Orders> queryOrderByUserId(Integer userId);

}

