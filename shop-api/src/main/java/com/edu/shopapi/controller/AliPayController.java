package com.edu.shopapi.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.edu.shopapi.config.AlipayConfig;
import com.edu.shopapi.dto.OrderComm;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liufuping
 * @Date 2023/12/15 15:35
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/alipay")
public class AliPayController {

    @GetMapping("/pay")
    public String alipay(OrderComm oc, HttpSession session) throws AlipayApiException {
        log.info("支付信息:"+oc);
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填 //获取前端前端传递的参数
        String out_trade_no =oc.getOrderNo();
        //付款金额，必填
        String total_amount = oc.getTotalPrice()+"";
        //订单名称，必填
        String subject = oc.getOrderName();
        //商品描述，可空
        String body = null;
        //保存数据-->当生成订单的时候可以使用
        session.setAttribute("oc",oc);
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        return result;

    }
}
