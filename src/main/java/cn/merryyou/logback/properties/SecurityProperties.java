package cn.merryyou.logback.properties;

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
    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
}
