package cn.merryyou.logback.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created on 2017/11/11 0011.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 枷锁
     *
     * @param key
     * @param value 当前时间+ 超时时间
     * @return
     */
    public boolean lock(String key, String value) {
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获得上一个锁的时间
            String olcValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(olcValue) && olcValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解锁
     *
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentVlue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentVlue) && currentVlue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
                ;
            }
        } catch (Exception e) {
            log.error("【redis分布式锁】 解锁异常" + e.getMessage());
        }
    }

}
