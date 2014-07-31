<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + path + "/";
%>

<div class="w1000">
    <div class="foot2 clearfix mt25">
      <dl class="mr40">
         <dt>订购指南</dt>
         <dd><a href="http://www.chengtour.com" class="gray">门票订购流程是怎样的？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">二维码使用时有什么注意事项？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">可以预订多长时间的门票？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">想要修改订单，怎么操作？</a></dd>
      </dl>
      <dl class="mr40">
         <dt>注册与登录</dt>
         <dd><a href="http://www.chengtour.com" class="gray">手机没有收到激活/验证短信怎么办</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">怎样才能成为诚途网会员？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">在哪登录会员帐号？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">如何修改我的帐号密码？</a></dd>
      </dl>
      <dl class="mr40">
         <dt>支付与取票</dt>
         <dd><a href="http://www.chengtour.com" class="gray">付款方式有哪些？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">在线支付安全吗？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">为什么支付不成功？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">想要退款，应该怎么做？</a></dd>
      </dl>
      <dl>
         <dt>沟通与订阅</dt>
         <dd><a href="http://www.chengtour.com" class="gray">我想咨询门票，应该怎么办？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">我有意见，在哪可以提？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">我想投诉，应该怎么反映？</a></dd>
         <dd><a href="http://www.chengtour.com" class="gray">我是景区负责人，怎么联系诚途网？</a></dd>
      </dl>
    </div>
    <div class="foot3">
       <ul>
          <li class="pl20">
              <i class="i1"></i>
              <strong>价格保证</strong>
              同类产品，保证低价
          </li>
          <li>
              <i class="i2"></i>
              <strong>退订保障</strong>
              因特殊情况影响出行，保证退订
          </li>
          <li>
              <i class="i3"></i>
              <strong>救援保障</strong>
              旅途中遇意外情况，保证援助
          </li>
          <li class="li">
              <i class="i4"></i>
              <strong>7x24小时服务</strong>
              快速响应，全年无休
          </li>
       </ul>
    </div>
</div>

<div class="foot">
    <div class="foot1">
      <a href="http://www.chengtour.com/help/about_us.html">关于我们</a> | <a href="http://www.chengtour.com/help/site_map.html">网站地图</a> | <a href="http://www.chengtour.com/help/contact_us.html">联系我们</a> | <a href="http://www.chengtour.com/help/server_intro.html">服务说明</a> | <a href="http://www.chengtour.com/help/about_us.html">帮助中心</a> | <a href="#">友情链接</a> | <a href="http://www.chengtour.com">诚聘英才</a> | <a href="http://www.chengtour.com">旅游度假资质</a> | <a href="http://www.chengtour.com">意见反馈</a> | <a href="http://www.chengtour.com">广告业务</a> | <a href="http://www.chengtour.com">用户体验平台</a>
    </div>
    <div class="foot2">Copyright © 2014 www.chengtour.com. 北京青年旅行社股份有限公司广外营业部版权所有　京ICP备12029589　经营许可证：L-BJ-GJ00060</div>
    <!-- 
    <div class="foot3 mt10">
    
       <a href="#"><img src="<%=basePath %>images/f_01.png" width="56" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_02.png" width="47" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_03.png" width="49" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_04.png" width="80" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_05.png" width="56" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_06.png" width="48" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_07.png" width="88" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_08.png" width="96" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_09.png" width="48" height="38" /></a>
       <a href="#"><img src="<%=basePath %>images/f_10.png" width="52" height="38" /></a>
    </div>
     -->
</div>
<!--
<div style="margin-left:50%;">
    <div class="yc01">
        <dl>
           <dt><a href="#"></a></dt>
           <dd>
              <span class="span1"><a href="#">购物车</a></span>
              <span class="span2"><a href="#">最近查看</a></span>
              <span class="span3"><a href="#">在线客服</a></span>
              <span class="span4"><a href="#">提提意见</a></span>
              <span class="span5"><a href="#">返回顶部</a></span>
           </dd>
        </dl>
    </div>
</div>
-->