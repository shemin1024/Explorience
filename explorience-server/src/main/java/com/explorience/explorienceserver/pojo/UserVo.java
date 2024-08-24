package com.explorience.explorienceserver.pojo;

import lombok.Data;

/**
 * @description: 返回的用户信息
 * @author: shemin
 * @create: 2024-08-22 17:13
 **/
@Data
public class UserVo {
    private Long id;
    private String username;
    private String email;
    private String token;

    public UserVo(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
