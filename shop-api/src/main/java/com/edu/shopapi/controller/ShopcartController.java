package com.edu.shopapi.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.shopapi.entity.Shopcart;
import com.edu.shopapi.service.ShopcartService;
import com.edu.shopapi.vo.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 购物车表(Shopcart)表控制层
 *
 * @author makejava
 * @since 2023-12-05 23:36:12
 */
@Slf4j
@RestController
@RequestMapping("shoppingcart")
public class ShopcartController {
    /**
     * 服务对象
     */
    @Resource
    private ShopcartService shopcartService;

    @PostMapping("/add")
    public Result addShopCart(@RequestBody Shopcart shopcart) {
        boolean flag = shopcartService.save(shopcart);
        Result rv = new Result();
        if (flag) {
            rv.setSuccess(true);
            rv.setMessage("添加成功");
            rv.setCode(200);
        } else {
            rv.setSuccess(false);
            rv.setMessage("添加失败");
            rv.setCode(200);
        }
        return rv;
    }

    @GetMapping("/one")
    public Result checkShopCart(Integer user_id, Integer product_id) {
        boolean flag = shopcartService.findShopCartByUserIdAndProductId(user_id, product_id);
        Result rv = new Result();
        if (flag) {
            rv.setSuccess(true);
            rv.setMessage("购物车中已存在该商品");
            rv.setCode(200);
        } else {
            rv.setSuccess(false);
            rv.setMessage("购物车中不存在该商品");
            rv.setCode(200);
        }
        return rv;
    }


    @PutMapping("/update")
    public Result updateShopCart(@RequestBody Map<String,Integer> map){
        log.info("购物车更新的信息:"+map);
        //获取用户id，商品id
        Integer userId = map.get("user_id");
        Integer productId = map.get("product_id");
        boolean flag = shopcartService.updateShopCart(userId, productId);
        Result rv = new Result();
        if(flag){
            //true
            rv.setCode(200);
            rv.setSuccess(true);
            rv.setMessage("购物车商品数量更新成功");
        }else{
            rv.setSuccess(false);
            rv.setMessage("购物车商品数量更新失败");
            rv.setCode(400);
        }
        return rv;
    }


    @GetMapping("/list")
    public Result queryShopCart(Integer user_id){
        List<Shopcart> shopcartList = shopcartService.queryShopCartByUserId(user_id);
        return new Result(shopcartList);
    }

    @PutMapping("/updateNum")
    public Result updateShopCartNum(@RequestBody Map<String,Integer> map){
        log.info("购物车更新的信息:"+map);
        //获取用户id，商品id
        Integer userId = map.get("user_id");
        Integer productId = map.get("product_id");
        Integer num = map.get("num");
        boolean flag = shopcartService.updateShopCart(userId, productId,num);
        Result rv = new Result();
        if(flag){
            //true
            rv.setCode(200);
            rv.setSuccess(true);
            rv.setMessage("购物车商品数量更新成功");
        }else{
            rv.setSuccess(false);
            rv.setMessage("购物车商品数量更新失败");
            rv.setCode(500);
        }
        return rv;
    }

    @DeleteMapping("/delete")
    public Result delShopCart(Integer user_id, Integer product_id){
        boolean flag = shopcartService.deleteShopCart(product_id,user_id);
        Result rv = new Result();
        if(flag){
            //true
            rv.setCode(200);
            rv.setSuccess(true);
            rv.setMessage("购物车商品删除成功");
        }else{
            rv.setSuccess(false);
            rv.setMessage("购物车商品删除失败");
            rv.setCode(500);
        }
        return rv;

    }
}

