package com.explorience.explorienceserver.exception;

import com.explorience.explorienceserver.enums.MsgCodeEnum;

/**
 * @description: 自定义异常类
 * @author: shemin
 * @create: 2024-08-22 15:16
 **/
public class ServerException extends RuntimeException {
    public ServerException(MsgCodeEnum message) {
        super(message.getMessage());
    }
}
