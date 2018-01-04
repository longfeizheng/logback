package cn.merryyou.logback.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created on 2018/1/4.
 *
 * @author zlf
 * @since 1.0
 */
public class StringsUtils {

    public static boolean isNotNull(String string){
        return StringUtils.isNotEmpty(string)&&!"null".equals(string);
    }
}
