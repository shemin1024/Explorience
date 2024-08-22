package com.explorience.explorienceserver.pojo;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @description:
 * @author: shemin
 * @create: 2024-08-22 18:41
 **/
@Data
public class VerifyReq {
    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    private String email;
}
