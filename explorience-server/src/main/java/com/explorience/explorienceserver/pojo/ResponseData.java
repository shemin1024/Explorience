package com.explorience.explorienceserver.pojo;

import com.explorience.explorienceserver.enums.MsgCodeEnum;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;
/**
 * @author shemin
 */
@Data
public class ResponseData<T> implements Serializable {
    private T data;
    private String msg;
    private int code;

    public static <T> ResponseData<T> ok(T user) {
        return new ResponseData<>(user, MsgCodeEnum.SUCCESS);
    }
    public ResponseData(T data, MsgCodeEnum msgCode) {
        this.data = data;
        this.msg = msgCode.getMessage();
        this.code = msgCode.getCode();
    }

    public static <T> ResponseData<T> error(MsgCodeEnum code) {
        Assert.isTrue(MsgCodeEnum.SUCCESS.getCode()!=code.getCode(), "code 必须是错误的！");
        return new ResponseData<>(null, code);
    }
}
