package cn.merryyou.logback.service.impl;

import cn.merryyou.logback.domain.SysMenu;
import cn.merryyou.logback.domain.SysRole;
import cn.merryyou.logback.dto.MenuDto;
import cn.merryyou.logback.repository.SysMenuRepository;
import cn.merryyou.logback.repository.SysRoleRepository;
import cn.merryyou.logback.service.SysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/2/8.
 *
 * @author zlf
 * @since 1.0
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuRepository repository;

    @Autowired
    private SysRoleRepository roleRepository;

    @Override
    public List<MenuDto> getMenus() {
        List<MenuDto> menuDtoList = new ArrayList<>();
        List<SysMenu> menuList = repository.findAllByMenuType((byte) 0);
        MenuDto menuDto;
        for (SysMenu sysMenu : menuList) {
            menuDto = new MenuDto();
            BeanUtils.copyProperties(sysMenu, menuDto);
            menuDtoList.add(menuDto);
        }
        return menuDtoList;
    }

    @Override
    public List<MenuDto> getMenusList() {
        List<MenuDto> menuDtoList = new ArrayList<>();
        List<SysMenu> menuList = repository.findAll();
        MenuDto menuDto;
        for (SysMenu sysMenu : menuList) {
            menuDto = new MenuDto();
            BeanUtils.copyProperties(sysMenu, menuDto);
            menuDtoList.add(menuDto);
        }
        return menuDtoList;
    }

    @Override
    public List<MenuDto> getMenusListByRole(String roleId) {
        SysRole sysRole = roleRepository.findOne(roleId);
        List<SysMenu> roleMenus = sysRole.getMenus();
        String menuIds = "";
        if (roleMenus != null && roleMenus.size() > 0) {
            for(int i=0;i<roleMenus.size();i++){
                menuIds += roleMenus.get(i).getId();
            }
        }
        List<MenuDto> menuDtoList = new ArrayList<>();
        List<SysMenu> menuList = repository.findAll();
        MenuDto menuDto;
        for (SysMenu sysMenu : menuList) {
            menuDto = new MenuDto();
            BeanUtils.copyProperties(sysMenu, menuDto);
            if (menuIds.indexOf(menuDto.getId()) >= 0) {
                menuDto.setChecked(true);
            }
            menuDtoList.add(menuDto);
        }
        return menuDtoList;
    }
}
