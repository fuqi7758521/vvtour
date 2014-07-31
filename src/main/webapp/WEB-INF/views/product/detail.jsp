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
<title>${proInfo.page_title }</title>
<meta name="keywords" content="${proInfo.page_keyword }"/>
<meta name="description" content="${proInfo.page_descript }"/>	
<link href="<%=basePath %>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/main.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/product.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/ui-components.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript"  src="<%=basePath %>js/setTab.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/chengtourUI.js" ></script>

<script type="text/javascript">
	
	$(function(){
		$('.dropdown').hover(function(e) {
			$(this).children('span').siblings('.lv_div').toggle();
			$(this).children('span').toggleClass('link_hover');
		});	
		$('.lv_div').mouseover(function(e) {
			$('.lv_div').show();
		});	
		
		$('.join-weixin .lvlink').hover(function(e) {
			$(this).siblings('.top-sub').toggle();
		});	
		
		
		$('#goTopBtn').click(function(e) {
			$('body,html').animate({scrollTop:0},1000);
		});
		
		$('.quick-menu li a').hover(function(e) {
			$(this).toggleClass('current-crumb');
			$(this).siblings('.menu-bd').toggle();
		});
		$('.ewm_box_xl').hover(function(e) {
			$(this).children('.zhiyin').toggle();
		});
		$('.search_pp_calendar_d li').hover(function(e) {
			$(this).children('.search_pp_calendar_d_box').css('border','2px solid #abba88');
		},function(){
			$(this).children('.search_pp_calendar_d_box').css('border','2px solid #fff');
		});
		
		
		var divindex=0;
		$('.search_pp_cal_nextm_icon').click(function(e) {
			divindex++;
			if(divindex>2){
				divindex=2;
			}
		   $('.search_pp_calendar_box').eq(divindex).show().siblings('.search_pp_calendar_box').hide();
		});
		
		$('.search_pp_cal_nevm_icon').click(function(e) {
			divindex--;
			if(divindex<0){
				divindex=0;
			}
		   $('.search_pp_calendar_box').eq(divindex).show().siblings('.search_pp_calendar_box').hide();
		});
		
		
		var topzhi=$('#scroll_nav').position().top;
		$(window).scroll(function(e) {
			var thescrolltop=$(document).scrollTop();
			if(thescrolltop>topzhi){
				$('#scroll_nav').css({position:'fixed',top:0});
			}else{
				$('#scroll_nav').css({position:'static'});
			}
		});
		
		
		
		$('.p_join-weixin').hover(function(e) {
			$(this).children('.p_weixin').toggle();
		});
		
		$('.firstli').hover(function(e) {
			$(this).children('.p_lvlink').toggleClass('weixin');
		});
		
		$('.fu_top span').click(function(e) {
			$('.fu_top').hide();
		});
		
		var one=$('.qiehuana').position().top;
		var two=$('.qiehuanb').position().top;
		var three=$('.qiehuanc').position().top;
		var four=$('.qiehuane').position().top;
		var five=$('.qiehuang').position().top;
		
		$(window).scroll(function(e) {
			var htop=$(document).scrollTop();
			if(htop>400){
				$('.fuchuang').show();
			}else{
				$('.fuchuang').hide();
			}
			});
			
			
		$(window).scroll(function(e) {
			var htop=$(document).scrollTop();
			if(htop>one){
				$('#scroll_nav li').eq(0).addClass('scroll_nav_current').siblings().removeClass('scroll_nav_current');
			}
			
			if(htop>two){
				$('#scroll_nav li').eq(1).addClass('scroll_nav_current').siblings().removeClass('scroll_nav_current');
			}
			
			if(htop>three){
				$('#scroll_nav li').eq(2).addClass('scroll_nav_current').siblings().removeClass('scroll_nav_current');
			}
			
			if(htop>four){
				$('#scroll_nav li').eq(3).addClass('scroll_nav_current').siblings().removeClass('scroll_nav_current');
			}
			
			if(htop>five){
				$('#scroll_nav li').eq(4).addClass('scroll_nav_current').siblings().removeClass('scroll_nav_current');
			}

		});
			
		
		$('#scroll_nav li').click(function(e) {
			$(this).addClass('scroll_nav_current').siblings().removeClass('scroll_nav_current');
		});
		
		
		$('.pnav-main li a').click(function(e) {
			$(this).parent().addClass('current_nav').siblings().removeClass('current_nav');
			return false;
		});
		
		$('.return_top').click(function(e) {
		   
		$('body,html').animate({scrollTop:0},1000);
		});
		
	});

	$(function(){
	$(".qijiashuoming").ui('lvtip',{ 
	hovershow: 200 
	});
});
    </script>
