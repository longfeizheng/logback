package cn.merryyou.logback.social.weixin.api;

/**
 * https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419316518&token=2d3bbb7b39c63ab8196e7aad045811f2d47e8602&lang=zh_CN
 * https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
 * 微信API调用接口
 * Created on 2018/1/11.
 *
 * @author zlf
 * @since 1.0
 */
public interface Weixin {
    WeixinUserInfo getUserInfo(String openId);
}
