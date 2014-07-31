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
<title>产品列表页</title>
<link href="<%=basePath %>css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="<%=basePath %>js/setTab.js"></script>
<script type="text/javascript" src="<%=basePath %>js/basic.js"></script>
</head>
<body>
<!-- 引入头部 start -->
<jsp:include page="common/header.jsp"></jsp:include>
<!-- 引入头部 end -->
<!-- 
<div class="w1000">
  <div class="mt10">您当前所处的位置：<a href="#" class="blue">首页</a> > <a href="#" class="blue">北京出发</a> > 泰国</div>
</div>
 -->
<div class="ssy">
   <div class="left mt10">
<!-- 引入搜索框start -->
<jsp:include page="common/search_bar.jsp"></jsp:include>
<!-- 引入搜索框end -->
   
 </div>
   <div class="right mt10">
   <!-- 
      <i></i>
     <P><em class="f18">北京</em><em class="gray pr5">出发</em></P><span class="sp01"></span> -->
  <!--当鼠标点击切换城市时dl显示 style="display:block;"-->
     <dl style="display:none;">
         <dd>
            <span class="span03">热门出发城市</span>
            <span class="span02">
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
            </span>
         </dd>
         <dd>
            <span class="span03">其他出发城市</span>
            <span class="span02">
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
              <a href="javascript:void(0)" class="blue">北京</a>
            </span>
         </dd>
     </dl>
   </div>
</div>

