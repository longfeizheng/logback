<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>注册界面</title>
		<link rel="stylesheet" href="${re.contextPath}css/reset.css" />
		<link rel="stylesheet" href="${re.contextPath}css/common.css" />
		<link rel="stylesheet" href="${re.contextPath}css/font-awesome.min.css" />
	</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
				
				<div class="logo"></div>
				
				<div class="login_box">	
					
					<div class="login_form">
						<div class="login_title">
							注册
						</div>
						<form action="/authentication/register" method="post">
							
							<div class="form_text_ipt">
								<input name="username" type="text" placeholder="手机号/邮箱">
							</div>
							<div class="ececk_warning"><span>手机号/邮箱不能为空</span></div>
							<div class="form_text_ipt">
								<input name="password" type="password" placeholder="密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_text_ipt">
								<input name="repassword" type="password" placeholder="重复密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_text_ipt">
								<input name="code" type="text" placeholder="验证码">
							</div>
							<div class="ececk_warning"><span>验证码不能为空</span></div>
							
							<div class="form_btn">
								<button type="submit">注册</button>
							</div>
							<div class="form_reg_btn">
								<span>已有帐号？</span><a href="/">马上登录</a>
							</div>
						</form>
						<div class="other_login">
							<div class="left other_left">
								<span>其它登录方式</span>
							</div>
							<div class="right other_right">
								<a href="${re.contextPath}/login/qq"><i class="fa fa-qq fa-2x"></i></a>
								<a href="${re.contextPath}/login/weixin"><i class="fa fa-weixin fa-2x"></i></a>
								<a href="${re.contextPath}/login/weibo"><i class="fa fa-weibo fa-2x"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="${re.contextPath}js/jquery.min.js" ></script>
		<script type="text/javascript" src="${re.contextPath}js/common.js" ></script>
		<script>
			$(function(){
			});
		</script>
	</body>
</html>
