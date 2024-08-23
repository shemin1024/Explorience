package com.explorience.explorienceserver.pojo;

import lombok.Data;

/**
 * @description:
 * @author: shemin
 * @create: 2024-08-23 10:25
 **/
@Data
public class VerifyCodeRsp {
    private String code;

    public VerifyCodeRsp(String code) {
        this.code = code;
    }
}
