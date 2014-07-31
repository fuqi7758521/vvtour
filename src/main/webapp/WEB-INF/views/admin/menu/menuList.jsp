<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>权限管理列表</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link href="/js/admin/css/dpl-min.css" rel="stylesheet" type="text/css" />
   <link href="/js/admin/css/page-min.css" rel="stylesheet" type="text/css" />
   <link href="/css/layer.css" rel="stylesheet" type="text/css" />
   <style type="text/css">
    code {
      padding: 0px 4px;
      color: #d14;
      background-color: #f7f7f9;
      border: 1px solid #e1e1e8;
    }

   </style>
	<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
	<script type="text/javascript" src="/js/layer/layer.min.js"></script>
	<script type="text/javascript" src="/js/basic.js"></script>
</head>
<body>
<div class="container">
    <div class="row span24">
      <input id="popAddMenu" type="button" class="button button-small" value="添加管理菜单"/>
    </div>
    
</div>
<!-- 添加菜单层 -->
 <div id="addMenulayer" style="text-align: center;height: 290px; display:none;">
        <div style="background-color:#fff; z-index:19891015" class="xubox_main">
		<div style="top: 36px;" class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addMenu.htm" id="addMenuForm" method="post">
					<ul class="formLib">
						<li class="form_lilib">
							<label>英文名：</label>
							<input type="text" id="menu_name" name="menu_name" onchange="return checkUserNameExist();" placeholder="管理菜单英文名" autocomplete="off"/>
							<span class="from_msg" id="checkMsg" style="width:110px;text-align: left;">请填写管理菜单名称</span>
						</li>
						<li class="form_lilib">
							<label>中文名：</label>
							<input type="text" id="menu_cnname" name="menu_cnname" placeholder="管理菜单中文名"/>
							<span class="from_msg" id="checkCnMsg" style="width:110px;text-align: left;">请填写管理菜单名称</span>
						</li>
						<li class="form_libtn form_regtn">
							<input class="BB_button" id="submitMenu" onclick="return addMenuName()" value="添加" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">取消添加</a></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!-- 添加菜单层 -->
<script type="text/javascript">
$('#popAddMenu').on('click', function(){
	 $.blockUI({ message: $('#addMenulayer'),			
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
</script>
<script type="text/javascript" src="/js/adminJS/menu.js"></script>
</body>
</html>