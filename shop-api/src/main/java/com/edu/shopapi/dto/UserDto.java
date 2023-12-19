package com.edu.shopapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author liufuping
 * @Date 2023/12/8 15:31
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer uid;
    private String nickname;
    private String token;
}
