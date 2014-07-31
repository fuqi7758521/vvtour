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
	<script type="text/javascript" src="/js/layer/layer.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row span24">
      <input id="popAddMenu" type="button" class="button button-small" value="添加管理菜单"/>
    </div>
    <!-- 添加菜单层 -->
    <div id="addMenuLayer" style="display:none;">
	<form action="<c:url value="doLogin.htm"/>" id="addMenuForm" method="post">
			<ul class="formLib">
				<li class="form_lilib">
					<label>英文名称：</label>
					<input type="text" id="menu_name" name="menu_name" onchange="return checkUserNameExist();" placeholder="英文管理菜单名称" autocomplete="off"/>
					<span id="ajaxMsg" class="from_msg">&nbsp;</span>
				</li>
				<li class="form_lilib">
					<label>中文名称：</label>
					<input type="text" id="menu_cnname" name="menu_cnname" placeholder="中文管理菜单名称">
				</li>
				<li class="form_libtn form_regtn">
					<!-- <input type="submit" class="BB_button" value="添加"><span class="from_msg"></span> -->
					<input type="button" id="closeBtn" onclick="closeLayer()" class="BB_button" value="关闭"><span class="from_msg"></span>
				</li>
			</ul>
	</form>
	</div>
	<!-- 添加菜单层 -->
</div>
<script type="text/javascript">
var loginhtml, validation = function(){
    //验证写在这
    $('.BB_button').on('click', function(){
    	alert(1);
        return false; //此处只作演示
    });
};
var page = {};
layer.login = function(options){
    options = options || {};
    addIndex=$.layer({
        type: 1,
        title: '添加管理',
        offset: [($(window).height() - 600)/2+'px', ''],
        border : [5, 0.5, '#666'],
        area: ['450px','290px'],
        shadeClose: true,
        page: page
    });
};
$('#popAddMenu').on('click', function(){
    //如果已经请求过，则直接读取缓存节点
    if(loginhtml){
        page.html = loginhtml;
    } else {
        page.html = $('#addMenuLayer').html();
        page.ok = function(datas){
            loginhtml = datas; //保存登录节点
            validation();
        }
    }
    layer.login();    
});
function closeLayer(){
	layer.close(addIndex);
}
</script>
<script type="text/javascript" src="/js/adminJS/menu.js"></script>
<body>
</html>  