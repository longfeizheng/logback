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
    String DEFAULT_SOCIAL_WEIXIN_APP_ID = "wxfd6965ab1fc6adb2";

    /**
     * weixin appsECRET
     */
    String DEFAULT_SOCIAL_WEIXIN_APP_SECRET = "66bb4566de776ac699ec1dbed0cc3dd1";

    /**
     * qq appID
     */
    String DEFAULT_SOCIAL_QQ_APP_ID = "101448999";

    /**
     * qq appsECRET
     */
    String DEFAULT_SOCIAL_QQ_APP_SECRET = "1d958787a87559bad371c0a9e26eef61";

    /**
     * weibo appID
     */
    String DEFAULT_SOCIAL_WEIBO_APP_ID = "491608476";

    /**
     * weibo appsECRET
     */
    String DEFAULT_SOCIAL_WEIBO_APP_SECRET = "b2dd0d4199ddc9d64e75d9dd6007ca82";

    /**
     *自定义社交social拦截地址  默认/auth  (SocialAuthenticationFilter)
     */
    String DEFAULT_SOCIAL_PROCESS_URL = "/login";

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

    /**
     * session失效默认的跳转地址
     */
    String DEFAULT_SESSION_INVALID_URL = "/merryyou-session-invalid.html";

    /**
     * 默认用户密码
     */
    String DEFAULT_PASSWORD="123456";
}
