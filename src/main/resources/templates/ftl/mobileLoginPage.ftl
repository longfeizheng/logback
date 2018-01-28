<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>短信登录</title>
    <link rel="stylesheet" href="${re.contextPath}/css/reset.css"/>
    <link rel="stylesheet" href="${re.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${re.contextPath}/css/font-awesome.min.css"/>
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
                <form action="${re.contextPath}/authentication/mobile" method="post">

                    <div class="form_text_ipt">
                        <input name="mobile" type="text" placeholder="手机号" value="18512345678">
                    </div>
                    <div class="ececk_warning"><span>手机号不能为空</span></div>
                    <div class="_warning"><span>${message!''}</span></div>
                    <div class="form_text_ipt">
                        <input name="smsCode" type="smsCode" placeholder="验证码">
                    </div>
                    <div class="ececk_warning"><span>验证码</span></div>
                    </div>
                    <div class="form_check_ipt">
                        <div class="left check_left">
                            <label><input name="" type="checkbox"> 下次自动登录</label>
                        </div>
                        <div class="right check_right">
                            <a href="#" onclick="sendSms()">发送验证码</a>
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
                        <span>其它登录方式</span>
                    </div>
                    <div class="right other_right">
                        <a href="${re.contextPath}/login/qq"><i class="fa fa-qq fa-2x"></i></a>
                        <a href="${re.contextPath}/login/weixin"><i class="fa fa-weixin fa-2x"></i></a>
                        <a href="#"><i class="fa fa-weibo fa-2x"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script>
    $(function(){

    });
    function sendSms(){
        $.get("/code/sms?mobile=18512345678");
    }
</script>
</body>
</html>
