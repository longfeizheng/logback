package cn.merryyou.logback.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created on 2018/1/4.
 *
 * @author zlf
 * @since 1.0
 */
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("【MyUserDetailsService】 loadUserByUsername 表单登录用户名  username={}", username);

        return new User(username,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));
    }
}
