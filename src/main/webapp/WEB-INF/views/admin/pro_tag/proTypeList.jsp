<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>网站相册</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <META HTTP-EQUIV="pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT= "no-cache, must-revalidate"> 
<META HTTP-EQUIV="expires" CONTENT= "Wed, 26 Feb 1997 08:21:57 GMT"> 
   <link href="/js/admin/css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="/js/admin/css/page-min.css" rel="stylesheet" type="text/css" />
   <link href="/css/layer.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
	<script type="text/javascript" src="/js/layer/layer.min.js"></script>
	<script type="text/javascript" src="/js/basic.js"></script>
</head>
<body>
<div class="container">
    <div class="row span24">
      <input id="addProType" type="button" class="button button-small" value="添加产品类型"/>
    </div>
    <p></p>
    <div class="row span24">
    ${errorMsg}
    </div>
    <div class="row span24">
      <c:if test="${empty albumList}">
			列表暂时没有信息
	  </c:if>
	  <c:forEach var="item" items="${albumList}" varStatus="status">
			${item.album_name}，${item.album_comment}， ${item.picture_count}，<a href="picture_list.htm?album_id=${item.album_id}">进入相册</a>|<a href="">编辑相册</a><br/>
	</c:forEach>
    </div>
</div>
<style type="text/css">
    .liHi {
      margin-left: 20px;
      line-height: 22px;
      font-size: 16px;
      font-family: 微软雅黑;
    }

</style>
<div align="center">
	<ul id="proTypeDiv" style="width: 950px;height: 650px;text-align: left;background: #ccc;">
	<c:forEach var="item" items="${typeList}" varStatus="status">
		<li class="liHi">
			<a href="javascript:alert('${item.ptype_id}')">
				${item.ptype_name}</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)">编辑</a>|<a href="javascript:void(0)">删除</a></li>
	</c:forEach>
	</ul>
</div>
<!-- 
<div align="center">
	<ul id="proTypeDiv" style="width: 650px;height: 650px;text-align: left;background: gray;"></ul>
</div> -->
<!-- 添加菜单层 -->
 <div id="addProTypelayer" style="text-align: center;height: 200px; display:none;">
        <div style="background-color:#fff; z-index:19891015;" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addProType.htm" id="addProTypeForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 10px; position: relative;line-height: 12px; color:#666; text-align: center;">
							<label>例如：国内游,出境游</label>
						</li>
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>产品类型：</label>
							<input type="text" id="ptype_name" name="ptype_name" 
							style="width: 270px;height:25px ;font-size:22px; padding-top: 8px;" autocomplete="off"/>
						</li>
						<li style="text-align: center;margin-top: 22px;">
							<input class="BB_button" id="submitProType" onclick="return addProType()" value="添加" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">关闭弹窗</a>
							<span class="from_msg" id="checkMsg" style="text-align: right;">&nbsp;</span></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!-- 添加菜单层 -->
<script type="text/javascript">
$('#addProType').on('click', function(){
	 $.blockUI({ message: $('#addProTypelayer'),			
		 css: {
			padding:	0,
			margin:		0,
			width:		'450px',
			top:		'200px',
			left:		'35%',
			textAlign:	'center',
			color:		'#000',
			border:		'3px solid #aaa',
			backgroundColor:'#fff',
			cursor:		'wait'
		} 
	 });
	 
});
function closeLayer(){
	$.unblockUI();
}

//显示产品类型
function initProType()
{
	//原先的产品类型列表清空
	$('#proTypeDiv').html('');
	var proHTML = '';
	if("undefined" == typeof proType || proType.length < 1){
		proHTML = '<li class="liHi">暂时没有产品类型列表数据,请添加</li>';
		$('#proTypeDiv').html(proHTML);
	} else{
		for(i=0;i<proType.length;i++)
		{
			proHTML = '<li class="liHi"><a href="javascript:alert('+ proType[i].ptype_id +')">'
						+ proType[i].ptype_name +'</a>&nbsp;&nbsp;&nbsp;&nbsp;'
						+ '<a href="javascript:void(0)">编辑</a>|<a href="javascript:void(0)">删除</a></li>';
			$('#proTypeDiv').append(proHTML);
		}
	}
}

$(document).ready(function() {
	//initProType();
});

</script>
<script type="text/javascript" src="/js/adminJS/proTag.js"></script>
<script type="text/javascript" src="/js/pro_tag/proTypeData.js"></script>
</body>
</html>