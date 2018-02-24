package cn.merryyou.logback.service.impl;

import cn.merryyou.logback.domain.SysMenu;
import cn.merryyou.logback.domain.SysRole;
import cn.merryyou.logback.domain.SysUser;
import cn.merryyou.logback.dto.MenuDto;
import cn.merryyou.logback.repository.SysMenuRepository;
import cn.merryyou.logback.repository.SysRoleRepository;
import cn.merryyou.logback.repository.SysUserRepository;
import cn.merryyou.logback.service.SysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private SysUserRepository userRepository;

    @Autowired
    private SysRoleRepository roleRepository;

    @Override
    public List<MenuDto> getMenus(String username, int menuType) {
        SysUser sysUser = userRepository.findByUsername(username);
        List<SysRole> roles = sysUser.getRoles();
        Set<SysMenu> menuSet = new HashSet<>();
        for (int i = 0; i < roles.size(); i++) {
            List<SysMenu> menus = roles.get(i).getMenus();
            menuSet.addAll(menus);
        }
        List<MenuDto> menuDtoList = new ArrayList<>();
//        List<SysMenu> menuList = repository.findAllByMenuType((byte) 0);
        MenuDto menuDto;
        for (SysMenu sysMenu : menuSet) {
            if (sysMenu.getMenuType() != menuType) {
                continue;
            }
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
    public Set<String> getUrlByname(String username) {
        Set<SysMenu> mesnus = new HashSet<>();
        Set<String> urls = new HashSet<>();
        SysUser sysUser = userRepository.findByUsername(username);
        List<SysRole> roles = sysUser.getRoles();
        if (roles != null && roles.size() > 0) {
            for (SysRole sysRole : roles) {
                mesnus.addAll(sysRole.getMenus());
            }
        }

        for (SysMenu sysMenu : mesnus) {
            urls.add(sysMenu.getUrl());
        }

        return urls;
    }
}
