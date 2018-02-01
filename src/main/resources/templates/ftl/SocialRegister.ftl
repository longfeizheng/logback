<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>社交账号注册绑定界面</title>
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
							<img src="${user.headImg!''}">
						</div>
						<form action="/user/register" method="post">
							
							<div class="form_text_ipt">
								<input name="username" type="text" placeholder="用户名">
							</div>
							<div class="ececk_warning"><span>用户名</span></div>
							<div class="form_text_ipt">
								<input name="password" type="password" value="123456" placeholder="密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_btn">
								<button type="submit" id="regist">注册</button>
							</div>
							<div class="form_btn">
								<button type="submit" id="binding">绑定</button>
							</div>
                            <div class="form_reg_btn">
								<span>&nbsp;</span>
                            </div>
						</form>
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
