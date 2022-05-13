package com.ztx.redislock.service;

import org.springframework.stereotype.Service;

@Service
public interface ProductManager {
    //1.出售商品
    String SellProduct(int id) ;
    //2.进货
    String StockProduct(int id);
}
