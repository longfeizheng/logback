package cn.merryyou.logback.exception;

import cn.merryyou.logback.enums.ResultEnum;
import lombok.Getter;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@Getter
public class PersonException extends RuntimeException {

    private Integer code;

    public PersonException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public PersonException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