<div class="pdnr">
    <div class="left">
    	<!-- 
       <div class="lxzn mt25">
       		
             <ul class="clearfix">
                <li id="one1" onclick="setTab('one',1,3)" class="active"><strong>全部路线</strong></li>
                <li id="one2" onclick="setTab('one',2,3)" ><strong>跟团游</strong><span class="f12">（19）</span></li>
                <li id="one3" onclick="setTab('one',3,3)" ><strong>自由行</strong>[机票+酒店]<span class="f12">（1）</span></li>
             </ul>
            
             <div id="con_one_1"  class="lx01" style="display:block;">
                  <dl>
                      <dt>共找到<span class="red">2</span>条结果。<span class="gray pl30">您已选择：</span><a href="#" class="a1">包含地区：<em class="green">大连</em><i></i></a><a href="#" class="a1">主题：<em class="green">滨海岛屿</em><i></i></a><a href="#" class="blue">清空全部</a></dt>
                      <dd class="clearfix">
                         <span class="span1">包含地区：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                         </span>
                      </dd>
                      <dd class="clearfix">
                         <span class="span1">包含地区：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                         </span>
                      </dd>
                      <dd class="clearfix noline">
                         <span class="span1">包含地区：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                         </span>
                      </dd>
                  </dl>
             </div>
             <div id="con_one_2"  class="lx01" style="display:none">
                  <dl>
                      <dt>共找到<span class="red">2</span>条结果。<span class="gray pl30">您已选择：</span><a href="#" class="a1">包含地区：<em class="green">大连</em><i></i></a><a href="#" class="a1">主题：<em class="green">滨海岛屿</em><i></i></a><a href="#" class="blue">清空全部</a></dt>
                      <dd class="clearfix">
                         <span class="span1">游玩路线：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                         </span>
                      </dd>
                      <dd class="clearfix">
                         <span class="span1">主　　题：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                         </span>
                      </dd>
                      <dd class="clearfix noline">
                         <span class="span1">往返交通：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">飞机(1)</a>
                             <a href="#" class="blue">大巴(1)</a>
                             <a href="#" class="blue">火车(1)</a>
                         </span>
                      </dd>
                      <dd class="clearfix noline">
                         <span class="span1">游玩天数：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">5天(1)</a>
                             <a href="#" class="blue">3天(1)</a>
                         </span>
                      </dd>
                  </dl>
         </div>
             <div id="con_one_3"  class="lx01" style="display:none">
                  <dl>
                      <dt>共找到<span class="red">2</span>条结果。<span class="gray pl30">您已选择：</span><a href="#" class="a1">包含地区：<em class="green">大连</em><i></i></a><a href="#" class="a1">主题：<em class="green">滨海岛屿</em><i></i></a><a href="#" class="blue">清空全部</a></dt>
                      <dd class="clearfix">
                         <span class="span1">包含地区：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                         </span>
                      </dd>
                      <dd class="clearfix">
                         <span class="span1">包含地区：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                         </span>
                      </dd>
                      <dd class="clearfix noline">
                         <span class="span1">包含地区：</span>
                         <span class="span2">
                             <a href="#" class="a1">全部</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                             <a href="#" class="blue">普吉岛(1)</a>
                         </span>
                      </dd>
                  </dl>
             </div>
              
       </div>
       -->
       
       <div class="cttj mt15 clearfix">
            <a href="#" class="a1">诚途网推荐</a>
            <a href="#" class="a2">价格</a>
            <a href="#" class="a3">价格</a>
            <!-- 
            <span class="span01"><input type="text" value="最低价" /> - <input type="text" value="最高价" /></span>
            <span class="span02" style="display:none;"><input type="text" value="最低价" /> - <input type="text" value="最高价" /><br />
            <input type="button" class="input" value="确定" /></span>
            <span class="span03"><input name="" type="checkbox"  align="absmiddle"/>促销活动</span> -->
            <em><i>${currentPage}/${totalPage}</i>
            <c:if test="${totalCount > pageSize}">
	           	<c:if test="${currentPage > 1}">
							<a href='/search.htm?p=${currentPage-1}<c:if test="${!empty pid} ">&pid=${pid}</c:if><c:if test="${!empty cid} ">&cid=${cid}</c:if>'>上一页</a>
				</c:if>
            	<c:if test="${totalPage > currentPage}">
					<a href='/search.htm?p=${currentPage+1}<c:if test="${!empty pid} ">&pid=${pid}</c:if><c:if test="${!empty cid} ">&cid=${cid}</c:if>'>下一页</a>
				</c:if>
			</c:if>
            </em>
            <!-- 
            <div class="ss">
                <input type="text" value="在结果中搜索" class="in01" /> <input type="button" class="input" value="搜索" />
            </div>
             -->
       </div>
       <div class="nrzs">
       <c:forEach var="item" items="${proList}" varStatus="status">
           <dl class="clearfix">
           <c:choose>
			    <c:when test="${fn:indexOf(item.tour_images[0],'http')>-1}">
			    	<c:set var="subStartIndex" value="${fn:indexOf(item.tour_images[0],'/upload')}" />
			    	<c:set var="imgLength" value="${fn:length(item.tour_images[0])}" />
			     	<c:set var="img_url" value="${fn:substring(item.tour_images[0],subStartIndex,imgLength)}" />
			    </c:when>
			    <c:otherwise>
			    	<c:set var="img_url" value="${item.tour_images[0]}" />
			    </c:otherwise>
		   </c:choose>
           
               <dt><a href="${item.link_url }${item.pro_id}.html" target="_blank"><img src="${img_url}" /></a></dt>
               <dd class="dd1">
                   <span><a href="${item.link_url}${item.pro_id}.html" class="blue fb f16">${item.tour_title }</a></span>
                   <span class="orange">${item.sale_title }</span>
                   <span class="clearfix">
                   <c:forEach var="features" items="${item.feature_tag}">
                      <a href="javascript:void(0)" class="a1">${features }</a>
                   </c:forEach>
                   </span>
                   <span class="gray">${item.tour_commend }</span>
                   <span></span>
               </dd>
               <dd class="dd2">
                   <span class="orange">￥<strong class="f24">${item.member_price }</strong>起</span>
                   <span><em class="em"><i class="pl5 pr5">返</i><i class="i">30元</i></em></span>
                   <span class="sp01"></span>
                   <!-- 
                   <span class="gray">2365人付款</span>
                   <span><a href="#" class="blue">326条评论</a></span> -->
               </dd>
           </dl>
       </c:forEach>
           <div class="fy">
           	<c:if test="${totalCount > pageSize}">
	           	<c:if test="${currentPage > 1}">
							<a href='/search.htm?p=${currentPage-1}<c:if test="${!empty pid} ">&pid=${pid}</c:if><c:if test="${!empty cid} ">&cid=${cid}</c:if>'>上一页</a>
				</c:if>
				
				<c:forEach begin="0" end="${totalPage-1}" step="1" varStatus="p">
						<c:choose>
							<c:when test="${p.index+1 == currentPage}">
								<a href="javascript:void(0)" class="hover">${currentPage}</a>
							</c:when>
							<c:otherwise>
								<a href='/search.htm?p=${p.index+1 }<c:if test="${!empty pid} ">&pid=${pid}</c:if><c:if test="${!empty cid} ">&cid=${cid}</c:if>'>${p.index+1 }</a>
							</c:otherwise>
						</c:choose>
						
				</c:forEach>
				<c:if test="${totalPage > currentPage}">
					<a href='/search.htm?p=${currentPage+1}<c:if test="${!empty pid} ">&pid=${pid}</c:if><c:if test="${!empty cid} ">&cid=${cid}</c:if>'>下一页</a>
				</c:if>
				
           	</c:if>
           	</div>
       </div>
    </div>
    
    <div class="right">
        <div class="tgjx">
            <h3><strong class="f16 mr5">本期团购</strong><span class="f12">进行中</span></h3>
          <!-- 旅游团购 -->
          ${search_right_tuangou}
          <!-- 旅游团购 -->
            <div class="tr mt10"><a href="/" class="blue">跟多团购产品>></a></div>
        </div>
        
        <!-- 
        <div class="lysy mt25">
            <h3><strong class="f16 mr5">云南旅游首页</strong></h3>
            <p class="mt10">这块多彩的土地上聚居着彝、白、哈尼、傣、傈僳、纳西、瑶、景颇、布依、水、独龙等25个少数民族。走进云南，你就在不经意间走进了纳西族的东巴文化、大理的白族文化、傣族的贝页文化、彝族的贝玛文化……走进汇集了神话、歌舞、绘画、古乐的民俗风情。 <a href="#" class="blue">更多>></a></p>
        </div>
        
        <div class="lydp mt25">
            <h3><strong class="f16 mr5">云南点评</strong></h3>
              <dl class="clearfix pt10">
               <dt>
                   <span class="orange mt15 tc"><strong class="f24">4.22</strong>分</span>
                   <span></span>
                   <span class="mt10 f12 tc"><a href="#" class="blue">69条评论</a></span>
               </dt>
               <dd>
                  <span>人气：4.16分</span>
                  <span>规模：4.07分</span>
                  <span>观光：4.12分</span>
                  <span>服务：3.94分</span>
               </dd>
            </dl>
        </div>
        
        <div class="lygl mt25">
            <h3><strong class="f16 mr5">旅游攻略</strong></h3>
            <dl class="mt10">
               <dt class="clearfix">
                   <img src="images/4.jpg" />
                   <span>攻略版本：<br />第五版</span>
                   <span>更新时间：<br />2014-5-21</span>
                   <span><a href="#">去下载</a></span>
               </dt>
               <dd>
                   <span><a href="#">丽江有什么好玩的</a></span>
                   <span class="gray">2014-07-08<em class="pl30">浏览391次</em></span>
               </dd>
               <dd>
                   <span><a href="#">丽江有什么好玩的</a></span>
                   <span class="gray">2014-07-08<em class="pl30">浏览391次</em></span>
               </dd>
               <dd>
                   <span><a href="#">丽江有什么好玩的</a></span>
                   <span class="gray">2014-07-08<em class="pl30">浏览391次</em></span>
               </dd>
               <dd>
                   <span><a href="#">丽江有什么好玩的</a></span>
                   <span class="gray">2014-07-08<em class="pl30">浏览391次</em></span>
               </dd>
            </dl>
        </div>
         -->
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
