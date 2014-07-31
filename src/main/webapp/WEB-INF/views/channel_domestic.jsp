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
<title>产品频道页</title>
<link href="<%=basePath %>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/jquery.jslides.css" media="screen" />
<script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery/jquery.jslides.js"></script>
<script type="text/javascript"  src="<%=basePath %>js/setTab.js"></script>
<script type="text/javascript" src="<%=basePath %>js/basic.js"></script>
</head>

<body>
<!-- 引入头部 start -->
<jsp:include page="common/header.jsp"></jsp:include>
<!-- 引入头部 end -->

<div class="ssy">
   <div class="left mt25">
<!-- 引入搜索框start -->
<jsp:include page="common/search_bar.jsp"></jsp:include>
<!-- 引入搜索框end -->
   
 </div>
</div>

<div class="pdnr">
    <div class="left">
		<!-- -->

       <div class="ad01">
       <!-- channel_common_banner -->
          ${channel_common_banner}
        <!-- channel_common_banner -->
       </div>
<script language="javascript">
	$(function(){
		//当鼠标滑入时将div的class换成hover
		$('.channelADTab').hover(function(){
				$(this).addClass('hover');
				
				for(i=0;i<10;i++){
					$("#ad_channel_"+i).css('display','none'); 
				}
				var ID=$(".channelADTab").index($(this));
				var ad_img_id = "ad_channel_"+ID;
				$("#"+ad_img_id).css('display','block');
				
			},function(){
				//鼠标离开时移除hover样式
				$(this).removeClass('hover');	
			}
		);
	});
</script>
       <div class="cptt mt25 clearfix">
          <h3>产品特推</h3>
           ${channel_domestic_tuangou}
       </div>
       
       <div class="lyxl mt25 clearfix">
          <h3>国内旅游路线</h3>
          <ul>
             <li id="one1" onclick="setTab('one',1,10)"  class="active">云南</li>
             <li id="one2" onclick="setTab('one',2,10)" >海南</li>
             <li id="one3" onclick="setTab('one',3,10)" >厦门</li>
             <li id="one4" onclick="setTab('one',4,10)" >西藏</li>
             <li id="one5" onclick="setTab('one',5,10)" >张家界</li>
             <li id="one6" onclick="setTab('one',6,10)" >九寨沟</li>
             <li id="one7" onclick="setTab('one',7,10)" >西安</li>
             <li id="one8" onclick="setTab('one',8,10)" >三峡</li>
             <li id="one9" onclick="setTab('one',9,10)" >长白山</li>
          </ul>
          
          <!-- 产品路线内容1 -->
          ${channel_domestic_con1}
          <!-- 产品路线内容1 -->

          <!-- 产品路线内容2 -->
          ${channel_domestic_con2}
          <!-- 产品路线内容2 -->
          
          <!-- 产品路线内容3 -->
          ${channel_domestic_con3}
          <!-- 产品路线内容3 -->
          
          <!-- 产品路线内容4 -->
          ${channel_domestic_con4}
          <!-- 产品路线内容4 -->
          
          <!-- 产品路线内容5 -->
          ${channel_domestic_con5}
          <!-- 产品路线内容5 -->
          
          <!-- 产品路线内容6 -->
          ${channel_domestic_con6}
          <!-- 产品路线内容6 -->
          
          
          <!-- 产品路线内容7 -->
          ${channel_domestic_con7}
          <!-- 产品路线内容7 -->
          
          
          <!-- 产品路线内容8 -->
          ${channel_domestic_con8}
          <!-- 产品路线内容8 -->
          
          <!-- 产品路线内容9 -->
          ${channel_domestic_con9}
          <!-- 产品路线内容9 -->
          
       </div>
  
    </div>
    
    <div class="right">
         <div class="djrm">
             <h3>当季热门旅游</h3>
             <ul>
             ${channel_common_menu}
             </ul>
<script language="javascript">
	$(function(){
		//当鼠标滑入时将div的class换成hover
		$('.right_menu').hover(function(){
				$(this).addClass('active');
				
				for(i=1;i<6;i++){
					$("#con_five_"+i).css('display','none'); 
				}
				var ID=$(".right_menu").index($(this))+1;
				var menu_five_id = "con_five_"+ID;
				$("#"+menu_five_id).css('display','block');
				
			},function(){
				//鼠标离开时移除hover样式
				$(this).removeClass('active');	
				for(i=1;i<6;i++){
					$("#con_five_"+i).css('display','none'); 
				}
			}
		);

		//当鼠标滑入时将div的class换成hover
		$('.djmain').hover(function(){
				$(this).css('display','block');
				
			},function(){
				//鼠标离开时移除hover样式
				$(this).css('display','none');
			}
		);
	});
</script>
         ${channel_common_con1}
         ${channel_common_con2}
         ${channel_common_con3}
         ${channel_common_con4}
         </div>
         
          <div class="jdmdd mt25">
             <h3>热门景点目的地</h3>
             <ul>
                ${channel_domestic_hot}
             </ul>
         </div>
        <!-- 
 		<div class="rmtj mt25"> 
             <h3>热门推荐</h3>
             <ul>
                <li style="height:90px;"><a href="#" class="blue">【击穿底价】泰一地5晚7日超值经典之旅*澳航 一晚海边国际五星级酒店</a><a href="#" hidefocus="false" class="a1"><em>诚途价</em><i>1256元</i></a></li>
                <li style="height:90px;"><a href="#" class="blue">【击穿底价】泰一地5晚7日超值经典之旅*澳航 一晚海边国际五星级酒店</a><a href="#" hidefocus="false" class="a1"><em>诚途价</em><i>1256元</i></a></li>
                <li style="height:90px;"><a href="#" class="blue">【击穿底价】泰一地5晚7日超值经典之旅*澳航 一晚海边国际五星级酒店</a><a href="#" hidefocus="false" class="a1"><em>诚途价</em><i>1256元</i></a></li>
             </ul>
         </div>
          -->
         <div class="mt25"><img src="/images/13.jpg" width="200" height="80" /></div>

    </div>
</div>
<div class="w1000 mt25">${common_buttom_ad}</div>

<!-- 引入头部 start -->
<jsp:include page="common/footer.jsp"></jsp:include>
<!-- 引入头部 end -->

<!-- 引入友情链接 start -->
<jsp:include page="common/friends_link.jsp"></jsp:include>
<!-- 引入友情链接 end -->
</body>
</html>

