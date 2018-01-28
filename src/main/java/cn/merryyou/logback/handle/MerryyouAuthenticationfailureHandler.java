package cn.merryyou.logback.handle;

import cn.merryyou.logback.enums.ResultEnum;
import cn.merryyou.logback.utils.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2018/1/7 0007.
 * 自定义登录失败处理
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component(value = "merryyouAuthenticationfailureHandler")
public class MerryyouAuthenticationfailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // super.onAuthenticationFailure(request, response, exception);
//        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());//服务器内部异常
        String message = "";
        response.setContentType("application/json;charset=UTF-8");
        if ("坏的凭证".equals(exception.getMessage())) {
            message = "用户名或密码错误！";
        } else {
            message = exception.getMessage();
        }
        response.getWriter().write(objectMapper.writeValueAsString(ResultUtil.error(ResultEnum.FAIL.getCode(), message)));
    }
}
