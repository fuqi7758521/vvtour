<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="ctop">
     <div class="top01 clearfix">
       <c:if test='${user == null}'>
	       <div class="topl">您好，欢迎来到诚途旅游网！<a href="<%=request.getContextPath() %>/user/goSignIn.htm" class="blue ml20">登录</a><span>|</span><a href="<%=request.getContextPath() %>/user/goSignUpByEmail.htm" class="blue">注册</a></div>
       </c:if>
       <c:if test='${user != null}'>
        	<div class="topl">您好,<a href="<%=request.getContextPath() %>/user/goUserInfoCenter.htm" class="blue ml5">${user.username}</a><span>|</span><a href="<%=request.getContextPath() %>/user/signOut.htm" class="blue">退出</a></div>
       </c:if>
      
         <ul class="topr">
          <c:if test='${user != null}'>
	           <li class="r01"><a href="#" class="hide">我的诚途</a>
	               <ul>
	                  <li><a href="#">我的订单</a></li>
	                  <li><a href="#">我的积分</a></li>
	                  <li><a href="#">我的优惠券</a></li>
	                  <li><a href="#">我的会员卡</a></li>
	                  <li><a href="#">我的礼品卡</a></li>
	               </ul>
	           </li>
           </c:if>
           <li class="li tc"><a href="#">积分商城</a></li>
           <li class="li tc"><a href="#">团购预约</a></li>
           <li class="li02 tc"><a href="#">帮助</a></li>
           <li class="li01">
               <span class="sp1"></span><a href="#" class="a1">+微信</a>
               <ul>
                   <li><img src="<%=request.getContextPath() %>/front/static/img/wb.jpg" width="220" height="90" /></li>
               </ul>
           </li>
           <li class="li"><span class="sp2"></span><a href="#">+微博</a></li>
           <li class="li li03"><span class="sp3"></span><a href="#">手机版</a></li>
         </ul>
     </div>
</div>


<div class="logo1 clearfix">
   <div class="left"><img src="<%=request.getContextPath() %>/front/static/img/logo.png" width="395" height="37" /></div>
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