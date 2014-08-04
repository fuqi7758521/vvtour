<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户-手机注册</title>
<link href="<%=request.getContextPath() %>/front/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/front/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="ctop">
     <div class="top01 clearfix">
       <div class="topl">您好，欢迎来到诚途旅游网！<a href="#" target="_blank" class="blue ml20">登录</a><span>|</span><a href="#" target="_blank" class="blue">注册</a></div>
        <!--   
        <div class="topl">您好，<a href="#" target="_blank" class="blue ml20">hellowuyao</a><span>|</span><a href="#" target="_blank" class="blue">退出</a></div>
        -->  
         <ul class="topr">
           <li class="r01"><a href="#" class="hide">我的诚途</a>
               <ul>
                  <li><a href="#">我的订单</a></li>
                  <li><a href="#">我的积分</a></li>
                  <li><a href="#">我的优惠券</a></li>
                  <li><a href="#">我的会员卡</a></li>
                  <li><a href="#">我的礼品卡</a></li>
               </ul>
               
           </li>
           <li class="li tc"><a href="#">积分商城</a></li>
           <li class="li tc"><a href="#">团购预约</a></li>
           <li class="li02 tc"><a href="#">帮助</a></li>
           <li class="li01">
               <span class="sp1"></span><a href="#" class="a1">+微信</a>
               <ul>
                   <li><img src="images/wb.jpg" width="220" height="90" /></li>
               </ul>
           </li>
           <li class="li"><span class="sp2"></span><a href="#">+微博</a></li>
           <li class="li li03"><span class="sp3"></span><a href="#">手机版</a></li>
         </ul>
     </div>
</div>
<div class="logo1 clearfix">
   <div class="left"><img src="<%=request.getContextPath() %>/front/images/logo.png" width="395" height="37" /></div>
   <div class="right">010-60606060</div>
</div>
<div class="list">
   <div class="w1000 clearfix">
         <div class="fl pr">
             <a href="#">首页</a>
             <a href="#">景点门票</a>
             <a href="#">周边游</a>
             <a href="#">国内游</a>
             <a href="#">出境游</a>
             <a href="#">邮轮</a>
             <a href="#">酒店</a>
             <a href="#">度假酒店</a>
             <a href="#">国际机票</a>
             <a href="#">定制游</a>
             <a href="#">特卖会</a>
             <span class="span1"></span>
             <span class="span2"></span>
             <span class="span3"></span>
         </div>
         <div class="fr f12">
             <a href="#">点评</a>
             <a href="#">攻略</a>
             <a href="#">专题</a>
             <a href="#">社区</a>
         </div>
     </div>
</div>

<div class="container">
<div class="w1000">
	
	<div class="content_n">
		<div class="yhzc">
			<div class="yhzcL">
				<div class="yhzcLA">
					<div class="yhzcLA_b"><a href="<%=request.getContextPath()%>/user/goSignUpByEmail.htm">邮箱注册</a></div>
					<div class="yhzcLA_a"><span><a href="#">手机注册</a></span></div>
					<div class="yhzcLA_c">
						<a href="#">会员可注册</a>&nbsp;成为驴妈妈会员
					</div>
				</div>
				<div class="yhzcLB">
					<ul>
						<li>
							<div class="yhzcLB_a"><span>*</span>您的Email地址：</div><input name="" type="text" class="yhzcLB_b" />
						</li>
						<li>
							<div class="yhzcLB_a"><span>*</span>用户名：</div><input name="" type="text" class="yhzcLB_b" />
						</li>
						<li>
							<div class="yhzcLB_a"><span>*</span>设置密码：</div><input name="" type="text" class="yhzcLB_b" />
						</li>
						<li>
							<div class="yhzcLB_a"><span>*</span>确认密码：</div><input name="" type="text" class="yhzcLB_b" />
						</li>
						<li>
							<div class="yhzcLB_a"><span>*</span>验证码：</div><input name="" type="text" class="yhzcLB_c" />
							<div class="yhzcLB_d">
								<img src="<%=request.getContextPath() %>/front/images/login_11.jpg" />
								<a href="#">换一张</a>
							</div>
						</li>
						<li>
							<div class="yhzcLB_a">所在地：</div>
							<select name="">
								<option>北京市</option>
							</select>
							<select name="">
								<option>北京市</option>
							</select>
						</li>
						<li>
							<div class="yhzcLB_a">&nbsp;</div>	
							<div class="yhzcLB_e"><input name="" type="image" src="<%=request.getContextPath() %>/front/images/yhzc_22.jpg"/><br />
							<a href="#">《驴妈妈旅游网会员服务条款》</a></div>
						</li>
					</ul>
				</div>
			</div>
			<div class="yhzcR">
				<div class="yhzcR_a">
					<img src="<%=request.getContextPath() %>/front/images/yhzc_09.jpg" /><span>现在注册即可获得<strong>100积分</strong></span>
				</div>
				<div class="yhzcR_b">
					<span>已经有驴妈妈账号？</span><input name="" type="image" src="images/yhzc_15.jpg" />
				</div>
				<div class="yhzcR_c">
					<div class="yhzcR_ca">
						<div class="yhzcR_caa">使用合作网站账号登录</div><br />
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/images/login_19.jpg" /></span><a href="#">QQ</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/images/login_21.jpg" /></span><a href="#">腾讯微博</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/images/login_29.jpg" /></span><a href="#">新浪微博</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/images/login_32.jpg" /></span><a href="#">支付宝</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/images/login_34.jpg" /></span><a href="#">开心网</a></div>
						<div class="yhzcR_caa"><span><img src="<%=request.getContextPath() %>/front/images/login_36.jpg" /></span><a href="#">盛大</a></div>
					</div>
				</div>
				<div class="yhzcR_d"><img src="<%=request.getContextPath() %>/front/images/yhzc_19.jpg" /></div>
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
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_01.png" width="56" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_02.png" width="47" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_03.png" width="49" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_04.png" width="80" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_05.png" width="56" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_06.png" width="48" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_07.png" width="88" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_08.png" width="96" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_09.png" width="48" height="38" /></a>
       <a href="#"><img src="<%=request.getContextPath() %>/front/images/f_10.png" width="52" height="38" /></a>
    </div>
</div>
</body>
</html>
