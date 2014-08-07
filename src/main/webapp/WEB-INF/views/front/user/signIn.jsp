<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>诚途登录</title>
<link href="<%=request.getContextPath() %>/front/static/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/l_login.css" rel="stylesheet" type="text/css" />
</head>

<body>

<jsp:include page="../common/header.jsp"/>

<div class="container">
<div class="w1000">
	
	<div class="content_z">
		<div class="login">
			<div class="loginA"><img src="<%=request.getContextPath() %>/front/static/img/login_03.jpg" /></div>
			<div class="loginB">
				<div class="loginB_z">
				<div class="loginB_n">
					<div class="loginB_a">登录诚途</div>
					<span class="login_error_tip" id="login_error_tip"><i class="login_sp login_v_error"></i>请输入邮箱/手机号/用户名</span>
					<form id="loginform" method="post" action="<%=request.getContextPath() %>/user/signIn.htm">
					<div class="loginB_b">
						<div class="loginB_ba">
							<input id="loginName" name="identity" type="text" />
							<i class="login_sp login_v_pass" style="display: none;"></i>
							<p class="login_input_info" style="display: block;">邮箱/手机号/用户名</p>
						</div>
						<div class="loginB_ba">
							<input id="password" name="password" type="password" />
							<i class="login_sp login_v_pass"></i>
							<p class="login_input_info">请输入密码</p>
						</div>
						<div class="loginB_bb">
							<input  id="sso_verifycode1" name="authenticationCode" type="text" class="yhzcLB_c" />
							<span><img id="image" src="<%=request.getContextPath() %>/common/genVerifyCode.htm" />
							<a href="#" class="link_blue" onClick="refreshCheckCode('image');return false;">换一张</a>
						</div>
						<div class="loginB_bc">
							<input id="loginBtn" name="" type="image" src="<%=request.getContextPath() %>/front/static/img/login_15.jpg" />
							<a href="<%=request.getContextPath() %>/user/goFindPassword.htm">忘记密码</a>
						</div>
					</div>
					</form>
					<div class="loginB_c">
						<div class="loginB_ca">还不是诚途会员？<a href="<%=request.getContextPath() %>/user/goSignUpByEmail.htm">免费注册</a></div>
						<div class="loginB_cb">
							<div class="loginB_cba">使用合作网站账号登录</div> 
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_19.jpg" /></span><a href="#">QQ</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_21.jpg" /></span><a href="#">腾讯微博</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_23.jpg" /></span><a href="#">百度</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_29.jpg" /></span><a href="#">新浪微博</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_32.jpg" /></span><a href="#">支付宝</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_34.jpg" /></span><a href="#">开心网</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_36.jpg" /></span><a href="#">盛大</a></div>
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	
</div>
</div>

<jsp:include page="../common/footer.jsp"/>

<script src="<%=request.getContextPath() %>/front/static/js/jquery-1.7.2.js"></script>
<script src="<%=request.getContextPath() %>/front/static/js/chengtuUI.js"></script>
<script src="<%=request.getContextPath() %>/front/static/js/l_login.js"></script>

<script>

function refreshCheckCode(s) {
    var elt = document.getElementById(s);
    elt.src = elt.src + "?_=" + (new Date).getTime();
}

//判断验证码是否正确
function sso_verifycode1_callback(call){
	$.ajax({
		type: "POST",
		url:  "<%=request.getContextPath()%>/common/checkVerifyCode.htm",
		data: {
			authenticationCode: this.value
		},
		dataType: "json",
		success: function(response) {
			if (response.success == "false") {
				error_tip("#sso_verifycode1","验证码输入错误",":last");  
			} else {
				call();
			}
		}
	});				
}		

function loginSubmit(){
	document.getElementById("loginform").submit();
}

</script>


</body>
</html>
