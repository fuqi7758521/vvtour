<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-用户登录</title>
<link href="<%=request.getContextPath() %>/front/static/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/static/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="../common/header.jsp"/>

<div class="container">
<div class="w1000">
	
	<div class="content_z">
		<div class="login">
			<div class="loginA"><img src="<%=request.getContextPath() %>/front/static/img/login_03.jpg" /></div>
			<div class="loginB">
				<div class="loginB_z">
				<div class="loginB_n">
					<div class="loginB_a">登录驴妈妈</div>
					<form method="post" action="<%=request.getContextPath() %>/user/signIn.htm">
					<div class="loginB_b">
						<div class="loginB_ba"><input name="identity" type="text" /></div>
						<div class="loginB_ba"><input name="password" type="password" /></div>
						<div class="loginB_bb">
							<input name="" type="text" />
							<span><img src="<%=request.getContextPath() %>/front/static/img/login_11.jpg" />
							<a href="#">换一张</a></span>
						</div>
						<div class="loginB_bc">
							<input name="" type="image" src="<%=request.getContextPath() %>/front/static/img/login_15.jpg" />
							<a href="#">忘记密码</a>
						</div>
					</div>
					</form>
					<div class="loginB_c">
						<div class="loginB_ca">还不是诚途会员？<a href="<%=request.getContextPath() %>/user/goSignUpByEmail.htm">免费注册</a></div>
						<div class="loginB_cb">
							<div class="loginB_cba">使用合作网站账号登录</div> 
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_19.jpg" /></span><a href="#">QQ</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_21.jpg" /></span><a href="#">腾讯微博</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_23.jpg" /></span><a href="#">百度</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_29.jpg" /></span><a href="#">新浪微博</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_32.jpg" /></span><a href="#">支付宝</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_34.jpg" /></span><a href="#">开心网</a></div>
							<div class="loginB_cba"><span><img src="<%=request.getContextPath() %>/front/static/img/login_36.jpg" /></span><a href="#">盛大</a></div>
						</div>
					</div>
				</div>
				</div>
			</div>
		</div>
	</div>
	
</div>
</div>

<div class="foot">
    <div class="foot1">
      <a href="#">关于我们</a> | <a href="#">网站地图</a> | <a href="#">酒店品牌</a> | <a href="#">酒店查询</a> | <a href="#">帮助中心</a> | <a href="#">友情链接</a> | <a href="#">诚聘英才</a> | <a href="#">旅游度假资质</a> | <a href="#">意见反馈</a> | <a href="#">广告业务</a> | <a href="#">用户体验平台</a>
    </div>
    <div class="foot2">Copyright © 2014 www.lvmama.com. 上海景域文化传播有限公司版权所有　沪ICP备13011172号-3　增值电信业务经营许可证编号：沪B2-20100030</div>
    <div class="foot3 mt10">
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_01.png" width="56" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_02.png" width="47" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_03.png" width="49" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_04.png" width="80" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_05.png" width="56" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_06.png" width="48" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_07.png" width="88" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_08.png" width="96" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_09.png" width="48" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/static/img/f_10.png" width="52" height="38" /></a>
    </div>
</div>
</body>
</html>
