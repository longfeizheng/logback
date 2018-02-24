package cn.merryyou.logback.controller;

import cn.merryyou.logback.dto.MenuDto;
import cn.merryyou.logback.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
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

    @Autowired
    private SysMenuService sysMenuService;


    @GetMapping("/showMenu")
    public ModelAndView showMenu(Map map) {

        return new ModelAndView("menu/menuList",map);
    }

    /**
     * 侧边栏显示
     * @param userDetails
     * @param map
     * @return
     */
    @RequestMapping(value = "/menus")
    @ResponseBody
    public List<MenuDto> menus(@AuthenticationPrincipal UserDetails userDetails, Map<String, String> map) {
        map.put("username", userDetails.getUsername());
        List<MenuDto> menus = sysMenuService.getMenus(userDetails.getUsername(),0);//菜单地址
        return menus;
    }

    /**
     * 权限结合列表
     * @param userDetails
     * @param map
     * @return
     */
    @RequestMapping(value = "/menuList")
    @ResponseBody
    public List<MenuDto> menuList(@AuthenticationPrincipal UserDetails userDetails, Map<String, String> map) {
        map.put("username", userDetails.getUsername());
        List<MenuDto> menus = sysMenuService.getMenusList();
        return menus;
    }
}