</head>

<body>
<!-- 引入头部 start -->
<jsp:include page="../common/header.jsp"></jsp:include>
<!-- 引入头部 end -->
<div class="w1000">
  <div class="mt10">您当前所处的位置：<a href="http://www.chengtour.com" class="blue">首页</a> &gt; <a href="javascript:void(0)" class="blue">${proInfo.end_city }</a> &gt; ${proInfo.end_city }</div>
</div>


<!-- 诚途产品内容 -->
<div id="warp">
<div class="main">

<!-- 产品首屏 start -->
<div class="dtl_infobox cclearfix">

		<!--主页右上角图标-->
		<div class="<c:if test="${proInfo.ca_type=='domestic' }">dtl_zyx_icon_gn</c:if><c:if test="${proInfo.ca_type=='abroad' }">dtl_zyx_icon_cj</c:if>" id="dtl_zyx"></div>
		<p class="bookNotes">本产品由诚途旅游网指定北京青年旅行社股份有限公司及具有相关资质的合作旅行社提供相关资讯及服务</p>

		<div class="dtl_tit">
			<h1 class="dtl_tit_txt">${proInfo.tour_title }</h1>
			<!-- Baidu Button BEGIN -->
			<div data-bd-bind="1406180667635" class="bdsharebuttonbox bdshare-button-style0-16">
				<a hidefocus="false" data-cmd="more" class="bds_more" href=""></a>
				<a hidefocus="false" title="分享到QQ空间" data-cmd="qzone" class="bds_qzone" href=""></a>
				<a hidefocus="false" title="分享到新浪微博" data-cmd="tsina" class="bds_tsina" href=""></a>
				<a hidefocus="false" title="分享到腾讯微博" data-cmd="tqq" class="bds_tqq" href=""></a>
				<a hidefocus="false" title="分享到人人网" data-cmd="renren" class="bds_renren" href=""></a>
				<a hidefocus="false" title="分享到微信" data-cmd="weixin" class="bds_weixin" href=""></a>
			</div>
			<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
</script>
			<!-- Baidu Button END -->
		</div>
		<!--infobox-tit-->
<script type="text/javascript">
	$(function(){
		$('.dtl_focuslist li').hover(function(e) {
			var this_index=$(this).index();
            $(this).children('span').removeClass('zz_panel');
			$(this).siblings().children('span').addClass('zz_panel');
            $(this).addClass('dtl_focuslist').siblings().removeClass('dtl_focuslist');
			$('.dtl_crtimg li').eq(this_index).stop().fadeIn(500).siblings().hide();
			li_num=this_index;
        });
		
		var timer2=setInterval(banner_autoplay,3000)
		var li_num=0;
		function banner_autoplay(){
			li_num++;
			if(li_num > 3){
			   li_num=0;
			}
            $('.dtl_focuslist li').eq(li_num).children('span').removeClass('zz_panel');
			$('.dtl_focuslist li').eq(li_num).siblings().children('span').addClass('zz_panel');
            $('.dtl_focuslist li').eq(li_num).addClass('dtl_focuslist').siblings().removeClass('dtl_focuslist');
			$('.dtl_crtimg li').eq(li_num).stop().fadeIn(500).siblings().hide();
		} 
		
		$('.dtl_focusbox').hover(function(e) {
            clearInterval(timer2);
        },function(){
			timer2=setInterval(banner_autoplay,3000);
		});
		
		
	})
