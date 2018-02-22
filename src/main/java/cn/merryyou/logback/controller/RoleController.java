package cn.merryyou.logback.controller;

import cn.merryyou.logback.domain.PageResult;
import cn.merryyou.logback.dto.RoleDto;
import cn.merryyou.logback.service.SysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created on 2018/2/22 0022.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Controller
@Slf4j
public class RoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("/role/showRole")
    public ModelAndView userListView() {
        return new ModelAndView("/role/roleList");
    }

    @PostMapping("/role/roleList")
    @ResponseBody
    public PageResult roleList() {
        List<RoleDto> roleList = sysRoleService.findAlls();
        PageResult pageResult = new PageResult();
        pageResult.setData(roleList);
        pageResult.setTotal(String.valueOf(roleList.size()));
        return pageResult;
    }

    @GetMapping("/role/addRole")
    public ModelAndView addUserView() {
        return new ModelAndView("/role/roleAdd");
    }

}
