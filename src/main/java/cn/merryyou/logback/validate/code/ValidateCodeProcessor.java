package cn.merryyou.logback.validate.code;

import cn.merryyou.logback.utils.CodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.RenderedImage;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created on 2018/1/7 0007.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
@Slf4j
public class ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_IMAGE";


    public void createCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, Object> map = CodeUtil.generateCodeAndPic();
        request.getSession().setAttribute(SESSION_KEY_PREFIX, map.get("code"));
        request.getSession().setAttribute(SESSION_KEY_PREFIX + "_time", map.get("expireTime"));
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", response.getOutputStream());
    }

    public void validateCode(HttpServletRequest request) {
        String sessionCode = request.getSession().getAttribute(SESSION_KEY_PREFIX).toString();
        LocalDateTime expireTime = (LocalDateTime) request.getSession().getAttribute(SESSION_KEY_PREFIX + "_time");

        String requestCode = (String) request.getParameter("imageCode");
        log.info("【sessionCode={}】,【requestCode={}】",sessionCode,requestCode);
        if (StringUtils.isBlank(requestCode)) {
            throw new ValidateCodeException("验证码的值不能为空");
        }

        if (sessionCode == null) {
            throw new ValidateCodeException("验证码不存在");
        }

        if (LocalDateTime.now().isAfter(expireTime)) {
            request.getSession().removeAttribute(SESSION_KEY_PREFIX);
            request.getSession().removeAttribute(SESSION_KEY_PREFIX + "_time");
            throw new ValidateCodeException("验证码已过期");
        }

        if (!StringUtils.endsWithIgnoreCase(sessionCode, requestCode)) {
            throw new ValidateCodeException("验证码不匹配");
        }

        request.getSession().removeAttribute(SESSION_KEY_PREFIX);
        request.getSession().removeAttribute(SESSION_KEY_PREFIX + "_time");
    }

}
