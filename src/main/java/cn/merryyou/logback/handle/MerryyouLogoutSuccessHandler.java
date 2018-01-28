package cn.merryyou.logback.handle;

import cn.merryyou.logback.utils.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2018/1/27 0027.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Slf4j
public class MerryyouLogoutSuccessHandler implements LogoutSuccessHandler {

    private String signOutSuccessUrl;

    private ObjectMapper objectMapper = new ObjectMapper();

    public MerryyouLogoutSuccessHandler(String signOutSuccessUrl) {
        this.signOutSuccessUrl = signOutSuccessUrl;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("退出成功");

        if (StringUtils.isBlank(signOutSuccessUrl)) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResultUtil.success()));
        } else {
            response.sendRedirect(signOutSuccessUrl);
        }
    }
}
