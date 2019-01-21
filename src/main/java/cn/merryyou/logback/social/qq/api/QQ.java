package cn.merryyou.logback.social.qq.api;

/**
 * Created on 2018/1/8 0008.
 * 定义返回用户信息接口
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public interface QQ {
    /**
     * 获取用户信息
     * @return
     */
    QQUserInfo getUserInfo();
}
