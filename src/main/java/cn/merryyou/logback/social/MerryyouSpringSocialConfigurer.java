package cn.merryyou.logback.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 继承默认的社交登录配置，加入自定义的后处理逻辑
 * Created on 2018/1/8 0008.
 * 自定义登录和注册连接
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class MerryyouSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public MerryyouSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        filter.setSignupUrl("/socialRegister"); // 没有登录的话，跳转到的页面
        return (T) filter;
    }
}
