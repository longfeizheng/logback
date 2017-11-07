package cn.merryyou.logback.domain;

import lombok.Data;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@Data
public class Result<T> {
    private Integer code;
    private String msg;

    private T data;
}
