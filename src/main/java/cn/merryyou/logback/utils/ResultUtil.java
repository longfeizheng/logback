package cn.merryyou.logback.utils;

import cn.merryyou.logback.domain.Result;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
