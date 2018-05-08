package cn.merryyou.logback.repository;

import cn.merryyou.logback.domain.SysUser;

/**
 * Created on 2018/1/28 0028.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface SysUserRepository extends MerryyouRepository<SysUser> {
    /**
     * 用户名查找
     * @param username
     * @return
     */
    SysUser findByUsername(String username);

    /**
     * 手机号查找
     * @param mobile
     * @return
     */
    SysUser findByMobile(String mobile);

    /**
     * 用户名或手机号
     * @param username
     * @param mobile
     * @return
     */
    SysUser findByUsernameOrMobile(String username,String mobile);

}
