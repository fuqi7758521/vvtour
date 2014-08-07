<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-邮箱找回密码</title>
<link href="<%=request.getContextPath() %>/front/static/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/l_login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
<div class="w1000">
	
	<div class="content_z">
		<div class="zhmm">
			<div class="zhmmA">
				<span>邮箱找回密码</span>
				<ul>
					<li><a href="#"><img src="<%=request.getContextPath() %>/front/static/img/zhmm_03.jpg" />选择找回密码方式</a></li><span>></span>
					<li><a href="#"><img src="<%=request.getContextPath() %>/front/static/img/zhmm_05.jpg" />输入注册账号</a></li><span>></span>
					<li><a href="#"><img src="<%=request.getContextPath() %>/front/static/img/zhmm_07.jpg" />设置新密码</a></li>
				</ul>
			</div>
			<div class="zhmmB">
				<div class="zhmmB_z">
					<ul>
						<form id="findPasswordForm" method="post" action="<%=request.getContextPath() %>/user/findPasswordByEmail.htm">
							<li><span>Email</span><input id="sso_email_c" name="email" type="text" class="zhmmB_za"/></li>
							<li><span>验证码</span><input id="sso_verifycode1" type="text" class="zhmmB_zb"/>
								<div class="zhmmB_zc">
									<img id="image" src="<%=request.getContextPath() %>/common/genVerifyCode.htm" />
									<a href="javascript:;" class="link_blue" onClick="refreshCheckCode('image');return false;">换一张</a>
								</div>
							</li>
							<li><span></span>
							<a href="javascript:;" id="submitBtn" class="submit"></a>
							<%-- <input id="submitBtn" type="image" src="<%=request.getContextPath() %>/front/static/img/zhmm_06.jpg"/> --%>
							</li>
						</form>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
</div>
</div>

<jsp:include page="../common/footer.jsp"/>
<script src="<%=request.getContextPath() %>/front/static/js/jquery-1.7.2.js"></script>
<script src="<%=request.getContextPath() %>/front/static/js/chengtuUI.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/front/static/js/form.validate.js"></script>
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

function validate_pass(){
	$("#findPasswordForm").submit();
}
</script>

</body>
</html>
