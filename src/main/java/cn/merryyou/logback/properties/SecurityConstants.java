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

}
