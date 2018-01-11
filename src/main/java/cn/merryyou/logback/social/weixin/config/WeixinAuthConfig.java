package cn.merryyou.logback.social.weixin.config;

import cn.merryyou.logback.properties.SecurityConstants;
import cn.merryyou.logback.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import static cn.merryyou.logback.properties.SecurityConstants.DEFAULT_SOCIAL_WEIXIN_PROVIDER_ID;

/**
 * Created on 2018/1/11.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
public class WeixinAuthConfig extends SocialAutoConfigurerAdapter {
    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new WeixinConnectionFactory(DEFAULT_SOCIAL_WEIXIN_PROVIDER_ID, SecurityConstants.DEFAULT_SOCIAL_WEIXIN_APP_ID,
                SecurityConstants.DEFAULT_SOCIAL_WEIXIN_APP_SECRET);
    }
}
