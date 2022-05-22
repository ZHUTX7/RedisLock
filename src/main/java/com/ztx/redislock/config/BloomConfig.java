//package com.ztx.redislock.config;
//
//import com.google.common.hash.BloomFilter;
//import com.google.common.hash.Funnels;
//import com.ztx.redislock.simpleLock.RedissonLock;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
////  单机布隆过滤器
//@Configuration
//public class BloomConfig {
//
//    @Bean
//    public BloomFilter bloomFilter() {
//        //预计插入数据
//        Long v1 = 1000*1000L;
//        //误判率
//        double v2 = 0.01;
//        BloomFilter b = BloomFilter.create(Funnels.integerFunnel(), v1, v2);
//        for(int i = 0;i<100;i++){
//            b.put(i);
//            System.out.println("插入数据"+i);
//        }
//        return b;
//    }
//
//
//}
//
