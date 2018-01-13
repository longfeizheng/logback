<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <link rel="stylesheet" href="/css/reset.css"/>
    <link rel="stylesheet" href="/css/common.css"/>
    <link rel="stylesheet" href="/css/font-awesome.min.css"/>
</head>
<body>
<div class="wrap login_wrap">
    <div class="content">
        <div class="logo"></div>
        <div class="login_box">

            <div class="login_form">
                <div class="login_title">
                    登录
                </div>
                <form action="/authentication/form" method="post">

                    <div class="form_text_ipt">
                        <input name="username" type="text" placeholder="手机号/邮箱" value="admin">
                    </div>
                    <div class="ececk_warning"><span>手机号/邮箱不能为空</span></div>
                    <div class="_warning"><span>${message!''}</span></div>
                    <div class="form_text_ipt">
                        <input name="password" type="password" placeholder="密码" value="123456">
                    </div>
                    <div class="ececk_warning"><span>密码不能为空</span></div>
                    <div class="form_text_ipt">
                        <input style="width: 150px;" name="imageCode" type="text" placeholder="验证码">
                        <img src="/code/image" onclick="javascript:this.src='/code/image?random='+Math.random()">
                    </div>
                    <div class="ececk_warning"><span>验证码不能为空</span></div>
                    <div class="_warning"><span>${codeMessage!''}</span></div>
                    <div class="form_check_ipt">
                        <div class="left check_left">
                            <label><input name="remember-me" type="checkbox"> 下次自动登录</label>
                        </div>
                        <div class="right check_right">
                            <a href="#">忘记密码</a>
                        </div>
                    </div>
                    <div class="form_btn">
                        <button type="submit">登录</button>
                    </div>
                    <div class="form_reg_btn">
                        <span>还没有帐号？</span><a href="/register">马上注册</a>
                    </div>
                </form>
                <div class="other_login">
                    <div class="left other_left">
                        <span>其它登录方式</span>&nbsp;&nbsp;<a href="/authentication/mobilePage">短信登录</a>
                    </div>
                    <div class="right other_right">
                        <a href="/login/qq"><i class="fa fa-qq fa-2x"></i></a>
                        <a href="/login/weixin"><i class="fa fa-weixin fa-2x"></i></a>
                        <a href="/login/weibo"><i class="fa fa-weibo fa-2x"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
</body>
</html>
