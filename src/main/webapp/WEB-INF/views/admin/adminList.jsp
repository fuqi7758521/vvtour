<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/basic.js" charset="UTF-8"></script>
<script type="text/javascript">
	function lockAdmin(id){
		if(confirm("确定要屏蔽该管理员吗？屏蔽后将不能使用")){
			toUrl("/admin/lockAdmin.htm?id="+id);
		}
	}
	
	function authAdmin(id){
		if(confirm("确定要审核通过吗？")){
			toUrl("/admin/authAdmin.htm?id="+id);
		}
	}
</script>
</head>
<body>
<div align="center">
<c:if test="${empty adminList}">
	列表暂时没有信息
</c:if>

<c:forEach var="item" items="${adminList}" varStatus="status">
	${item.real_name}，${item.admin_name} ==============>>状态:
	<c:if test="${item.status == 0}">未审核</c:if><c:if test="${item.status == 1}">正常</c:if>
	||角色：<c:if test="${item.rank == 0}">普通管理员</c:if><c:if test="${item.rank == 1}">超级管理员</c:if>
	||<a href="javascript:void(0);" onclick="lockAdmin(${item.admin_id})">屏蔽</a>
	<c:if test="${item.status != 1}">
	|<a href="javascript:void(0);" onclick="authAdmin(${item.admin_id})">审核通过</a>
	</c:if>
	<br/>
</c:forEach>

<c:if test="${empty adminList}">
		${errorMsg}
</c:if>
</div>
</body>
</html>