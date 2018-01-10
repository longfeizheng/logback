package cn.merryyou.logback.validate.code;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 验证码信息封装类
 * Created on 2018/1/10.
 *
 * @author zlf
 * @since 1.0
 */
public class ValidateCode implements Serializable {

    private static final long serialVersionUID = -1968088775733266974L;

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    public String getCode() {
        return code;
    }

    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
