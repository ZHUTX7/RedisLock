package com.ztx.redislock.pojo;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private int id;
    //商品名称
    private String name;
    //商品数量
    private int sum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
