package com.ztx.redislock.service;

import com.ztx.redislock.dao.ProductRepo;
import com.ztx.redislock.pojo.Product;
import com.ztx.redislock.simpleLock.LockService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductManagerImpl implements ProductManager{

    @Resource
    private ProductRepo productRepo;

    @Resource
    @Qualifier("RedissonLock")
   //@Qualifier("SimpleLock")
    private LockService lockService;



    //使用普通分布式锁
    @Override
    public String SellProduct(int id)  {
        Product product =null;
        boolean flag = false;
        if(lockService.getLock(id)){

            try{
                product =  productRepo.getProduct(id);
                if(product.getSum()>0){
                    productRepo.subtractProduct(id);
                    flag = true;
                }
                product =  productRepo.getProduct(id);
                System.out.println("商品"+ product.getName()+"  剩余数量："+product.getSum());

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                //lockService.unLock(id);
            }
            if(flag){
                return ("商品"+ product.getName()+"购买成功");
            }else
                return ("程序异常或商品数量不足，商品"+ product.getName()+"购买失败");



        }else {
            //没有抢到锁
            return ("购买失败，没有抢到过锁");
        }

    }


    //

    @Override
    public String StockProduct(int id) {
        return "";
    }

    @Override
    public Product findProduct(int id) {
        System.out.println("从数据库中查询");
        return  productRepo.getProduct(id);
    }

    @Override
    public Product findProduct(String name) {
        System.out.println("从数据库中查询");
        return productRepo.getProduct2(name);

    }

    @Override
    public List<Product> findAllProduct() {
        return  productRepo.getAllProduct();
    }
}
