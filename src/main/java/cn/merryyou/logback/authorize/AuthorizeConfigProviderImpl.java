package cn.merryyou.logback.authorize;

import org.springframework.core.annotation.Order;
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
@Order(Integer.MAX_VALUE)
public class AuthorizeConfigProviderImpl implements AuthorizeConfigProvider {
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
//        config.antMatchers("/person/*").access("hasRole('ADMIN') or hasRole('USER')")
//                .antMatchers("/person/{id}").access("@rbacService.checkUserId(authentication,#id)")
//                .anyRequest()
//                .access("@rbacService.hasPermission(request,authentication)");
//        config.antMatchers("/perons").access("hasRole('ADMIN')").anyRequest().authenticated();
        config.anyRequest().authenticated();
//        config.anyRequest().access("@rbacService.hasPermission(request,authentication)");
    }
}
