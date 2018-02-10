package cn.merryyou.logback.controller;

import cn.merryyou.logback.properties.SecurityConstants;
import cn.merryyou.logback.service.SysMenuService;
import cn.merryyou.logback.social.SocialUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.ServletWebRequest;
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

    @Autowired
    private ProviderSignInUtils providerSignInUtils;


    @Autowired
    private SysMenuService sysMenuService;

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

    @GetMapping(value = "/main")
    public ModelAndView main(@AuthenticationPrincipal UserDetails userDetails, Map<String, String> map) {
        map.put("username", userDetails.getUsername());

        //
        return new ModelAndView("main", map);

    }

    @GetMapping(value = "/hello")
    public ModelAndView hello(@AuthenticationPrincipal UserDetails userDetails, Map<String, String> map) {
        map.put("username", userDetails.getUsername());

        //
        return new ModelAndView("hello", map);

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
     * 注册界面
     *
     * @param map
     * @return
     */
    @GetMapping(value = "/socialRegister")
    public ModelAndView socialRegister(HttpServletRequest request, Map<String, Object> map) {
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadImg(connection.getImageUrl());
        map.put("user", userInfo);
        return new ModelAndView("socialRegister", map);
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

    @GetMapping("/message/{msg}")
    public ModelAndView message(@PathVariable("msg") String msg, HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        String message="解绑成功！";
        if("bindingSuccess".equals(msg)){
            message="绑定成功！";
        }
        String page = "success";
        map.put("msg", message);
        map.put("url", "/index");
        return new ModelAndView(page, map);
    }
}