</script>
		<div class="dtl_boxinner">
			<div class="dtl_box_left">
				<div class="dtl_focusbox">
					<ul class="dtl_crtimg">
						<li style="display: none; opacity: 1;">
							<img width="440px" height="220px" src="${proInfo.tour_images[0] }"/></li>
						<li style="display: none; opacity: 1;">
							<img width="440px" height="220px" src="${proInfo.tour_images[1] }"/></li>
						<li style="display: none; opacity: 1;">
							<img width="440px" height="220px" src="${proInfo.tour_images[2] }"/></li>
						<li style="display: list-item; opacity: 1;">
							<img width="440px" height="220px" src="${proInfo.tour_images[3] }"/></li>
					</ul>
					<ul class="dtl_focuslist">
						<li class="">
							<img width="97" height="71" rev="${proInfo.tour_images[0]}" src="${proInfo.tour_images[0]}"/>
							<span class="zz_panel"></span>
						</li>
						<li class="">
							<img width="97" height="71" rev="${proInfo.tour_images[1] }" src="${proInfo.tour_images[1] }"/>
							<span class="zz_panel"></span>
						</li>
						<li class="">
							<img width="97" height="71" rev="${proInfo.tour_images[2] }" src="${proInfo.tour_images[2] }"/>
							<span class="zz_panel"></span>
						</li>
						<li class="dtl_focuslist">
							<img width="97" height="71" rev="${proInfo.tour_images[3] }" src="${proInfo.tour_images[3] }"/>
							<span class=""></span>
						</li>
					</ul>
				</div>
				<!--focus-->
				<!--不定期产品时间价格表 start -->
				<div data-bid="60971" data-pid="60971" class="time-price-one">
					<div data-sub-product-type="FREENESS_FOREIGN" data-product-type="ROUTE" data-super-free="false" class="calendar_free">
						<div class="search_pp_calendar_box">
							<h2 class="search_pp_calendar_tit">出行日价格表</h2>
							<div class="search_pp_calendar_m">
								<div class="search_pp_cal_nevm">
									<span class="search_pp_cal_nevm_no_icon"></span>
									<span class="search_pp_cal_nevm_text">7月</span>
								</div>
								<div class="search_pp_cal_nextm">
									<span class="search_pp_cal_nextm_text">8月</span>
									<span class="search_pp_cal_nextm_icon"></span>
								</div>
							</div>
							<!--mounth-->

							<ul class="search_pp_calendar_t">
								<li>星期日</li>
								<li>星期一</li>
								<li>星期二</li>
								<li>星期三</li>
								<li>星期四</li>
								<li>星期五</li>
								<li>星期六</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">01</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-01</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">02</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-02</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">03</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-03</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">04</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-04</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">05</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-05</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">06</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-06</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">07</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-07</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">08</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-08</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">09</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-09</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">10</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-10</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">11</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-11</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">12</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-12</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">13</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-13</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1">
										<span class="search_pp_calendar_day">14</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-14</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_1"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">15</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-15</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">16</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-16</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">17</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-17</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">18</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-18</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1" >
										<span class="search_pp_calendar_day">19</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-19</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">20</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-20</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">21</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-21</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_1"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">22</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-22</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">23</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-23</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">24</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-24</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">25</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-25</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">26</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-26</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">27</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-27</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1" >
										<span class="search_pp_calendar_day">28</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-28</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_1"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">29</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-29</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">30</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-30</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">01</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-01</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">02</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-02</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">03</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-03</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">04</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-04</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">05</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-05</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">06</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-06</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">07</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-07</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">08</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-08</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2"  style="border: 2px solid rgb(255, 255, 255);">
										<span class="search_pp_calendar_day">09</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-09</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">10</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-10</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">11</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-11</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">12</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-12</span>
									</div>
								</li>
							</ul>
						</div>
						<div style="display:none;" class="search_pp_calendar_box">
							<h2 class="search_pp_calendar_tit">出行日价格表</h2>
							<div class="search_pp_calendar_m">
								<div class="search_pp_cal_nevm">
									<span class="search_pp_cal_nevm_icon"></span>
									<span class="search_pp_cal_nevm_text">8月</span>
								</div>
								<div class="search_pp_cal_nextm">
									<span class="search_pp_cal_nextm_text">9月</span>
									<span class="search_pp_cal_nextm_icon"></span>
								</div>
							</div>
							<!--mounth-->

							<ul class="search_pp_calendar_t">
								<li>星期日</li>
								<li>星期一</li>
								<li>星期二</li>
								<li>星期三</li>
								<li>星期四</li>
								<li>星期五</li>
								<li>星期六</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_1" >
										<span class="search_pp_calendar_day">29</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13280起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-29</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">30</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-06-30</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">01</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-01</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">02</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-02</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">03</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-03</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">04</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-04</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">05</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-05</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">06</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-06</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">07</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-07</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">08</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-08</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">09</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-09</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">10</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-10</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">11</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-11</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">12</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-12</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">13</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-13</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">14</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-14</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">15</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-15</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">16</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-16</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">17</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-17</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">18</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-18</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">19</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-19</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">20</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-20</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">21</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-21</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">22</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-22</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">23</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-23</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">24</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-24</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">25</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-25</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">26</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-26</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">27</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13580起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-27</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">28</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-28</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">29</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-29</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">30</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13950起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-30</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">31</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14400起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-31</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">01</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-01</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_3" >
										<span class="search_pp_calendar_day">02</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-02</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_3" >
										<span class="search_pp_calendar_day">03</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-03</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">04</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-04</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">05</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-05</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_3" >
										<span class="search_pp_calendar_day">06</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-06</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_3" >
										<span class="search_pp_calendar_day">07</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-07</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">08</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-08</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_3" >
										<span class="search_pp_calendar_day">09</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-09</span>
									</div>
								</li>
							</ul>
						</div>
						<div style="display:none;" class="search_pp_calendar_box">
							<h2 class="search_pp_calendar_tit">出行日价格表</h2>
							<div class="search_pp_calendar_m">
								<div class="search_pp_cal_nevm">
									<span class="search_pp_cal_nevm_icon"></span>
									<span class="search_pp_cal_nevm_text">9月</span>
								</div>
								<div class="search_pp_cal_nextm">
									<span class="search_pp_cal_nextm_text">10月</span>
									<span class="search_pp_cal_nextm_no_icon"></span>
								</div>
							</div>
							<!--mounth-->

							<ul class="search_pp_calendar_t">
								<li>星期日</li>
								<li>星期一</li>
								<li>星期二</li>
								<li>星期三</li>
								<li>星期四</li>
								<li>星期五</li>
								<li>星期六</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_1" >
										<span class="search_pp_calendar_day">27</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥1000起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-27</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">28</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-28</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_1">
										<span class="search_pp_calendar_day">29</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-29</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1" >
										<span class="search_pp_calendar_day">30</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13950起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-30</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_1" >
										<span class="search_pp_calendar_day">31</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14400起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-07-31</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">01</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-01</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">02</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-02</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">03</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-03</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">04</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-04</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">05</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-05</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">06</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-06</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">07</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-07</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">08</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-08</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">09</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-09</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">10</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-10</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">11</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-11</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">12</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-12</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">13</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-13</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">14</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-14</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">15</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-15</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">16</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14850起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-16</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">17</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14150起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-17</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">18</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-18</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">19</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-19</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">20</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14150起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-20</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">21</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14150起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-21</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">22</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-22</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">23</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14150起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-23</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">24</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥14150起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-24</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">25</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-25</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">26</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-26</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">27</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13350起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-27</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">28</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13350起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-28</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_2">
										<span class="search_pp_calendar_day">29</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-29</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box month_2" >
										<span class="search_pp_calendar_day">30</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥13050起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-30</span>
									</div>
								</li>
							</ul>
							<ul class="search_pp_calendar_d">

								<li>
									<div class="search_pp_calendar_d_box month_2">
										<span class="search_pp_calendar_day">31</span>

										<span class="search_pp_calendar_price1"></span>
										<span class="calendar_active">促</span>
										<span class="search_pp_calendar_price">¥12800起</span>

										<!--日历上展示的优惠信息参数-->
										<input type="hidden" name="tipData" value="[{&quot;index&quot;:&quot;7&quot;}]"/>
										<span class="search_pp_calendar_day_date" style="display:none;">2014-08-31</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">01</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-09-01</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">02</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-09-02</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">03</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-09-03</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">04</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-09-04</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">05</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-09-05</span>
									</div>
								</li>

								<li>
									<div class="search_pp_calendar_d_box_no_hover month_3">
										<span class="search_pp_calendar_day">06</span>

										<span class="search_pp_calendar_day_date" style="display:none;">2014-09-06</span>
									</div>
								</li>
							</ul>
						</div>
					</div>

					

					<!--日历上展示的优惠信息模板-->
					</div>
				<!-- 不定期产品的时间价格表 end -->

			</div>
			<!--boxleft-->
			<div class="dtl_box_right cclearfix">
				<div class="dtl_box_r_topbox">
					<div class="dtl_boxr_txt1">
						<p>
							<label>市 场 价：</label>
							<span class="dtl_linetxt">¥${proInfo.market_price}起</span>
							<br/>
							<label>诚途会员价：</label> <strong>¥ <em>${proInfo.member_price}</em></strong> 
							<span class="qijia">起 &nbsp; <em tip-content="本起价是指未包含附加服务（如单人房差、保险费等）的基本价格。您最终确认的价格将会随所选出行日期、人数及服务项目而相应变化。 " class="qijiashuoming">起价说明</em></span>
						</p>
						<div class="xh-youhui;">
							<label>特色标签：</label>
							<div style="overflow:hidden;display:inline;">
							<c:forEach var="item" items="${proInfo.feature_tag}">
								<span class="tags101">${item}</span>
							</c:forEach>
								<ul style="color:#f60;padding-left:4px;" class="youhui_tab"></ul>
							</div>
						</div>

						<div style="clear:both;"></div>
						<label>出发/目的地：</label>
						${proInfo.start_city}
						<img width="32" height="5" align="absmiddle" src="<%=basePath %>images/arrow.gif" alt=" " class="dtl_goto_icon"/>
						${proInfo.end_city}
						<br>
						<label>支付方式：</label>
								<span class="tags103">现金支付</span>
								<span class="tags103">转账汇款</span>
								<span class="tags103">支付宝</span>
						<p></p>

					</div>
					<!--txt1-->
					<div class="play_date">
							<dl class="cclearfix">
								<!--非不定期产品才显示游玩日期-->
								<dt id="date_type">
									<em>*</em>
									发团日期：
								</dt>
								<dd class="quick-wrap">
									<p>
										<c:set var="str" value="${fn:split(proInfo.start_dates[0],'|')}" />
										<c:if test="${str[0]=='1'}">
											<c:set var="adult" value="${fn:replace(str[1],'{','')}" />
											<c:set var="child" value="${fn:replace(str[2],'}','')}" />
											天天发团:&nbsp;&nbsp;成人价格:¥${adult}&nbsp;&nbsp;儿童价格:¥${child}
										</c:if>
										<c:if test="${str[0]=='2'}">
											<c:set var="adult" value="${fn:replace(str[1],'{','')}" />
											每周:
											<c:forEach var="starts" items="${proInfo.start_dates}" varStatus="status">
												<c:if test="${status.index==0 }">
													<c:set var="oneDayLength" value="${fn:length(starts)}" />
													<c:set var="oneDay" value="${fn:substring(starts,oneDayLength-1,oneDayLength)}" />
													${oneDay }
												</c:if>
												<c:if test="${status.index>0 }">
													,
													<c:choose>
													    <c:when test="${fn:indexOf(starts,'}')>0}">
													     	<c:set var="lastDay" value="${fn:replace(starts,'}','')}" />
															${lastDay }
													    </c:when>
													    <c:otherwise>
													     ${starts }
													    </c:otherwise>
												   </c:choose> 
												</c:if>
											</c:forEach>
											发团&nbsp;&nbsp;成人价格:¥${adult}&nbsp;&nbsp;儿童价格:¥${str[2]}
										</c:if>
										
										<c:if test="${str[0]=='3'}">
										<select class="quickBooker_select" style="width: 240px;" id="start_dates" name="start">
											<option value="0">请选择游玩日期</option>
											<c:forEach var="item" items="${proInfo.start_dates}" varStatus="status">
												<c:if test="${fn:indexOf(item,'{')>0}">
													<c:set var="firstItem" value="${fn:replace(item,'3|{','')}" />
													<c:set var="prices" value="${fn:split(firstItem,'|')}" />
													<option value="${prices[0]}">${prices[0]}  成人¥${prices[1]} ...儿童¥${prices[2]}</option>
												</c:if>
												<c:if test="${fn:indexOf(item,'{')<0}">
												<c:set var="forprices" value="${fn:split(item,'|')}" />
												<option value="${forprices[0]}">${forprices[0]}  成人¥${forprices[1]} ...儿童¥${forprices[2]}</option>
												</c:if>
											</c:forEach>
											</select>
										</c:if>
									</p>
								</dd>
							</dl>
							<dl class="cclearfix">
							<!-- 
								<dt>
									<em>*</em>
									预订数量：
								</dt> -->
								<dd style="position: relative;">
								
									<div id="quickBooker1_tab2">
									<!-- 
										<table class="free_dtl_pro_tab">
											
											<tbody>
												<tr class="p_60971">
													<td>
														<span title="2沙beach bungalow+2水 water bungalow">2沙beach ...</span>

													</td>
													<td>
														<span class="price-wrap">
															<em onclick="updateOperator('60971','miuns',this)" class="minus price-disable">-</em>
															<input type="text" branchid="60971" people="1" textnum="textNum60971" maxamt="100" minamt="0" onchange="updateOperator('60971','input',this)" ordnum="ordNum" value="0" class="number prod-num" size="2" id="param60971" name="buyInfo.buyNum.product_60971" seq="1">
															<em onclick="updateOperator('60971','add',this)" class="plus">+</em>
														</span>
													</td>
													<td>
														<span>
															(单价 <dfn>¥ <font id="product_60971_price" class="product_60971_price">12800</font></dfn> )
														</span>
													</td>
												</tr>
												
												<tr class="p_100232">
													<td>
														<span title="4晚水屋water Bungalow">4晚水屋wate...</span>

													</td>
													<td>
														<span class="price-wrap">
															<em onclick="updateOperator('100232','miuns',this)" class="minus price-disable">-</em>
															<input type="text" branchid="100232" people="1" textnum="textNum100232" maxamt="100" minamt="0" onchange="updateOperator('100232','input',this)" ordnum="ordNum" value="0" class="number prod-num" size="2" id="param100232" name="buyInfo.buyNum.product_100232" seq="1">
															<em onclick="updateOperator('100232','add',this)" class="plus">+</em>
														</span>
													</td>
													<td>
														<span>
															(单价 <dfn>¥ <font id="product_100232_price" class="product_100232_price">12900</font></dfn> 
															)
														</span>
													</td>
												</tr>
											</tbody>
										</table>
										-->
									</div>
									<!--  end-->
									<!--按钮-->
									<!-- 非超级自由行-->
									<!-- 可售-->
									<span class="bookerBtn"><input type="submit" style="cursor:pointer" value="" class="immediateB"/></span>
									<a href="javascript:addBookmark();" style="display:none" class="dtl_savebtn">收藏该商品</a>
									<br/>
									<a href="javascript:void(0)" style="display:none" class="dtl_savebtn detail-recomment">推荐给好友</a>
								</dd>

							</dl>
						<div class="ewm_box ewm_box_xl">
							<img width="75" height="75" alt="手机订购二维码" src="<%=basePath %>images/weixin.gif"/>
							<p>
								扫描二维码 关注官方微信
								<span>订购更优惠</span>
							</p>
							<span class="zhiyin" style="display: none;"></span>
						</div>

						<p class="dtl_r_hint"></p>

						<!--recomment_wra end-->
						</div>

				</div>
				<!--topbox-->
				<div class="dtl_cfd_gonggao">
					<h3>
						<b>公告</b>
					</h3>
					<ol class="dtl_gonggao_list">
						<li>12岁以下儿童、外籍、单房差价格请来电咨询客服</li>
						<li>北京诚途旅游网官方电话：400-6966-6936</li>
					</ol>
				</div>
				<!--gonggao-->

			</div>
			<!--boxright-->
		</div>
		<!--boxinner-->
	</div>

