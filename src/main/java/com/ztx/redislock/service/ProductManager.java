package com.ztx.redislock.service;

import com.ztx.redislock.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductManager {
    //1.出售商品
    String SellProduct(int id) ;
    //2.进货
    String StockProduct(int id);
    //3.查询商品
    Product findProduct(int id);
    Product findProduct(String name);
    //4.获取所有商品
    List<Product> findAllProduct();
}
