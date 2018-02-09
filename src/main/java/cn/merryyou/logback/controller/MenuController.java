package cn.merryyou.logback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created on 2018/2/9.
 *
 * @author zlf
 * @since 1.0
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/showMenu")
    public ModelAndView showMenu(Map map) {

        return new ModelAndView("menu/menuList",map);
    }
}
