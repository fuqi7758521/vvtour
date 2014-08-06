<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-注册成功</title>
<link href="<%=request.getContextPath() %>/front/static/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
<div class="w1000">
	
	<div class="content_z">
		<div class="zccg">
			<div class="zccg_z">
				<div class="zccg_a"><img src="<%=request.getContextPath() %>/front/static/img/zccg_03.jpg" />恭喜，注册成功。您获得了<span>100积分</span>的奖励</div>
				<div class="zccg_n">
					<div class="zccg_b">
						<ul>
							<li><img src="<%=request.getContextPath() %>/front/static/img/yzyx_04.jpg" />您的注册手机号为：${mobile}</li>
							<li><img src="<%=request.getContextPath() %>/front/static/img/yzyx_04.jpg" />手机号可用来登录、找回密码、订购产品。</li>
						</ul>
					</div>
					<%-- <div class="zccg_c">
						<div class="zccg_ca">我们已向您的邮箱发送一封验证邮件，验证邮箱成功后将获得300积分奖励。</div>
						<div class="zccg_cb">
							<input name="" type="image" src="<%=request.getContextPath() %>/front/static/img/zccg_07.jpg" />
							没有收到？<a href="#">再次发送</a>
						</div>
					</div> --%>
					<div class="zccg_d">您现在要去：<a href="#">返回首页</a></div>
				</div>
			</div>
		</div>
	</div>
	
</div>
</div>

<jsp:include page="../common/footer.jsp"/>

</body>
</html>
