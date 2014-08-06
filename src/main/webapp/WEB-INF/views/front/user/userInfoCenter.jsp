<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-个人中心页面</title>
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
					<li><span><img src="<%=request.getContextPath() %>/front/static/img/grzx_42.jpg" /></span><a href="<%=request.getContextPath() %>//user/goChangePassword.htm">登录密码修改</a></li>
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
			<div class="leftC"><a href="#"><img src="img/grzx_59.jpg" /></a></div>
		</div>
		<div class="right">
			<div class="grzx">
				<div class="grzxL">
					<div class="grzxA">
						<div class="grzxA_a"><strong>hellowuyao</strong>,欢迎来到驴妈妈！</div>
						<div class="grzxA_b">
							<span>登录邮箱：11020***@qq.com(已验证)</span>  <span>手机号：未绑定</span>
							<input name="" type="image" src="<%=request.getContextPath() %>/front/static/img/grzx_08.jpg" />
						</div>
					</div>
					<div class="grzxB">
						<ul>
							<li>
								<h3>交易提醒：</h3>
								<a href="#">待支付订单<span>(0)</span></a>
							</li>
							<li>
								<h3>消息提醒：</h3>
								<a href="#">可用积分<span>(400)</span></a>
								<a href="#">可用优惠券<span>(0)</span></a>
								<a href="#">待点评<span>(0)</span></a>
								<a href="#"><img src="<%=request.getContextPath() %>/front/static/img/grzx_12.jpg" />站内消息<span>(0)</span></a>
							</li>
						</ul>
					</div>
				</div>
				<div class="grzxR"><img src="img/grzx_05.jpg" /></div>
			</div>
			<div class="jqdd">
				<div class="jqddA">
					<span>近期订单</span>
					<a href="#">查看所有订单>></a>
				</div>
				<div class="jqddB">
					<div class="jqddB_a">产品名称</div>
					<div class="jqddB_b">金额（元）</div>
					<div class="jqddB_b">订单状态</div>
					<div class="jqddB_b">合同状态</div>
					<div class="jqddB_b">操作</div>
					<div class="jqddB_b">其他操作</div>
				</div>
				<div class="jqddC">
					<div class="jqddC_a">
						<div class="jqddC_aa"><input name="" type="checkbox" value="" />全选</div>
						<div class="jqddC_ab">
							<a href="#"><img src="<%=request.getContextPath() %>/front/static/img/grzx_26.jpg" /></a>
							<a href="#"><img src="<%=request.getContextPath() %>/front/static/img/grzx_28.jpg" /></a>
						</div>
					</div>
				</div>
				<div class="jqddD">您近期还没有提交过订单</div>
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
