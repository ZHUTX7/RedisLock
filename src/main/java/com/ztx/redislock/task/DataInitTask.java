package com.ztx.redislock.task;

import com.ztx.redislock.config.RedissionBloom;
import com.ztx.redislock.pojo.Product;
import com.ztx.redislock.service.ProductManager;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//数据预热任务
@Service
public class DataInitTask {
    // 预期插入数量
    static long expectedInsertions = 200L;
    // 误判率
    static double falseProbability = 0.01;


    @Resource
    private RedissionBloom redissionBloom;

    @Resource
    private ProductManager productManager;

    @Bean
    public RBloomFilter<Integer> init() {
        // 启动项目时初始化bloomFilter
        System.out.println("数据预热中>>>>>>>>>>>>>>>>>>>>");
        List<Product> productList = productManager.findAllProduct();
        RBloomFilter<Integer>  bloomFilter = redissionBloom.create("productList", expectedInsertions, falseProbability);
        for (Product p : productList) {
            bloomFilter.add(p.getId());
        }
        System.out.println("数据预热完成------------------");
        return bloomFilter;
    }


}

