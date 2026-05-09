package com.ecom_project.shopify.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisService {

    @Autowired
    private RedisTemplate template;

    public <T> T get(String key, Class<T> entityClass){
        try{
            Object o = template.opsForValue().get(key);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(o.toString(), entityClass);

        }catch(Exception e){
            log.error("Error: " + e.getMessage());
            return null;
        }
    }

    public void set(String key, Object o, Long ttl){
        try{
             template.opsForValue().set(key,o.toString(),ttl);

        }catch(Exception e){
            log.error("Error: " + e.getMessage());
        }
    }
}
