package cn.merryyou.logback.service.impl;

import cn.merryyou.logback.dto.MenuDto;
import cn.merryyou.logback.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

/**
 * Created on 2018/2/8.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysMenuServiceImplTest {

    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void getMenusTest() throws Exception {
        List<MenuDto> menus = sysMenuService.getMenus("admin", 0);
        log.info(menus.toString());
    }

    @Test
    public void getMenusListTest() throws Exception {
        List<MenuDto> menusList = sysMenuService.getMenusList();
        System.out.println(menusList.size());
    }

    @Test
    public void getPermissionsTest() throws Exception {
        String permissions = sysMenuService.getPermissions("admin");
        log.info(permissions);

    }

    @Test
    public void getUrlBynameTest() throws Exception {
        Set<String> admin = sysMenuService.getUrlByname("admin");
        System.out.println(admin.size());
    }
}