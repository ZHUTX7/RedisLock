package com.ztx.redislock.simpleLock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;


/*
Redisson解决了业务没有执行完而锁已经到期的问题
 */

@Service("RedissonLock")
public class RedissonLock implements LockService{

   @Resource
   private  RedissonClient redissonClient;

    @Override
    public boolean getLock(int id) {
        RLock lock = redissonClient.getLock("product::" + id);
        lock.lock();
        return true;
    }

    @Override
    public boolean unLock(int id) {
        RLock lock = redissonClient.getLock("product::" + id);
        lock.unlock();
        return true;
    }
}
