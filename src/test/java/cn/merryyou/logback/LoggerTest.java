package cn.merryyou.logback;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created on 2017/11/3 0003.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    //    private final Logger logger = LoggerFactory.getLogger(LoggerTest2.class);
//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {
//        logger.debug("debug...");
//        logger.info("info...");
//        logger.info("name: {} ,age: {}","tom",20);
//        logger.error("error");

        log.debug("debug...");
        log.info("info...");
        log.info("name: {} ,age: {}", "tom", 20);
        log.error("error");
    }
}
