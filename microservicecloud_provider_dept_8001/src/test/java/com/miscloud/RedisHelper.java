package com.miscloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Objects;

public class RedisHelper {

    public static final String LOCK_PREFIX = "redis_lock"; //锁的前缀
    public static final int LOCK_EXPIRE = 300; // 锁的过期时间 ms

    @Autowired
    RedisTemplate redisTemplate;
    /**
     *  为操作的添加锁
     *
     * @param key key值
     * @return 是否获取到
     */
    public Boolean lock(String key){

        //锁的名称
        String lock = LOCK_PREFIX + key;

        Boolean execute = (Boolean) redisTemplate.execute((RedisCallback) connection -> {
            //锁的值，也就是这个锁是什么时候添加的
            long expireAt = System.currentTimeMillis() + LOCK_EXPIRE + 1;

            //为当前这个key设置锁，setNx中如果存在这个key存在则获取不到锁返回false，不存在返回true
            Boolean acquire = connection.setNX(lock.getBytes(), String.valueOf(expireAt).getBytes());

            if (acquire) {
                //返回锁，则可以操作这个key
                return true;
            } else {
                //没有获取到锁，获取到这个锁的值，然后判断是否为空
                byte[] value = connection.get(lock.getBytes());
                if (Objects.nonNull(value) && value.length > 0) {
                    //获取到设置锁的时候的时间
                    long expireTime = Long.parseLong(new String(value));

                    if (expireTime < System.currentTimeMillis()) {
                        // 如果锁已经过期
                        byte[] oldValue = connection.getSet(lock.getBytes(), String.valueOf(System.currentTimeMillis() + LOCK_EXPIRE + 1).getBytes());
                        // 防止死锁
                        return Long.parseLong(new String(oldValue)) < System.currentTimeMillis();
                    }
                }
            }
            return false;
        });

        return execute;
    }
    /**
     * 删除锁
     *
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
