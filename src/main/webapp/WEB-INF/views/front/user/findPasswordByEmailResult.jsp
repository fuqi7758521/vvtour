<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-邮箱找回密码</title>
<link href="<%=request.getContextPath() %>/front/static/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/style.css" rel="stylesheet" type="text/css" />
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
						${msg}
					</ul>
				</div>
			</div>
		</div>
	</div>
	
</div>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>
