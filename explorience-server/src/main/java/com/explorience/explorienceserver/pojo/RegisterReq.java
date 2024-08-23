package com.explorience.explorienceserver.pojo;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @description: 注册请求信息
 * @author: shemin
 * @create: 2024-08-22 14:30
 **/
@Data
public class RegisterReq {

    @NotEmpty
    private String password;
    @NotEmpty
    @Email
    private String email;
    private String username;
    @NotEmpty
    private String verifyCode;
}
