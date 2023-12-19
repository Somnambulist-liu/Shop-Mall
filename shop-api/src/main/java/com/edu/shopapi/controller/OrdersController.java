package com.edu.shopapi.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.shopapi.dto.OrderComm;
import com.edu.shopapi.entity.Orders;
import com.edu.shopapi.entity.Shopcart;
import com.edu.shopapi.service.OrdersService;
import com.edu.shopapi.service.ShopcartService;
import com.edu.shopapi.vo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单表(Orders)表控制层
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Slf4j
@RestController
@RequestMapping("orders")
public class OrdersController {
    /**
     * 服务对象
     */
    @Resource
    private OrdersService ordersService;
    @Resource
    private ShopcartService shopCartService;

    @GetMapping("/add")
    public void addOrder(HttpSession session, HttpServletResponse resp) throws IOException {
        OrderComm oc = (OrderComm)session.getAttribute("oc");
        log.info("订单封装的信息:"+oc);
        //获取购物车中结算的商品信息
        List<Shopcart> shopCartList = shopCartService.queryShopCartByUserIdAndProductIds(oc.getUserId(),oc.getIds());
        //将商品信息转换为json字符串
        ObjectMapper om = new ObjectMapper();
        String shopCarts = om.writeValueAsString(shopCartList);
        Orders orders = new Orders();
        orders.setOrderId(oc.getOrderNo());
        orders.setShopCarts(shopCarts);
        orders.setUserId(oc.getUserId());
        orders.setTotalPrice(String.valueOf(oc.getTotalPrice()));
        orders.setCreateTime(LocalDateTime.now().toString());
        ordersService.addOrder(orders);
        //将购物车中结算的商品删除
        shopCartService.deleteShopCartBatch(oc.getIds());
        //重定向-->前端的首页
        resp.sendRedirect("http://localhost:5173");
    }

    @GetMapping("/getUserOrder")
    public Result queryOrders(Integer user_id){
        List<Orders> ordersList = ordersService.queryOrderByUserId(user_id);
        return new Result(ordersList);
    }
}

