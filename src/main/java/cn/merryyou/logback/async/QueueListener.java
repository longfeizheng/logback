package cn.merryyou.logback.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
@Slf4j
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(()->{
            while (true) {
                if (StringUtils.isNotBlank(mockQueue.getCompleteOrder())) {
                    String orderNumber = mockQueue.getCompleteOrder();

                    log.info("【QueueListener】 返回订单处理结果，orderNumber={}", orderNumber);
                    deferredResultHolder.getMap().get(orderNumber).setResult("place order success");

                    mockQueue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}
