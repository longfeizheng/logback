package cn.merryyou.logback.social.weibo.config;

import cn.merryyou.logback.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.weibo.connect.WeiboConnectionFactory;

import javax.sql.DataSource;


/**
 * Created on 2018/1/12.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
public class WeiboAuthConfig extends SocialAutoConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private ConnectionSignUp myConnectionSignUp;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new WeiboConnectionFactory(SecurityConstants.DEFAULT_SOCIAL_WEIBO_APP_ID, SecurityConstants.DEFAULT_SOCIAL_WEIBO_APP_SECRET);
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource,
                connectionFactoryLocator, Encryptors.noOpText());
        if (myConnectionSignUp != null) {
            repository.setConnectionSignUp(myConnectionSignUp);
        }
        return repository;
    }
}
