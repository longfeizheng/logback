package cn.merryyou.logback.service;

import cn.merryyou.logback.dto.MenuDto;

import java.util.List;
import java.util.Set;

/**
 * Created on 2018/2/8.
 *
 * @author zlf
 * @since 1.0
 */
public interface SysMenuService {
    List<MenuDto> getMenus(String username,int menuType);

    List<MenuDto> getMenusList();

    Set<String> getUrlByname(String username);

    String getPermissions(String username);

}
