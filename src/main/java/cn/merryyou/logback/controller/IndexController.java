package cn.merryyou.logback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created on 2017/11/24 0024.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Controller
@RequestMapping("/ftl")
public class IndexController {

    @GetMapping("/index")
    public ModelAndView index(Map<String, String> map) {
        map.put("test", "hello world!");
        return new ModelAndView("ftl/index", map);
    }
}
