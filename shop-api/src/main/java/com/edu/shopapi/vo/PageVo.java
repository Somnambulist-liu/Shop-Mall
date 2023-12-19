package com.edu.shopapi.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.shopapi.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author liufuping
 * @Date 2023/12/8 8:29
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo<T> {
    private Integer code;
    private Boolean success;
    private String message;
    private List<T> data;
    private Integer total;//商品总数量
    private Integer pageIndex;//当前页
    public PageVo(Integer code, Boolean success, String message, List<T> data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public PageVo(List<T> data){
        this.data = data;
        this.code = 200;
        this.message = "查询成功";
        this.success = true;
    }

    public PageVo(int code, boolean success, String message, List<T> data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public PageVo(int code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}
