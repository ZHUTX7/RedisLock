package com.ztx.redislock.simpleLock;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/*
普通的Redis分布式锁， 性能低，业务主要卡在线程自旋抢锁和访问DB的速度上
 */

@Service("SimpleLock")
public class SimpleLock implements LockService{

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean getLock(int id) {
        //自旋5次
        int time = 5;
        while (time > 0 ) {
            Boolean flag = redisTemplate.opsForValue().setIfAbsent("product::" + id, "fy", 5, TimeUnit.SECONDS);
            //获取锁成功
            if (flag) {
                return true;
            } else {
                time -- ;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }

        }
        //实在没抢到锁
        return false;
    }

    @Override
    public boolean unLock(int id) {
        return  redisTemplate.delete("product::" + id);
    }
}
