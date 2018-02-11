package cn.merryyou.logback.social.weibo.config;

import cn.merryyou.logback.properties.SecurityConstants;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.weibo.connect.WeiboConnectionFactory;


/**
 * Created on 2018/1/12.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
public class WeiboAuthConfig extends SocialAutoConfigurerAdapter {

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new WeiboConnectionFactory(SecurityConstants.DEFAULT_SOCIAL_WEIBO_APP_ID, SecurityConstants.DEFAULT_SOCIAL_WEIBO_APP_SECRET);
    }

}
