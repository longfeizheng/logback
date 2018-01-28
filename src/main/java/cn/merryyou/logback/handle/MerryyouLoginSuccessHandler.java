package cn.merryyou.logback.handle;

import cn.merryyou.logback.enums.LoginType;
import cn.merryyou.logback.properties.SecurityProperties;
import cn.merryyou.logback.utils.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 * Created on 2018/1/28 0028.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component("merryyouLoginSuccessHandler")
@Slf4j
public class MerryyouLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 登录成功处理器
     * @param request
     * @param response
     * @param authentication
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("【MerryyouAuthenticationSuccessHandler】 onAuthenticationSuccess authentication={}", authentication);

        if (LoginType.JSON.equals(securityProperties.getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResultUtil.success(authentication.getName())));

        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
