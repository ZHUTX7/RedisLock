package com.ztx.redislock.simpleLock;

import org.springframework.stereotype.Service;

@Service
public interface LockService {
    //上锁
    boolean getLock(int id) ;
    //解锁
    boolean unLock(int id);
}
