package cn.merryyou.logback.enums;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
public enum  ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    FAIL(-2, "失败"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    SECKILL_OVER(102,"秒杀结束"),
    CODE_ERROT(103,"验证码验证失败"),
    SESSION_INVALID(104,"session失效"),
    ACCESS_DENIED(105,"您没有该权限！")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
