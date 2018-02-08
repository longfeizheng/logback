package cn.merryyou.logback.repository;

import cn.merryyou.logback.domain.SysMenu;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created on 2018/2/8.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SysMenuRepositoryTest {

    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Test
    public void findAllOrOrderByOrderNumTest() throws Exception{
        List<SysMenu> menuList = sysMenuRepository.findAllByOrderByOrderNumAsc();
        for(SysMenu sysMenu:menuList){
            log.info(sysMenu.toString());
        }
    }

    @Test
    public void findAllByMenuTypeTest() throws Exception{
        List<SysMenu> menuList = sysMenuRepository.findAllByMenuType((byte)0);
        for(SysMenu sysMenu:menuList){
            log.info(sysMenu.toString());
        }
    }
}