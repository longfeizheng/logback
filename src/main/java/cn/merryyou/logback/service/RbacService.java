package cn.merryyou.logback.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Created on 2018/1/29 0029.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface RbacService {
    /**
     * 用于判断有该权限
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
