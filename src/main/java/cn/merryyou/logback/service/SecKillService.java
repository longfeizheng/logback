package cn.merryyou.logback.service;

import cn.merryyou.logback.enums.ResultEnum;
import cn.merryyou.logback.exception.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created on 2017/11/18 0018.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Service
public class SecKillService {

    private static final int TIMEOUT = 10 * 1000;//超时时间 10秒

    /**
     * 国庆活动，限量10000份
     *
     * @param productId
     * @return
     */
    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;

    static {
        /**
         * 模拟多个表，商品信息表，库存表，秒杀成功订单表
         */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456", 100000);
        stock.put("123456", 100000);
    }

    @Autowired
    private RedisLock redisLock;

    private String querMap(String productId) {
        return "国庆活动,皮蛋粥特价，限量份"
                + products.get(productId)
                + "还剩" + stock.get(productId) + "份,"
                + "该商品成功下单用户数:"
                + orders.size() + "人";
    }

    public String querySecKillProductInfo(String productId) {
        return this.querMap(productId);
    }

    public void orderProductMockDiffUser(String productId) {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            throw new PersonException(103, "人太多了，继续加油!");
        }
        //1.查询该商品库存，为0则活动结束
        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            throw new PersonException(ResultEnum.SECKILL_OVER);
        } else {
            //2.下单
            orders.put(UUID.randomUUID().toString(), productId);
            //3.减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }
        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }
}
