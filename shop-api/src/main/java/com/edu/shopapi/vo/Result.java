package com.edu.shopapi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author liufuping
 * @Date 2023/12/5 20:09
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private Object data;
    private Integer code;
    private String message;
    private boolean success;

    public Result(Integer code, String message, List<T> data) {
        this.data = data;
        this.code = code;
        this.message = message;
    }
    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Result(Integer code, String message, boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }
    public Result(List<T> data) {
        this.code = 200;
        this.message = "SUCCESS";
        this.success = true;
        this.data = data;
    }
    public Result(Object data) {
        this.code = 200;
        this.message = "登录成功";
        this.success = true;
        this.data = data;
    }

    public static Result ok(String msg){

        return new Result(200,msg);
    }

    public static Result failure(String msg){
        return new Result(403,msg);
    }

    public static Result failure(){
        return new Result(403,"FAILURE");
    }

    public static Result ok(){
        return new Result(200,null);
    }

    public static Result update(int count){
        String msg = count > 0 ? "SUCCESS" :"FAILURE";
        int code = count > 0 ? 200 : 500;
        return new Result(code,msg);
    }

    public static Result delete(int count){
        String msg = count > 0 ? "SUCCESS" :"FAILURE";
        int code = count > 0 ? 200 : 500;
        return new Result(code,msg);
    }
}
