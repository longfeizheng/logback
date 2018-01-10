package cn.merryyou.logback.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成器
 * Created on 2018/1/10.
 *
 * @author zlf
 * @since 1.0
 */
public interface ValidateCodeGenerator {
    /**
     * 生成验证码
     * @param request
     * @return
     */
    ValidateCode generate(ServletWebRequest request);
}
