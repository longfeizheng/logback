package cn.merryyou.logback.controller;

import cn.merryyou.logback.properties.SecurityConstants;
import cn.merryyou.logback.service.MyUserDetailsService;
import cn.merryyou.logback.social.SocialUserInfo;
import cn.merryyou.logback.utils.StringsUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created on 2018/1/4.
 *
 * @author zlf
 * @since 1.0
 */
@Controller
@Slf4j
public class UserController {

    private RequestCache requestCache = new HttpSessionRequestCache();//请求的缓存

    @Autowired
    private MyUserDetailsService userService;

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @GetMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    public ModelAndView require(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("【UserController】 require 请求 {} 地址需要认证", targetUrl);
        }

        String message = String.valueOf(request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION));
        if (StringsUtils.isNotNull(message)) {
            log.info("【MyUserDetailsService】 认证返回错误信息 {} ", message);
            map.put("message", StringUtils.substringAfter(message, ":"));
        }
        return new ModelAndView("ftl/login", map);
    }

    @PostMapping(SecurityConstants.DEFAULT_REGISTER_URL)
    public ModelAndView register(@RequestParam("username") String username,
                                 @RequestParam("password") String pasword, HttpServletRequest request, Map<String, Object> map) {
        log.info("【UserController】register username={},password={}", username, pasword);
        //不管是注册用户还是绑定用户
        providerSignInUtils.doPostSignUp(username, new ServletWebRequest(request));
        return new ModelAndView("ftl/login", map);
    }

    @GetMapping("social/info")
    public @ResponseBody
    SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadImg(connection.getImageUrl());
        return userInfo;
    }


}
