package cn.merryyou.logback.validate.code.sms;

/**
 * 短信发送接口
 * Created on 2018/1/10.
 *
 * @author zlf
 * @since 1.0
 */
public interface SmsCodeSender {

    /**
     * 发送短信验证码
     * @param mobile
     * @param code
     */
    void send(String mobile, String code);
}
