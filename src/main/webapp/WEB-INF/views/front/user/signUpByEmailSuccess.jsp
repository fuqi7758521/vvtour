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
							<li><img src="<%=request.getContextPath() %>/front/static/img/yzyx_04.jpg" />您的注册邮箱为：${email}</li>
							<li><img src="<%=request.getContextPath() %>/front/static/img/yzyx_04.jpg" />邮箱可用来登录、找回密码、订购产品。</li>
						</ul>
					</div>
					<div class="zccg_c">
						<div class="zccg_ca">我们已向您的邮箱发送一封验证邮件，验证邮箱成功后将获得300积分奖励。</div>
						<div class="zccg_cb">
							<input name="" type="image" src="<%=request.getContextPath() %>/front/static/img/zccg_07.jpg" />
							没有收到？<a href="#">再次发送</a>
						</div>
					</div>
					<div class="zccg_d">您现在要去：<a href="#">返回首页</a></div>
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
