package cn.merryyou.logback.properties;

import cn.merryyou.logback.enums.LoginType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created on 2018/1/10.
 *
 * @author zlf
 * @since 1.0
 */
@Data
@ConfigurationProperties(prefix = "merryyou.security")
public class SecurityProperties {

    private String signOutUrl = "/merryyou-signOut.html";

    private LoginType loginType = LoginType.JSON;

    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * 记住我的有效时间秒
     */
    private int rememberMeSeconds = 60 * 60 * 24 * 7;

    /**
     * session配置过期和并发登录
     */
    private SessionProperties session = new SessionProperties();
}
