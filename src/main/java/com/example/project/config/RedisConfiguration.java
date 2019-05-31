package com.example.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.nio.charset.Charset;

/**
 * @author hwq
 * @date 2019/05/23
 * <p>
 *     redis配置类
 * </p>
 */

@Configuration
public class RedisConfiguration {

    @Resource
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public StringRedisTemplate redisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate(jedisConnectionFactory);
        CustomStringRedisSerializer customStringRedisSerializer = new CustomStringRedisSerializer();
        redisTemplate.setValueSerializer(customStringRedisSerializer);
        redisTemplate.setKeySerializer(customStringRedisSerializer);
        redisTemplate.setHashValueSerializer(customStringRedisSerializer);
        redisTemplate.setHashKeySerializer(customStringRedisSerializer);
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    //redis序列化
    class CustomStringRedisSerializer implements RedisSerializer<Object> {
        private final Charset charset;
        public CustomStringRedisSerializer() {
            this(Charset.forName("UTF8"));
        }
        public CustomStringRedisSerializer(Charset charset) {
            Assert.notNull(charset, "Charset must not be null!");
            this.charset = charset;
        }
        public String deserialize(byte[] bytes) {
            return (bytes == null ? null : new String(bytes, charset));
        }
        public byte[] serialize(Object o) {
            return (o == null ? null : o.toString().getBytes(charset));
        }
    }
}
