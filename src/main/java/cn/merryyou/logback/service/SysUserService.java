package cn.merryyou.logback.service;

import cn.merryyou.logback.domain.SysUser;

/**
 * Created on 2018/2/1 0001.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface SysUserService {

    SysUser save(SysUser user);

    SysUser findByUsername(String username);
}
