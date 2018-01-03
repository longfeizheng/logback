package cn.merryyou.logback.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RestController
@Slf4j
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    @RequestMapping("/order1")
    public DeferredResult<String> order1() throws Exception {
        log.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);

        log.info("主线程返回");
        return result;
    }

    @RequestMapping("/order")
    public Callable<String> order() throws Exception {
        log.info("主线程开始");
        Callable<String> result = () -> {
            log.info("副线程开始");
            Thread.sleep(1000);
            log.info("副线程返回");
            return "success";
        };

        log.info("主线程返回");
        return result;
    }

}
