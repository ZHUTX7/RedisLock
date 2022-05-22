package com.ztx.redislock.dao;

import com.ztx.redislock.pojo.Product;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface ProductRepo {

    @Select("Select * from product where id = #{id}")
    Product getProduct(int id);
    @Select("Select * from product where name = #{name} limit 0,1")
    Product getProduct2(String name);
    @Update("Update product set sum = sum-1 where id = #{id} ")
    void subtractProduct(int id);
    @Update("Update product set sum = sum+1 where id = #{id} ")
    void addProduct(int id);
    @Select("Select * from product")
    List<Product> getAllProduct();

}
