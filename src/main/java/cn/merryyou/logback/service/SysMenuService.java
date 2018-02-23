package cn.merryyou.logback.service;

import cn.merryyou.logback.dto.MenuDto;

import java.util.List;

/**
 * Created on 2018/2/8.
 *
 * @author zlf
 * @since 1.0
 */
public interface SysMenuService {
    List<MenuDto> getMenus();

    List<MenuDto> getMenusList();

    List<MenuDto> getMenusListByRole(String roleId);
}
