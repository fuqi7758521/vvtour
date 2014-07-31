<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link href="<%=basePath %>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/index.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/jquery.jslides.css" media="screen" />
<script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery/jquery.jslides.js"></script>
<script type="text/javascript"  src="<%=basePath %>js/tab.js"></script>
<script type="text/javascript"  src="<%=basePath %>js/basic.js"></script>
</head>

<body>
<div class="itop clearfix">
     <div class="top01">
          <div class="topl">
             <a href="#" class="fl pr10">收藏诚途旅游网</a>
       </div>
       <ul class="topr">
       <li style="width: 360px;float: left;">&nbsp;</li>
      <!--      <li class="li04"><a href="#" class="pr15">登录</a><a href="#">注册</a></li>
		登录后显示  
    <li class="li04">你好！欢迎来到诚途旅游网</li>
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
                   <li><img src="/images/wb.jpg" width="220" height="90" /></li>
               </ul>
           </li>
           <li class="li"><span class="sp2"></span><a href="#">+微博</a></li>
           <!-- 
           <li class="li"><span class="sp3"></span><a href="#">手机版</a></li> -->
           <li class="r02 li03">
           <span class="sp01"></span>
           <a href="javascript:void(0)" class="hide">400-6966-706</a>
               <ul>
                   <li>400-6966-706</li>
               </ul>
           </li>
         </ul>
     </div>
</div>
<div class="ilogo clearfix">
   <div class="left"><img src="/images/ilogo.png" width="310" height="90" /></div>
  <div class="middle">
<!-- 引入搜索框start -->
<jsp:include page="common/search_bar.jsp"></jsp:include>
<!-- 引入搜索框end -->
  </div>
   <div class="right">
       <ul class="ul1">
           <li class="r01">
           <!-- 
           <span></span><a href="#" class="hide">我的诚途</a>
               <ul>
                  <li><a href="#">我的订单</a></li>
                  <li><a href="#">我的积分</a></li>
                  <li><a href="#">我的优惠券</a></li>
                  <li><a href="#">我的会员卡</a></li>
                  <li><a href="#">我的礼品卡</a></li>
               </ul>
                -->
           </li>
           <li class="mt15"><img src="/images/tel.gif"/></li>
       </ul>
   </div>
</div>
<div class="ilist">
   <div class="w1200 clearfix">
         <div class="span">热门目的地分类</div>
         <div class="fl pr">
             <a href="#" class="a1">首页</a>
             ${index_guide}
         </div>
     </div>
</div>

<div class="adnr">
  <div class="bk">
     <div class="yyt"></div>
     <div class="adlist">
         <ul class="ul">
         <!-- 首页菜单 -->
				${index_menu}
		<!-- 首页菜单 -->
         </ul>
     </div>

<!-- 广告滚动图 -->
     <div class="adtop" id="full-screen-slider">
            <div class="ad">
                <ul id="slides">
                ${index_banner}
                </ul>
            </div>
    </div>
<!-- 广告滚动图 -->
   </div>
</div>
<div class="w1200">
   <div class="xxnr clearfix">
   		
   	<!-- left start -->
       <div class="left">
         <div class="tg">
           <h5>团购</h5>
            <!-- 团购start -->
           ${index_tuangou}
           <!-- 团购end -->
          </div> 
         <div class="cxyh">
           <h5>促销优惠</h5>
            <ul>
               <!-- 促销优惠 -->
            ${index_cuxiao}
            <!-- 促销优惠 -->
            </ul>
          </div>
          
          <div class="rxph clearfix">
              <h5>热销排行</h5>
              <ul>
                  <li id="one1" onclick="settab('one',1,3)"  class="hover">出国游</li>
                  <li id="one2" onclick="settab('one',2,3)" >国内游</li>
                  <li id="one3" onclick="settab('one',3,3)" >周边游</li>
              </ul>
              <div id="con_one_1" style="display:block;">
              	<!-- 出国游start #index_top_abroad# -->
                  ${index_top_abroad}
                <!-- 出国游end #index_top_abroad# -->
              </div>
              <div id="con_one_2" style="display:none;">
              	<!-- 国内游start #index_top_domestic# -->
                  ${index_top_domestic}
                 <!-- 国内游end #index_top_domestic# -->
              </div>
              <div id="con_one_3" style="display:none;">
              <!-- 周边游start #index_top_around# -->
              		${index_top_around}
              <!-- 周边游start #index_top_around# -->
              </div>
              
          </div>
          
          
     </div>
    <!-- left end -->
   <!-- right start -->
       <div class="right">
          <div class="nr1 clearfix"> 
               <h3><span class="fr"><a href="#" class="gray">更多>></a></span>马上出发<span>拎包就走,轻松出游</span></h3>
               <dl class="zb01">
                   ${index_mashang_bigIMG}
               </dl>
              
              <dl class="zb02">
                  <dt>周边游精品路线推荐<span>放松、度假、纵情山水</span></dt>
                  <dd>
                     ${index_mashang_tag}
                  </dd>
               </dl>
               
               <div class="clearfix">
	               ${index_mashang_img}
               </div>
           </div>
           
           <div class="hwlx clearfix">
               <h3><span class="fr"><a href="#" class="gray">更多>></a></span>海外旅行<span>拎包就走,轻松出游</span>
                   <em class="clearfix">
                      <a href="#"><i></i>东南亚</a>
                      <a href="#"><i></i>东南亚</a>
                      <a href="#"><i></i>欧洲</a>
                      <a href="#"><i></i>日韩</a>
                      <a href="#"><i></i>东南亚</a>
                 </em>
                </h3>
                
              <!-- 海外旅游sart -->
                ${index_haiwai}
              <!-- 海外旅游end -->
              
           </div>
           
           <div class="hwlx clearfix">
               <h3><span class="fr"><a href="#" class="gray">更多>></a></span>玩转国内<span>拎包就走,轻松出游</span>
                   <em class="clearfix">
                      <a href="#"><i></i>东南亚</a>
                      <a href="#"><i></i>东南亚</a>
                      <a href="#"><i></i>欧洲</a>
                      <a href="#"><i></i>日韩</a>
                      <a href="#"><i></i>东南亚</a>
                 </em>
                </h3>
                
                <!-- 玩转国内sart -->
                ${index_guonei}
               <!-- 玩转国内end -->
           </div>
           
           <div class="qnw">
               <h3>周边去哪玩<span>拎包就走,轻松出游</span></h3>
               <div class="qnw01 clearfix">
                  <h4><span><a href="#" class=" gray">【新产品免费体验员招募】报名参与</a><i></i></span>最受关注的行程</h4>
                  
                  <!-- 周边去哪玩start -->
                  ${index_zhoubian}
                <!-- 周边去哪玩end -->
                  
               </div>
               
           </div>
       </div>
       <!-- right end -->
       
  
  </div>
</div>
<!-- 底部横条广告 -->
${index_buttom_ad}
<!-- 底部横条广告 -->

<div class="w1200">
    <div class="bfoot01">
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
<div class="bfoot02">
    <div class="w1200">
         <ul class="clearfix">
         	${index_buttom_aboutus}
         </ul>
    </div>
</div>
<div class="w1200"> 
    <div class="bfoot03">
         <ul>
             ${index_buttom_friends}
         </ul>
    </div>
</div>
<div style="margin-left:50%;">
    <div class="yfd">
        <a href="#" class="a1"></a>
        <a href="#" class="a2 mt10"></a>
    </div>
</div>
</body>
</html>

