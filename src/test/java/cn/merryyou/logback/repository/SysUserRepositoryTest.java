package cn.merryyou.logback.repository;

import cn.merryyou.logback.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2018/1/28 0028.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysUserRepositoryTest {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysUserRepository repository;

    @Test
    public void findOneTest() throws Exception {
        SysUser user = repository.findOne("acfc0e9232f54732a5d9ffe9071bf572");
        log.info("【SysUser】 SysUser={}", user);
    }

    @Test
    public void findByUsernameTest() throws Exception {
        SysUser user = repository.findByUsername("admin");
        log.info("【SysUser】 SysUser={}", user);
    }

    @Test
    public void saveSysUserTest() throws Exception {
        SysUser user = new SysUser();
        user.setUsername("test");
        user.setPassword(bCryptPasswordEncoder.encode("123456"));
        user.setDelFlag("0");
        SysUser sysUser = repository.save(user);
        log.info(sysUser.toString());
    }
}