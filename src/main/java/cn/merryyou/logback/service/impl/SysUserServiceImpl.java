package cn.merryyou.logback.service.impl;

import cn.merryyou.logback.domain.SysUser;
import cn.merryyou.logback.repository.SysUserRepository;
import cn.merryyou.logback.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created on 2018/2/1 0001.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public SysUser save(SysUser user) {
        user.setDelFlag("0");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
