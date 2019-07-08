package com.example.project.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author hwq
 * @date 2019/05/24
 */
@Slf4j
@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * String的set
     * @param key
     * @param value
     */
    public void set(String key, final String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

    /**
     * String的get
     * @param key
     */
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * String的set并且加上过期时间
     * @param key
     * @param value
     * @param exTime
     */
    public void setEx(String key, final String value, int exTime){
        stringRedisTemplate.opsForValue().set(key, value,exTime, TimeUnit.SECONDS);
    }

    /**
     * 存储一个Hash类型
     * @param key
     * @param map
     */
    public void setHash(String key, Map map){
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        hash.putAll(key,map);
    }

    /**
     * 通过key获取Hash的value，返回一个Map
     * @param key
     * @return
     */
    public Map entriesHash(String key){
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries(key);
        return map;
    }

    /**
     * 通过key和HashKey获取单个value
     * @param key
     * @param hashKey
     * @return
     */
    public Object hget(String key, Object hashKey){
        HashOperations<String, Object, Object> hash = stringRedisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * 单个加入到set
     * @param key
     * @param value
     * @return
     */
    public Long addSet(String key, String value){
        return redisTemplate.opsForSet().add(key,value);
    }

    /**
     * 一次性加入多个值
     * @param key
     * @param value
     * @return
     */
    public Long addSet(String key, String []value){
        return redisTemplate.opsForSet().add(key,value);
    }

    /**
     * 获取set中所有元素
     * @param key
     * @return
     */
    public Set getSet(String key){
        Set operations = redisTemplate.opsForSet().members(key);
        return operations;
    }

    public Long delSet(String key, String value){

        return redisTemplate.opsForSet().remove(key,value);
    }

    public Set getLikeData(String key){
        return redisTemplate.keys("*" + key + "*");
    }


}
