package cn.merryyou.logback.service;

import cn.merryyou.logback.domain.SysUser;
import cn.merryyou.logback.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created on 2018/1/4.
 *
 * @author zlf
 * @since 1.0
 */
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService,SocialUserDetailsService {

    @Autowired
    private SysUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("【MyUserDetailsService】 loadUserByUsername 表单登录用户名  username={}", username);

        SysUser user = repository.findByUsername(username);
//        String password = passwordEncoder.encode("123456");

//        log.info("数据库密码是:password={}",password);
        return user;
//        return new User(username,password, AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));

    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        SysUser user = repository.findByUsername(userId);
//        String password = passwordEncoder.encode("123456");

//        log.info("数据库密码是:password={}",password);
        return user;
//        return new SocialUser(userId,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }
}