<!-- 产品首屏 end -->

<!--产品经理推荐infobox-->
<!-- 
	<div class="dtl_tj">
		<h3 class="dtl_tj_tit">产品经理推荐</h3>
		<ul class="dtl_tj_list">
			<li>★马尔代夫哈库拉岛距离首都马列130公里处</li>
			<li>★性价比很高的一价全含，包括了三餐以及下午的点心和夜宵</li>
			<li>★免费浮潜设备租用</li>
			<li>★现代装修风格，舒适住宿环境</li>
		</ul>
	</div>
-->
<!--产品经理推荐end-->

<!--下部(产品经理推荐以下部分)-->
<b  style="display:inline-block; width:10px; height:10px; margin-bottom:10px;"><a name="tese"></a></b>

<!-- 详情导航框 start -->
<ul selfpack="false" id="scroll_nav" class="scroll_nav_ul" style="position: static;">
		<li class="row_1 scroll_nav_current">
			<a href="#tese">行程特色</a>
		</li>

		<li class="row_2">
			<a href="#xingcheng">行程安排</a>
		</li>

		<li class="row_3">
			<a href="#feiyong">费用说明</a>
		</li>

		<li class="row_4">
			<a href="#tishi">重要提示</a>
		</li>
<c:if test="${!empty proInfo.tour_visa}">
		<li class="row_5">
			<a href="#qianzheng">签证/签注</a>
		</li>
