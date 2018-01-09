package cn.merryyou.logback.social;

import cn.merryyou.logback.properties.SecurityConstants;
import cn.merryyou.logback.social.qq.config.MerryyouSpringSocialConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 社交登录配置主类
 * Created on 2018/1/8 0008.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    /**
     * 社交登录配类
     *
     * @return
     */
    @Bean
    public SpringSocialConfigurer merryyouSocialSecurityConfig() {
        String filterProcessesUrl = SecurityConstants.DEFAULT_SOCIAL_QQ_PROCESS_URL;
        MerryyouSpringSocialConfigurer configurer = new MerryyouSpringSocialConfigurer(filterProcessesUrl);
        return configurer;
    }

    /**
     * 处理注册流程的工具类
     * @param factoryLocator
     * @return
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator factoryLocator) {
        return new ProviderSignInUtils(factoryLocator, getUsersConnectionRepository(factoryLocator));
    }

}
