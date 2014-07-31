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
    	<input id="addVisitTag" type="button" class="button button-small" value="添加目的地"/>
    </div>
    <p></p>
 </div>
 
<div align="left" style="margin-left: 25px;">当前位置：${vparent_name} &nbsp;&nbsp;<a href="vparentList.htm">返回上一级</a></div>
<div align="center">
	<ul id="proTypeDiv" style="width: 950px;height: 650px;text-align: left;background: #ccc;">
	<c:if test="${empty tagList}">
			<li class="liHi">
				列表暂时没有信息
			</li>
	  </c:if>
	<c:forEach var="item" items="${tagList}" varStatus="status">
		<c:if test="${!empty item}">
			<li class="liHi">
			<a href="javascript:alert('${item.visit_id}')">
				${item.visit_name}</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" onclick="showEditDIV('${item.visit_id}','${item.visit_name}')">编辑</a>|
			<a href="javascript:void(0)" onclick="toAction('delVisitTag.htm?vparent_id=${vparent_id}&visit_id=${item.visit_id}')">删除</a>
			</li>
		</c:if>
	</c:forEach>
	</ul>
</div>
<!-- 
<div align="center">
	<ul id="proTypeDiv" style="width: 650px;height: 650px;text-align: left;background: gray;"></ul>
</div> -->

<!-- 展示编辑层 -->
 <div id="editVisitTagDIV" style="text-align: center;height: 200px; display:none;">
        <div style="background-color:#fff; z-index:19891015;" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addVParentTag.htm" id="addVParentForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 10px; position: relative;line-height: 12px; color:#666; text-align: center;">
							<label style="font-size: 18px;font-weight: bold; ">修改目的地名称</label>
						</li>
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>当前名称：</label>
							<input type="text" id="edit_name" name="edit_name" 
							style="width: 270px;height:25px ;font-size:22px; padding-top: 8px;" autocomplete="off"/>
							<input type="hidden" id="edit_id" name="edit_id" value="0"/>
							<input type="hidden" id="current_name" name="current_name" value="0"/>
						</li>
						<li style="text-align: center;margin-top: 22px;">
							<input class="BB_button" onclick="return editVisitTag('${vparent_id}')" value="提交修改" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">关闭弹窗</a>
							<span class="from_msg" id="checkVPMsg" style="text-align: right;">&nbsp;</span></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!-- end -->

<!-- 添加二级目的地层 -->
<div id="addVisitTaglayer" style="text-align: center;height: 300px; display:none;">
        <div style="background-color:#fff; z-index:19891015;" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addProType.htm" id="addProTypeForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 10px; position: relative;line-height: 12px; color:#666; text-align: left;">
							&nbsp;一级菜单是：${vparent_name}<input type="hidden" id="vparent_id" name="vparent_id" value="${vparent_id}"/>
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

function showEditDIV(visit_id,visit_name){
	$.blockUI({ message: $('#editVisitTagDIV'),			
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
	$('#edit_name').val(visit_name);
	$('#edit_id').val(visit_id);
	$('#current_name').val(visit_name);
	
}

$('#addVisitTag').on('click', function(){
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


$(document).ready(function() {
	
});

</script>
<script type="text/javascript" src="/js/adminJS/visitTag.js"></script>
</body>
</html>