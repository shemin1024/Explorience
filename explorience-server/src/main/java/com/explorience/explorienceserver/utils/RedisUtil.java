package com.explorience.explorienceserver.utils;

/**
 * @description: Redis工具类
 * @author: shemin
 * @create: 2024-08-22 17:16
 **/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 设置字符串值
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 设置带过期时间的字符串值
    public void set(String key, Object value, long timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    // 获取字符串值
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 删除键
    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    // 判断键是否存在
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    // 设置哈希值
    public void hSet(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    // 获取哈希值
    public Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    // 获取列表元素
    public Object lIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    // 推入列表元素
    public void lPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    // 弹出列表元素
    public Object lPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    // 设置过期时间
    public boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return redisTemplate.expire(key, timeout, timeUnit);
    }

    // 获取剩余过期时间
    public Long getExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }
}

