package cn.merryyou.logback.security;

import cn.merryyou.logback.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import cn.merryyou.logback.authorize.AuthorizeConfigProvider;
import cn.merryyou.logback.config.ClassPathTldsLoader;
import cn.merryyou.logback.properties.SecurityConstants;
import cn.merryyou.logback.properties.SecurityProperties;
import cn.merryyou.logback.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * Created on 2018/1/4.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MerryyouSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthorizeConfigProvider authorizeConfigProvider;

    @Autowired
    private SpringSocialConfigurer merryyouSpringSocialConfigurer;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private InvalidSessionStrategy invalidSessionStrategy;

    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Autowired
    private AuthenticationSuccessHandler merryyouLoginSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler merryyouAuthenticationfailureHandler;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
        http.headers().frameOptions().disable().and()
                .formLogin()//使用表单登录，不再使用默认httpBasic方式
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)//如果请求的URL需要认证则跳转的URL
                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)//处理表单中自定义的登录URL
                .successHandler(merryyouLoginSuccessHandler)//登录成功处理器，返回JSON
                .failureHandler(merryyouAuthenticationfailureHandler)//登录失败处理器
                .and()
                .apply(validateCodeSecurityConfig)//验证码拦截
                .and()
                .apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(merryyouSpringSocialConfigurer)//社交登录
                .and()
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(securityProperties.getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                .sessionManagement()
//                .invalidSessionStrategy(invalidSessionStrategy)
                .invalidSessionUrl("/session/invalid")
                .maximumSessions(securityProperties.getSession().getMaximumSessions())//最大session并发数量1
                .maxSessionsPreventsLogin(securityProperties.getSession().isMaxSessionsPreventsLogin())//之后的登录踢掉之前的登录
                .expiredSessionStrategy(sessionInformationExpiredStrategy)
                .and()
                .and()
                .logout()
                .logoutUrl("/signOut")//默认退出地址/logout
                .logoutSuccessUrl("/")//退出之后跳转到注册页面
                .deleteCookies("JSESSIONID")
                .and()
                .authorizeRequests().antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM,
                SecurityConstants.DEFAULT_REGISTER_URL,
                SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
                SecurityConstants.DEFAULT_SIGN_IN_URL_MOBILE_PAGE,
                "/register",
                "/socialRegister",//社交账号注册和绑定页面
                "/user/register",//处理社交注册请求
                "/social/info",//获取当前社交用户信息
                "/session/invalid",
                "/**/*.js",
                "/**/*.css",
                "/**/*.jpg",
                "/**/*.png",
                "/**/*.woff2",
                "/code/*")
                .permitAll()//以上的请求都不需要认证
                //.antMatchers("/").access("hasRole('USER')")
                .and()
                .csrf().disable()//关闭csrd拦截
        ;
        //安全模块单独配置
        authorizeConfigProvider.config(http.authorizeRequests());
    }

    /**
     * 去除角色中role_的前缀
     * 表达式需要.access("hasRole('ADMIN')");
     *
     * @throws Exception
     */
    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    @ConditionalOnMissingBean(ClassPathTldsLoader.class)
    public ClassPathTldsLoader classPathTldsLoader(){
        return new ClassPathTldsLoader();
    }
}
