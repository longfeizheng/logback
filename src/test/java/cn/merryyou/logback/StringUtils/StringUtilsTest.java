package cn.merryyou.logback.StringUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created on 2018/1/4.
 *
 * @author zlf
 * @since 1.0
 */
public class StringUtilsTest {

    private String message = "org.spring.:坏的凭证";

    @Test
    public void test(){
        System.out.println(StringUtils.substringAfter(message,":"));
    }
}
