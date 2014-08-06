<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录密码修改结果</title>
<link href="<%=request.getContextPath() %>/front/static/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<jsp:include page="../common/header.jsp"/>

<div class="container">
<div class="w1000">
	<div class="nav">
		<a href="#">我的诚途</a> > <a href="#">我的信息</a>
	</div>
	
	<div class="content">
		
		<jsp:include page="../common/sidebar.jsp"/>
		
		<div class="right">
			<div class="xgmm">
				<div class="xgmmA"><span>登录密码修改</span></div>
				<div class="xgmmN">
					<div class="xgmmB">
						<img src="<%=request.getContextPath() %>/front/static/img/grzl_06.jpg" />
						修改登录密码后，原密码将不能用来登录。
					</div>
					<div class="xgmmC">
						${msg}
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="about">
		<div class="about_n">
			<div class="about_a"><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_63.jpg" /></span><strong>订购指南</strong></div>
			<div class="about_b">
				<ul>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
				</ul>
			</div>
		</div>
		<div class="about_n">
			<div class="about_a"><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_66.jpg" /></span><strong>注册与登录</strong></div>
			<div class="about_b">
				<ul>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
				</ul>
			</div>
		</div>
		<div class="about_n">
			<div class="about_a"><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_69.jpg" /></span><strong>支付与取票</strong></div>
			<div class="about_b">
				<ul>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
				</ul>
			</div>
		</div>
		<div class="about_n">
			<div class="about_a"><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_72.jpg" /></span><strong>沟通与订阅</strong></div>
			<div class="about_b">
				<ul>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
					<li><a href="#">门票订购流程是怎样的？</a></li>
				</ul>
			</div>
		</div>
	</div>
	
</div>
</div>

<jsp:include page="../common/footer.jsp"/>
</body>
</html>
