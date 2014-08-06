<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-修改密码</title>
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
		<div class="left">
			<div class="leftA">
				<div class="leftA_a"><a href="#"><img src="<%=request.getContextPath() %>/front/static/img/grzx_03.jpg" /></a></div>
				<div class="leftA_b"><a href="#">编辑我的资料</a></div>
			</div>
			<div class="leftB">
				<ul>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_18.jpg" /></span><a href="#">我的订单</a></li>
					<li><span>&nbsp;</span><a href="#">国际机票订单</a></li>
				</ul>
				<ul>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_30.jpg" /></span><a href="#">我的积分</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_34.jpg" /></span><a href="#">我的优惠券</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_36.jpg" /></span><a href="#">现金账户</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_38.jpg" /></span><a href="#">礼品卡</a></li>
				</ul>
				<ul>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_40.jpg" /></span><a href="#">个人资料</a><a href="#" style=" float:right; color:#0088cc;">完善</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_42.jpg" /></span><a href="#">登录密码修改</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_44.jpg" /></span><a href="#">常用游客信息</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_46.jpg" /></span><a href="#">站内信息</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_48.jpg" /></span><a href="#">邮件订阅</a></li>
				</ul>
				<ul style="border-bottom:none;">
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_50.jpg" /></span><a href="#">我的点评</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_52.jpg" /></span><a href="#">我的攻略</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_54.jpg" /></span><a href="#">我的收藏</a></li>
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_56.jpg" /></span><a href="#">我的旅程</a></li>
				</ul>
			</div>
			<div class="leftC"><a href="#"><img src="<%=request.getContextPath() %>/front/static/img/grzx_59.jpg" /></a></div>
		</div>
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
