package cn.merryyou.logback.config;

import cn.merryyou.logback.annotation.NioCoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhenglongfei
 */
@Component
@Slf4j
public class TestBeanBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class clazz = bean.getClass();
        if (clazz.isAnnotationPresent(NioCoder.class)) {
            if (clazz.isInterface()) {
                log.info("------------------");
            }
            log.info("++++++++++++++++++++++++++++");
            doSomething(bean, beanName);
        }
        return bean;
    }

    private void doSomething(Object bean, String beanName) {
        Map<String, Object> nioCoderMap = this.applicationContext.getBeansWithAnnotation(NioCoder.class);

        log.info("nioCoderMap={}", nioCoderMap);
    }
}