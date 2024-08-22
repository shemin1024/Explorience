package com.explorience.explorienceserver.enums;

/**
 * @description: 错误码对应Message
 * @author: shemin
 * @create: 2024-08-22 12:01
 **/
public enum MsgCodeEnum {
    SUCCESS(200, "成功"),
    ERROR(500, "失败"),
    PASSWORD_ERROR(501, "密码错误"),
    NOT_FOUND(502, "用户不存在"),
    EXIST(503, "用户已存在"),
    VERIFY_CODE_ERROR(503, "验证码错误"),
    PARA_ERROR(504, "参数错误");
    private int code;
    private String message;
    MsgCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public int getCode() {
        return code;
    }
}
