package cn.merryyou.logback.repository;

import cn.merryyou.logback.domain.SysRole;
import cn.merryyou.logback.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

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

    @Autowired
    private SysRoleRepository roleRepository;

    /**
     * 查询用户
     *
     * @throws Exception
     */
    @Test
    public void findOneTest() throws Exception {
        SysUser user = repository.findById("acfc0e9232f54732a5d9ffe9071bf572").get();
        log.info("【SysUser】 SysUser={}", user);
    }

    /**
     * 查询用户所属的角色
     *
     * @throws Exception
     */
    @Test
    public void findRolesByUser() throws Exception {
        SysUser user = repository.findById("acfc0e9232f54732a5d9ffe9071bf572").get();
        List<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            log.info(role.toString());
        }
        log.info("【SysUser】 SysUser={}", user);
    }

    /**
     * 根据角色查询对应的用户
     *
     * @throws Exception
     */
    @Test
    public void findUserByRole() throws Exception {
        SysRole sysRole = roleRepository.findById("0ea934e5e55411e7b983201a068c6482").get();
        List<SysUser> users = sysRole.getUsers();
        for (SysUser user : users) {
            log.info(user.toString());
        }
        log.info(sysRole.toString());
    }

    /**
     * 用户名查询
     *
     * @throws Exception
     */
    @Test
    public void findByUsernameTest() throws Exception {
        SysUser user = repository.findByUsername("admin");
        log.info("【SysUser】 SysUser={}", user);
    }

    /**
     * 新增用户
     *
     * @throws Exception
     */
    @Test
    public void saveSysUserTest() throws Exception {
        SysRole sysRole1 = roleRepository.findById("0ea934e5e55411e7b983201a068c6482").get();
        SysRole sysRole2 = roleRepository.findById("2619a672e53811e7b983201a068c6482").get();
        SysUser user = new SysUser();
        user.setUsername("test");
        user.setPassword(bCryptPasswordEncoder.encode("123456"));
        user.setDelFlag("0");
        user.getRoles().add(sysRole1);
        user.getRoles().add(sysRole2);
        SysUser sysUser = repository.save(user);
        log.info(sysUser.toString());
    }

    @Test
    public void findByUsernameOrMobileTest() throws Exception{
//        SysUser user = repository.findByUsernameOrMobile("admin","");
//        SysUser user = repository.findByUsernameOrMobile("","18512345678");
        SysUser user = repository.findByUsernameOrMobile("18512345678","18512345678");
        log.info("【SysUser】 SysUser={}", user);
    }
}