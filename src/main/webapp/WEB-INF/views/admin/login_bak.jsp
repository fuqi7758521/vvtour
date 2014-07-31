<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
</head>
<body>
<div align="center">
<form method="post" action="<c:url value="doLogin.htm"/>">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="admin_name"/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="text" name="password"/></td>
		</tr>
		<tr>
			<td>验证码：</td>
			<td><input type="text" name="pinCode"/></td>
		</tr>
		<!-- 
		<tr>
			<td colspan="2">
				 <jsp:include page="/common/verificationCode.jsp"></jsp:include><a href="javascript:void(0);">看不清换一张？</a>
			</td>
		</tr>
		 -->
		<tr>
			<td colspan="2"><input type="submit" name="提交"/></td>
		</tr>
	</table>
</form>
${errorMsg}
</div>
</body>
</html>