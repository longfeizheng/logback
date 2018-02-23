package cn.merryyou.logback.service;

import cn.merryyou.logback.domain.Result;
import cn.merryyou.logback.domain.SysRole;
import cn.merryyou.logback.dto.RoleDto;

import java.util.List;

/**
 * Created on 2018/2/9.
 *
 * @author zlf
 * @since 1.0
 */
public interface SysRoleService extends MerryyouBaseService<SysRole>{

    List<RoleDto> findAlls();

    Result saveRole(String data);

    RoleDto findRole(String id);

    Result<String> delRoles(String ids);
}
