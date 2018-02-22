package cn.merryyou.logback.service.impl;

import cn.merryyou.logback.domain.Result;
import cn.merryyou.logback.domain.SysUser;
import cn.merryyou.logback.dto.UserDto;
import cn.merryyou.logback.enums.ResultEnum;
import cn.merryyou.logback.properties.SecurityConstants;
import cn.merryyou.logback.repository.SysUserRepository;
import cn.merryyou.logback.service.SysUserService;
import cn.merryyou.logback.utils.ResultUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018/2/1 0001.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public SysUser save(SysUser user) {
        user.setDelFlag("0");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtoList = new ArrayList<>();
        UserDto userDto;
        List<SysUser> userList = userRepository.findAll();
        for (SysUser user : userList) {
            userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @Override
    public UserDto findOne(String id) {

        SysUser sysUser = userRepository.findOne(id);
        if (sysUser != null) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(sysUser, userDto);
            return userDto;
        }
        return null;
    }

    @Override
    public UserDto save(String data) {
        List<UserDto> userDtoList = new Gson().fromJson(data,
                new TypeToken<List<UserDto>>() {
                }.getType());
        UserDto userDto = userDtoList.get(0);
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setPassword(bCryptPasswordEncoder.encode(SecurityConstants.DEFAULT_PASSWORD));
        SysUser user = userRepository.save(sysUser);
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public Result<String> delUsers(String ids) {
        if (StringUtils.isEmpty(ids)) return ResultUtil.error(ResultEnum.FAIL.getCode(), "请选择要删除的行！");
        String[] userIds = ids.split(",");
        for (String id : userIds) {
            userRepository.delete(id);
        }
        return ResultUtil.success("删除成功！");
    }
}
