package cn.merryyou.logback.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
public class IndexController {

    @GetMapping(value = {"/index", "/"})
    public ModelAndView index(@AuthenticationPrincipal UserDetails userDetails, Map<String, String> map) {
        map.put("test", "hello " + userDetails.getUsername() + "!");
        return new ModelAndView("ftl/index", map);
    }

    @GetMapping(value = "/login")
    public ModelAndView login(Map<String, String> map) {
        return new ModelAndView("ftl/login", map);
    }

    @GetMapping(value = "/register")
    public ModelAndView register(Map<String, String> map) {
        return new ModelAndView("ftl/register", map);
    }

}
