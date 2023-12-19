package com.edu.shopapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.shopapi.dao.OrdersDao;
import com.edu.shopapi.entity.Orders;
import com.edu.shopapi.entity.Shopcart;
import com.edu.shopapi.service.OrdersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单表(Orders)表服务实现类
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Service("ordersService")
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, Orders> implements OrdersService {

    @Resource
    private OrdersDao ordersDao;
    @Override
    public boolean addOrder(Orders orders) {
        return ordersDao.insert(orders)>0;
    }

    @Override
    public List<Orders> queryOrderByUserId(Integer userId) {
        List<Orders> ordersList = null;
        try {
            QueryWrapper qw = new QueryWrapper();
            qw.eq("user_id", userId);
            ordersList= ordersDao.selectList(qw);
            //遍历orderList,给Orders中productList属性赋值
            for (Orders orders : ordersList) {
                String shopCarts = orders.getShopCarts();
                //将products字符串转换成List<Product>
                ObjectMapper om = new ObjectMapper();

                List<Shopcart> list = om.readValue(shopCarts, List.class);
                orders.setShopcartList(list);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ordersList;
    }
}

