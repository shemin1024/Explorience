package com.explorience.explorienceserver.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @description:
 * @author: shemin
 * @create: 2024-08-22 18:44
 **/
@Data
public class LoginRequest {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
