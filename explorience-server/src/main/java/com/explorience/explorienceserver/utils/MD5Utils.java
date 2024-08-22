package com.explorience.explorienceserver.utils;

import cn.hutool.core.codec.Base64;
import com.explorience.explorienceserver.enums.MsgCodeEnum;
import com.explorience.explorienceserver.exception.ServerException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: 加密工具类
 * @author: shemin
 * @create: 2024-08-22 15:09
 **/
public class MD5Utils {
    private MD5Utils() {
    }

    public static String MD5(String str)  {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new ServerException(MsgCodeEnum.ERROR);
        }
        return Base64.encode(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
    }
}
