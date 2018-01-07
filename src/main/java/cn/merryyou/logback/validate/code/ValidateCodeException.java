package cn.merryyou.logback.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * Created on 2018/1/7 0007.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class ValidateCodeException extends AuthenticationException {
    private static final long serialVersionUID = -7525757620869234981L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
