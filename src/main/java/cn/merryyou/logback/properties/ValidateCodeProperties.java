package cn.merryyou.logback.properties;

import lombok.Data;

/**
 * Created on 2018/1/10.
 *
 * @author zlf
 * @since 1.0
 */
@Data
public class ValidateCodeProperties {
    /**
     * 图片验证码配置
     */
    private ImageCodeProperties image = new ImageCodeProperties();
    /**
     * 短信验证码配置
     */
    private SmsCodeProperties sms = new SmsCodeProperties();
}
