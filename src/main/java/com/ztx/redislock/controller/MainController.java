package com.ztx.redislock.controller;

import com.ztx.redislock.pojo.Product;
import com.ztx.redislock.service.ProductManager;
import org.redisson.api.RBloomFilter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class MainController {

    @Resource
    private ProductManager productManager;

    //Redission布隆过滤器
    @Resource
    private RBloomFilter<Integer> bloomFilter;


    @GetMapping("/buyProduct/{productId}")
    public String buyProduct(@PathVariable("productId")int id)  {
        return  productManager.SellProduct(id);
    };


    @Cacheable(cacheNames = "product", key = "#id", unless = "#result==null")
    @GetMapping("/findProduct/{productId}")
    public String findProduct(@PathVariable("productId")int id)  {
        if(!bloomFilter.contains(id)){
            //去数据库中查询
            //略
            return "商品不存在";
        }
        return  productManager.findProduct(id).getName();
    };

    @GetMapping("/findProduct2/{name}")
    public String findProduct2(@PathVariable("name")String name)  {
        return  productManager.findProduct(name).getName();
    };

}
