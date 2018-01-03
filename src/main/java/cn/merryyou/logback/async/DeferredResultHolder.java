package cn.merryyou.logback.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2017/12/20 0020.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
@Slf4j
public class DeferredResultHolder {

    private Map<String, DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
