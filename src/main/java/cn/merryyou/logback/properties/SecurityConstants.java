package cn.merryyou.logback.properties;

/**
 * Created on 2018/1/4.
 *
 * @author zlf
 * @since 1.0
 */
public interface SecurityConstants {

    /**
     * 当请求需要身份验证时跳转URL
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 默认的用户注册请求处理url
     */
    String DEFAULT_REGISTER_URL = "/authentication/register";

    /**
     * qq appID
     */
    String DEFAULT_SOCIAL_QQ_APP_ID = "101386962";

    /**
     * qq appsECRET
     */
    String DEFAULT_SOCIAL_QQ_APP_SECRET = "2a0f820407df400b84a854d054be8b6a";

    /**
     *自定义social拦截地址  默认/auth  (SocialAuthenticationFilter)
     */
    String DEFAULT_SOCIAL_QQ_PROCESS_URL = "/login";

    /**
     * 提供商的ID
     */
    String DEFAULT_SOCIAL_QQ_PROVIDER_ID = "qq";

    /**
     * 默认的主页测
     */
    String DEFAULT_SIGNUP_URL = "/register";


}
