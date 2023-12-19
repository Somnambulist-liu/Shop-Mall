package com.edu.shopapi.dto;

import lombok.Data;

/**
 * @Author liufuping
 * @Date 2023/12/15 15:34
 * @Version 1.0
 */
@Data
public class OrderComm {
    private String orderNo;
    private double totalPrice;
    private String orderName;
    private Integer userId;
    private String ids;
}
