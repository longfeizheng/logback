package cn.merryyou.logback.social.weixin.connect;

import cn.merryyou.logback.social.weixin.api.Weixin;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

/**
 * 微信连接工厂
 * Created on 2018/1/11.
 *
 * @author zlf
 * @since 1.0
 */
public class WeixinConnectionFactory extends OAuth2ConnectionFactory<Weixin> {

    /**
     * @param appId
     * @param appSecret
     */
    public WeixinConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new WeixinServiceProvider(appId, appSecret), new WeixinAdapter());
    }

    /**
     * 由于微信的openId是和accessToken一起返回的，所以在这里直接根据accessToken设置providerUserId即可，不用像QQ那样通过QQAdapter来获取
     */
    @Override
    protected String extractProviderUserId(AccessGrant accessGrant) {
        if(accessGrant instanceof WeixinAccessGrant) {
            return ((WeixinAccessGrant)accessGrant).getOpenId();
        }
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.social.connect.support.OAuth2ConnectionFactory#createConnection(org.springframework.social.oauth2.AccessGrant)
     */
    public Connection<Weixin> createConnection(AccessGrant accessGrant) {
        return new OAuth2Connection<Weixin>(getProviderId(), extractProviderUserId(accessGrant), accessGrant.getAccessToken(),
                accessGrant.getRefreshToken(), accessGrant.getExpireTime(), getOAuth2ServiceProvider(), getApiAdapter(extractProviderUserId(accessGrant)));
    }

    /* (non-Javadoc)
     * @see org.springframework.social.connect.support.OAuth2ConnectionFactory#createConnection(org.springframework.social.connect.ConnectionData)
     */
    public Connection<Weixin> createConnection(ConnectionData data) {
        return new OAuth2Connection<Weixin>(data, getOAuth2ServiceProvider(), getApiAdapter(data.getProviderUserId()));
    }

    private ApiAdapter<Weixin> getApiAdapter(String providerUserId) {
        return new WeixinAdapter(providerUserId);
    }

    private OAuth2ServiceProvider<Weixin> getOAuth2ServiceProvider() {
        return (OAuth2ServiceProvider<Weixin>) getServiceProvider();
    }

}
