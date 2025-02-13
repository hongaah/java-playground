package cn.itsource.springboothello01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/set")
    public String testSet() {
        redisTemplate.opsForValue().set("name", "李四");
        return "set done";
    }

    @RequestMapping("/get")
    public String testGet () {
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("/REDIS GET " + name);
        return "get done";
    }
}
