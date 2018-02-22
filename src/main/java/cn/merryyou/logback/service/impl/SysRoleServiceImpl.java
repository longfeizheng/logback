package cn.merryyou.logback.service.impl;

import cn.merryyou.logback.domain.SysRole;
import cn.merryyou.logback.dto.RoleDto;
import cn.merryyou.logback.repository.SysRoleRepository;
import cn.merryyou.logback.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/2/9.
 *
 * @author zlf
 * @since 1.0
 */
@Service
public class SysRoleServiceImpl extends MerryyouBaseServiceImpl<SysRole> implements SysRoleService {

    @Autowired
    private SysRoleRepository roleRepository;

    @Override
    public List<RoleDto> findAlls() {
        List<RoleDto> roleDtoList = new ArrayList<>();
        RoleDto roleDto;
        List<SysRole> roleList = roleRepository.findAll();
        for (SysRole role : roleList) {
            roleDto = new RoleDto();
            BeanUtils.copyProperties(role, roleDto);
            roleDtoList.add(roleDto);
        }
        return roleDtoList;
    }
}
