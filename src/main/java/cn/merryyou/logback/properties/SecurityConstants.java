package cn.merryyou.logback.properties;

/**
 * Created on 2018/1/4.
 *
 * @author zlf
 * @since 1.0
 */
public interface SecurityConstants {

    /**
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 当请求需要身份验证时跳转URL
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";

    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE = "/authentication/mobile";

    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_SIGN_IN_URL_MOBILE_PAGE = "/authentication/mobilePage";

    /**
     * 默认的用户注册请求处理url
     */
    String DEFAULT_REGISTER_URL = "/authentication/register";

    /**
     * weixin appID
     */
    String DEFAULT_SOCIAL_WEIXIN_APP_ID = "wxd99431bbff8305a0";

    /**
     * weixin appsECRET
     */
    String DEFAULT_SOCIAL_WEIXIN_APP_SECRET = "60f78681d063590a469f1b297feff3c4";

    /**
     * qq appID
     */
    String DEFAULT_SOCIAL_QQ_APP_ID = "101386962";

    /**
     * qq appsECRET
     */
    String DEFAULT_SOCIAL_QQ_APP_SECRET = "2a0f820407df400b84a854d054be8b6a";

    /**
     *自定义QQ社交social拦截地址  默认/auth  (SocialAuthenticationFilter)
     */
    String DEFAULT_SOCIAL_QQ_PROCESS_URL = "/login";

    /**
     *自定义WEIXIN社交social拦截地址  默认/auth  (SocialAuthenticationFilter)
     */
    String DEFAULT_SOCIAL_WEIXIN_PROCESS_URL = "/qqLogin";

    /**
     * 提供商的ID
     */
    String DEFAULT_SOCIAL_QQ_PROVIDER_ID = "qq";
    /**
     * 提供商的ID
     */
    String DEFAULT_SOCIAL_WEIXIN_PROVIDER_ID = "weixin";

    /**
     * 默认的主页测
     */
    String DEFAULT_SIGNUP_URL = "/register";

    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";

}