</c:if>
</ul>

<!-- 详情导航框end -->

<!-- 产品特色 start -->
	<i id="row_1" class="pkg-maodian">&nbsp;</i>
	<h3 class="h3_tit qiehuana" >
		<span><a style="color:#fff;">产品特色</a></span>
	</h3>

<div style="position:relative;" class="row pro_special">
		<div class="pro_special_mid">
			${proInfo.tour_feature }
		</div>
        
    	<b style="display:inline-block; width:10px; height:10px; position:absolute; left:0; bottom:0; "><a name="xingcheng"></a></b>
		<!--pro_special_mid end-->
	</div>

<!-- 产品特色end -->

<!-- 行程安排start -->
	<i id="row_2" class="pkg-maodian">&nbsp;</i>
	<h3 class="h3_tit qiehuanb">
		<span><a style="color:#fff;">行程安排</a></span>
	</h3>
	<div style="position:relative;" class="row recommend_travel">
		
		<!-- 多行程 -->
		<!--day star-->
		${proInfo.tour_con }
		<!--day end-->
        
    	<b style="display:inline-block; width:10px; height:10px; position:absolute; left:0; bottom:0; "><a name="feiyong"></a></b>
	</div>

<!-- 行程安排end -->

<!-- 费用说明start -->
<i id="row_3" class="pkg-maodian">&nbsp;</i>
	<h3 class="h3_tit qiehuanc">
		<span><a style=" color:#fff;">费用说明</a></span>
	</h3>
	<div style="position:relative;" class="row statement_cost">
		${proInfo.tour_fee }
    	<b style="display:inline-block; width:10px; height:10px; position:absolute; left:0; bottom:0; "><a name="tishi"></a></b>
	</div>
