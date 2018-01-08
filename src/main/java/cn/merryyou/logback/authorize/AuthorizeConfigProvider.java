package cn.merryyou.logback.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 授权配置提供器，安全模块涉及的url的授权配置
 * Created on 2018/1/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface AuthorizeConfigProvider {

    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry configurer);
}
