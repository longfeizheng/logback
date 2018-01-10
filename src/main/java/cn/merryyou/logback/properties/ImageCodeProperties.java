package cn.merryyou.logback.properties;

import lombok.Data;
/**
 * Created on 2018/1/10.
 *
 * @author zlf
 * @since 1.0
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties {
    public ImageCodeProperties() {
        setLength(4);
    }

    /**
     * 图片宽
     */
    private int width = 67;
    /**
     * 图片高
     */
    private int height = 23;

}
