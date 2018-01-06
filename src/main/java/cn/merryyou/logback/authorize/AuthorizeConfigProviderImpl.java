package cn.merryyou.logback.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created on 2018/1/6 0006.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Component
public class AuthorizeConfigProviderImpl implements AuthorizeConfigProvider {
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry configurer) {
//        configurer.antMatchers("/person/*").hasRole("ADMIN")
        configurer.antMatchers("/person/*").hasRole("ADMIN")
        .anyRequest().authenticated();
    }
}
