package com.ztx.redislock.controller;

import com.ztx.redislock.pojo.Product;
import com.ztx.redislock.service.ProductManager;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class MainController {

    @Resource
    private ProductManager productManager;

    @GetMapping("/buyProduct/{productId}")
    public String buyProduct(@PathVariable("productId")int id)  {
        return  productManager.SellProduct(id);
    };
    @GetMapping("/test")
    public String test() throws InterruptedException {

        return  "ok";
    };


}
