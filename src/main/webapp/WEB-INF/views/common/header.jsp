<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + path + "/";
%>
<div class="ctop">
     <div class="top01 clearfix">
       <div class="topl">您好，欢迎来到诚途旅游网！<!-- <a href="#" target="_blank" class="blue ml20">登录</a><span>|</span><a href="#" target="_blank" class="blue">注册</a> --></div>
        <!--   
        <div class="topl">您好，<a href="#" target="_blank" class="blue ml20">hellowuyao</a><span>|</span><a href="#" target="_blank" class="blue">退出</a></div>
        -->  
         <ul class="topr">
         	<li style="width: 300px;float: left;">&nbsp;</li>
         	
         	<!-- 
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
            -->
           <li class="li02 tc"><a href="/help/about_us.html" target="_blank">帮助</a></li>
           <li class="li01">
               <span class="sp1"></span><a href="javascript:void(0)" class="a1">+微信</a>
               <ul>
                   <li><img src="<%=basePath %>images/wb.jpg" width="220" height="90" /></li>
               </ul>
           </li>
           <li class="li"><span class="sp2"></span><a href="#">+微博</a></li>
           <!-- <li class="li li03"><span class="sp3"></span><a href="#">手机版</a></li>-->
         </ul>
     </div>
</div>
<div class="logo1 clearfix">
   <div class="left"><img src="<%=basePath %>images/logo.png" width="395" height="37" /></div>
   <div class="right">400-6966-706</div>
   <div class="middle">
   <!-- 
   	<a href="#"><img src="<%=basePath %>images/ad1.png" width="300" height="60" /></a> -->
   	</div>
</div>
<div class="list">
     <div class="w1000 clearfix">
         <script type="text/javascript"  src="/js/header.js"></script>
     </div>
</div>
<!-- -->