<!-- 费用说明end -->

<!-- 重要提示start -->
<i id="row_4" class="pkg-maodian">&nbsp;</i>
<h3 class="h3_tit qiehuane">
<span><a style="color:#fff;">重要提示</a></span>
</h3>

<div style="position:relative;" class="row important_prompt">

	${proInfo.tour_tip }
	<c:if test="${!empty proInfo.tour_visa}">
    <b style="display:inline-block; width:10px; height:10px; position:absolute; left:0; bottom:0; "><a name="qianzheng"></a></b>
</c:if>
</div>

<!-- 重要提示end -->

<!-- 签证/签注start -->

<i id="row_5" class="pkg-maodian">&nbsp;</i>

<h3 class="h3_tit qiehuang">
<span><a style="color:#fff;">签证/签注</a></span>
</h3>
<c:if test="${!empty proInfo.tour_visa}">
<div style="margin-bottom: 10px; position:relative;" class="l_row row">
<div class="visa_info_xh">

<ul class="visa_nav_a cclearfix">
	<li class="selected">
		签证说明</li>
</ul>
<div class="visa_content">
	<div style="display:block" class="tabcon">
		<ul class="visa_subnav_a J_tab_subnav cclearfix">
			<li class="selected">
				所有人员
				<input type="hidden" id="ssrq_0" value="所有人员"/>
				<i></i>
				<style>
							.visa_mail{
							   width:16px;
							   height:15px;
							   background:url("<%=basePath %>images/combo.png") no-repeat -24px -71px;
							   margin-left:5px;
							   display:inline-block;
							}
							</style>
				<br/></li>
		</ul>
		<div class="J_tab_subswitch">
			<div style="display:block" class="tabcon">
				<div class="visa_info_box">
					<div class="visa_info_item">
						${proInfo.tour_visa}
					</div>
				</div>
			</div>
		</div>
		<!-- //div J_tab_switch -->
        
	</div>
</div>
<!-- //div J_tab_switch -->
</div>
    	
</div>
</c:if>
<!-- 签证/签注end -->


</div><!-- class="main" -->
</div>

<!-- 诚途产品内容 -->
<div class="w1000 mt25"><img src="<%=basePath %>images/10.jpg" width="1000" height="60" class="mt20"/></div>

<!-- 引入头部 start -->
<jsp:include page="../common/footer.jsp"></jsp:include>
<!-- 引入头部 end -->

<!-- 引入友情链接 start -->
<jsp:include page="../common/friends_link.jsp"></jsp:include>
<!-- 引入友情链接 end -->
</body>
</html>
