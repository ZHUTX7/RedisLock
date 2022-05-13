package com.ztx.redislock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ztx.redislock.dao")
public class RedislockApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedislockApplication.class, args);
    }

}
