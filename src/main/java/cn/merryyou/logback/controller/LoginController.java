package cn.merryyou.logback.controller;

import cn.merryyou.logback.properties.SecurityConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created on 2018/1/28 0028.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Controller
@Slf4j
public class LoginController {
    /**
     * 跳转到登录界面
     *
     * @param request
     * @param response
     * @param map
     * @return
     */
    @GetMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    public ModelAndView require(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        return new ModelAndView("login", map);
    }

    /**
     * 主页
     *
     * @param userDetails
     * @param map
     * @return
     */
    @GetMapping(value = {"/index", "/"})
    public ModelAndView index(@AuthenticationPrincipal UserDetails userDetails, Map<String, String> map) {
        map.put("username", userDetails.getUsername());

        //
        return new ModelAndView("index", map);

    }

    /**
     * 注册界面
     *
     * @param map
     * @return
     */
    @GetMapping(value = "/register")
    public ModelAndView register(Map<String, String> map) {
        return new ModelAndView("register", map);
    }

    /**
     * 手机号登录界面
     *
     * @param request
     * @param response
     * @param map
     * @return
     */
    @GetMapping(SecurityConstants.DEFAULT_SIGN_IN_URL_MOBILE_PAGE)
    public ModelAndView mobilePage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {

        return new ModelAndView("mobileLoginPage", map);
    }
}
