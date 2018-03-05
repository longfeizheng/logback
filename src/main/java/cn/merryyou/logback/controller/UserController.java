package cn.merryyou.logback.controller;

import cn.merryyou.logback.domain.PageResult;
import cn.merryyou.logback.domain.Result;
import cn.merryyou.logback.domain.SysUser;
import cn.merryyou.logback.dto.UserDto;
import cn.merryyou.logback.properties.SecurityConstants;
import cn.merryyou.logback.service.SysUserService;
import cn.merryyou.logback.social.SocialUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
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

    @Autowired
    private SysUserService sysUserService;


    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @PostMapping(SecurityConstants.DEFAULT_REGISTER_URL)
    public ModelAndView register(@RequestParam("username") String username,
                                 @RequestParam("password") String pasword, HttpServletRequest request, Map<String, Object> map) {
        log.info("【UserController】register username={},password={}", username, pasword);
//        //不管是注册用户还是绑定用户
//        providerSignInUtils.doPostSignUp(username, new ServletWebRequest(request));
        return new ModelAndView("login", map);
    }

    /**
     * 获取第三方用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("/social/info")
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

    @GetMapping("/user/me")
    public Object getCurrentUser1(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @PostMapping("/user/register")
    public String register(SysUser user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = user.getUsername();
        SysUser result = sysUserService.findByUsername(userId);
        if (result == null) {
            //注册用户
            sysUserService.save(user);
        }
        //将业务系统的用户与社交用户绑定
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
        //跳转到index
        return "redirect:/index";
    }

    @GetMapping("/user/showUser")
    public ModelAndView userListView() {
        return new ModelAndView("/user/userList");
    }

    @GetMapping("/user/addUser")
    public ModelAndView addUserView() {
        return new ModelAndView("/user/userAdd");
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDto findUser(@PathVariable("id") String id) {
        return sysUserService.findOne(id);
    }

    @PreAuthorize("hasAuthority('user:del')")
    @RequestMapping("/user/del/{ids}")
    @ResponseBody
    public Result<String> delUsers(@PathVariable("ids") String ids) {
        return sysUserService.delUsers(ids);
    }

    @PreAuthorize("hasAnyAuthority('user:select','user:update')")
    @PostMapping(value = "/user/saveUser")
    @ResponseBody
    public Result saveUser(@RequestParam String data) {
        log.info(data);
        return sysUserService.save(data);
    }

    @PostMapping("/user/userList")
    @ResponseBody
    public PageResult userList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size) {

        List<UserDto> userList = sysUserService.findAll();
        PageResult pageResult = new PageResult();
        pageResult.setData(userList);
        pageResult.setTotal(String.valueOf(userList.size()));
        return pageResult;
    }
}
