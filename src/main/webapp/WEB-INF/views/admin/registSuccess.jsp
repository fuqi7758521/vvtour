<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
<div align="center">
<c:choose>
	<c:when test="${empty admin.admin_id}">
		${errorMsg}
	</c:when>
	<c:otherwise>
		恭喜,${admin.real_name}注册成功！稍后管理员会对您的申请进行审核。
	</c:otherwise>
</c:choose>
</div>
</body>
</html>