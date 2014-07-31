<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>诚途旅游网站管理后台</title>
<link href="/js/admin_login/css/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
		<form method="post" action="<c:url value="doLogin.htm"/>">
			<div class="log">
				<div class="name">
					<label>用户名</label><input type="text" class="text" id="admin_name" name="admin_name" tabindex="1">
				</div>
				<div class="pwd">
					<label>密　码</label><input type="password" class="text" id="password" name="password" tabindex="2">
					<input type="submit" class="submit" tabindex="3" value="登录"><input type="hidden" name="pinCode"/>
					<div class="check"></div>
				</div>
				<div class="tip"></div>
			</div>
		</form>
		</div>
	</div>
    <div class="air-balloon ab-1 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/admin_login/js/fun.base.js"></script>
<script type="text/javascript" src="/js/admin_login/js/script.js"></script>


<!--[if IE 6]>
<script src="js/DD_belatedPNG.js" type="text/javascript"></script>
<script>DD_belatedPNG.fix('.png')</script>
<![endif]-->
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
<p>Copyright：<a href="http://www.chengtour.com/" target="_blank">诚途旅游网</a> ${errorMsg}</p>
</div>
</body>
</html>