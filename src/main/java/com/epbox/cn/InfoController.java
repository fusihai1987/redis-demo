package com.epbox.cn;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/24 0024.
 */
@RestController
public class InfoController {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @RequestMapping("/get")
    public String get()
    {
        return redisTemplate.opsForValue().get("name");
    }

    @RequestMapping("/put/{value}")
    public String put(@PathVariable("value") String value)
    {
        redisTemplate.opsForValue().set("name",value);
        return "success";
    }
}
