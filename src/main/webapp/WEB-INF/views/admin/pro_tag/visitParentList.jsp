<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>一级菜单管理</title>
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
<style type="text/css">
    .liHi {
      margin-left: 20px;
      line-height: 22px;
      font-size: 16px;
      font-family: 微软雅黑;
    }

</style>
<div class="container">
    <div class="row span24">
      <input id="addVisitParent" type="button" class="button button-small" value="添加一级菜单"/>&nbsp;&nbsp;
    	<input id="addVisitTag" type="button" class="button button-small" value="添加二级菜单"/>
    </div>
    <p></p>
 </div>
<div align="center">
	<ul id="proTypeDiv" style="width: 950px;height: 650px;text-align: left;background: #ccc;">
	<c:if test="${empty vparentList}">
	<input type="hidden" name="isHave" id="isHave" value="-1"/>
			<li class="liHi">
				列表暂时没有信息
			</li>
	  </c:if>
	<c:forEach var="item" items="${vparentList}" varStatus="status">
		<li class="liHi">
			<a href="visitTagList.htm?vparent_id=${item.vparent_id}">
				${item.vparent_name}</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)">编辑</a>|<a href="javascript:void(0)">删除</a></li>
	</c:forEach>
	</ul>
</div>
<!-- 
<div align="center">
	<ul id="proTypeDiv" style="width: 650px;height: 650px;text-align: left;background: gray;"></ul>
</div> -->
<!-- 一级添加菜单层 -->
 <div id="addVisitParentlayer" style="text-align: center;height: 300px; display:none;">
        <div style="background-color:#fff; z-index:19891015;" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addVParentTag.htm" id="addVParentForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 10px; position: relative;line-height: 12px; color:#666; text-align: center;">
							<label>例如：北京周边，欧洲，美洲，日本 ，选择类型：
							<select id="vparent_type" name="vparent_type" style="width: 65px;">
							<option value="domestic">国内游</option>
							<option value="abroad">出境游</option>
							</select></label>
						</li>
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>菜单名称：</label>
							<textarea id="vparent_name" name="vparent_name" style="height:100px;width: 300px;"></textarea><br/>请填写一级菜单，多个菜单请使用英文逗号, 隔开。
						</li>
						<li style="text-align: center;margin-top: 22px;">
							<input class="BB_button" id="submitVParentTag" onclick="return addVParentTag()" value="添加" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">关闭弹窗</a>
							<br/><span class="from_msg" id="checkVPMsg" style="text-align: right;">&nbsp;</span></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!-- 添加菜单层 -->

<!-- 二级添加目的地层 -->
<div id="addVisitTaglayer" style="text-align: center;height: 300px; display:none;">
        <div style="background-color:#fff; z-index:19891015;" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addProType.htm" id="addProTypeForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 10px; position: relative;line-height: 12px; color:#666; text-align: left;">
							<label>选择一级菜单：</label>
							<select name="vparent_id" id="vparent_id">
								<c:forEach var="item_s" items="${vparentList}" varStatus="status">
									<option value="${item_s.vparent_id}">${item_s.vparent_name}</option>
								</c:forEach>
							</select>
						</li>
						<li>&nbsp;</li>
						<li style="margin-bottom: 20px; position: relative;line-height: 22px;color:#666; text-align: left;">
							<label>名称：</label>
							<textarea id="visit_name" name="visit_name" style="height:100px;width: 300px;"></textarea>
							<!-- <input type="text" id="visit_name" name="visit_name" 
							style="width: 270px;height:25px ;font-size:22px; padding-top: 8px;" autocomplete="off"/> --><br/>
							请填写旅游目的地名称，多个目的地请使用英文逗号, 隔开。
						</li>
						<li style="text-align: center;margin-top: 22px;">
							<input class="BB_button" id="submitVisitTag" onclick="return addVisitTag()" value="添加" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">关闭弹窗</a>
							<span class="from_msg" id="checkMsg" style="text-align: right;">&nbsp;</span></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!--  -->
<script type="text/javascript">
$('#addVisitParent').on('click', function(){
	 $.blockUI({ message: $('#addVisitParentlayer'),			
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
$('#addVisitTag').on('click', function(){
	if($('#isHave').val()==-1){
		alert("一级菜单还没有内容，请先添加");
		return false;
	}
	 $.blockUI({ message: $('#addVisitTaglayer'),			
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
function initVisiTag()
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
<script type="text/javascript" src="/js/adminJS/visitTag.js"></script>
</body>
</html>