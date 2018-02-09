package cn.merryyou.logback.domain;

import lombok.Data;

/**
 * Created on 2018/2/9.
 *
 * @author zlf
 * @since 1.0
 */
@Data
public class PageResult<T> {
    private String total;

    private T data;
}
