<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/pager-taglib.tld" prefix="pg" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理首页</title>
<style type="text/css">
#Container{
    width:1000px;
    margin:0 auto;/*设置整个容器在浏览器中水平居中*/
    background:#fff;
}
#Header{
    height:80px;
    background:#093;
}
#logo{
    padding-left:50px;
    padding-top:20px;
    padding-bottom:50px;
}
#Content{
    height:800px;
    /*此处对容器设置了高度，一般不建议对容器设置高度，一般使用overflow:auto;属性设置容器根据内容自适应高度，如果不指定高度或不设置自适应高度，容器将默认为1个字符高度，容器下方的布局元素（footer）设置margin-top:属性将无效*/
    margin-top:20px;/*此处讲解margin的用法，设置content与上面header元素之间的距离*/
    /*background:#0FF;*/
   
}
#Content-Left{
    height:400px;
    width:150px;
    /*margin:20px;设置元素跟其他元素的距离为20像素*/
    margin-right:10px;
    float:left;/*设置浮动，实现多列效果，div+Css布局中很重要的*/
    /*background:#90C;*/
    border-color:#c5c6c4; border-style:solid; border-width:1px 1px 1px 1px;
}
#Content-Left h1 { 
	margin:0px; 
	padding:4px; /*Padding属性用于设置一个元素的边框与其内容的距离。*/
	font-size:12px; 
	font-weight:bold; 
	font-family:Verdana; 
	border-top:1px solid #c5c6c4; 
	background-color:#CCCCCC;
}
#Content-Left h2 { 
	margin:0px; 
	padding:4px; 
	font-size:12px; 
	font-family:Verdana; 
	font-weight:normal;
}
#Content-Left h2 a { 
	color:#666666; 
	text-decoration:none;
}
#Content-Left h2 a:hover { 
	color:#0000FF; 
	text-decoration:underline;
}
#Content-Main{
    height:100%;
    width:826px;
    /*margin:20px;设置元素跟其他元素的距离为20像素*/
    margin-left:10px;
    float:left;/*设置浮动，实现多列效果，div+Css布局中很重要的*/
    background:#f1f1f1;/**/
    border-color:#c5c6c4; border-style:solid; border-width:1px 1px 1px 1px;
    font-size:12px; font-family:Tahoma; color:#000000; 
}

.title_h2{
	background:url(../images/s_ico.jpg) no-repeat left center;
	padding:10px 0px 10px 30px;
	margin-left:10px;
	font-size:14px;
	font-weight:bold;	
}

/*注：Content-Left和Content-Main元素是Content元素的子元素，两个元素使用了float:left;设置成两列，这个两个元素的宽度和这个两个元素设置的padding、margin的和一定不能大于父层Content元素的宽度，否则设置列将失败*/
#Footer{
    height:40px;
    background:#90C;
    margin-top:20px;
}
.Clear{
    clear:both;/* 使用Float属性设置一行有多个DIV后（多列），最好在下一行开始之前使用Clear属性清除一下浮动，否则上面的布局会影响到下面。*/
}
.line{
	height:1px;
	width:97%;
	border-top:1px solid #dfdfdf;
	background:#fff;
	margin:10px auto;
	overflow:hidden;
}
.filed label{
	position:absolute;
	padding:6px 3px 6px 0px;
}
.filed input {
	margin-left:50px;
	padding:3px;
	border-top:1px solid #bebebe;
	border-left:1px solid #bebebe;
	border-right:1px solid #e1e1e1;
	border-bottom:1px solid #e1e1e1;
	background:url(../images/input_bg.jpg) repeat-x 0 0;
	margin-right:10px;
}
.filed .button{
	width:66px;
	height:30px;
	border:none;
	margin:0;
	padding:0;
	margin-top:-4px;
	background:url(../images/button_s.jpg) no-repeat 0 0;
}
.fl{
	float:left;
}
.table{
	clear:both;
	margin:10px auto;
	width:100%;
	border:1px solid #d6d6d6;
	border-collapse:collapse;

}
.table th{
	text-align:left;
	border-top:1px solid #dfdfdf;
	padding:5px;
	background:#f1f1f1;
	padding-left:15px;
}
.table td{
	border-top:1px solid #dfdfdf;
	padding:8px;
	padding-left:15px;
	background:#fff;
}
.table th.top_th a{
	float:left;
	overflow:hidden;
	width:40px;
}
.table th.top_th{
	background:url(../images/table_th.jpg) repeat-x 0 0;
	line-height:31px;
	height:31px;
	padding:0;
}
.page p span{
	text-decoration:underline;
}
.page ul{
	float:right;
}
.page ul li{
	float:left;
	padding:3px;
}
.page ul li a {
	display:block;
	background:url(../images/page_bg.jpg) no-repeat 0 0;
	padding:1px 3px 1px 3px;
	border:1px solid #a3a3a3;
	color:#000;
}
.page ul li a.pg_selected{
	color:#fff;
	border:1px solid #245b8e;
	background:#417eb7;
}
.page p{
	padding:3px;
}
.page a.pg_next,.page .pg_index,.page .pg_last{
	border:none;
	background:none;
	line-height:19px;
	_line-height:17px;
}
.table th a{
	padding:2px 3px 1px 23px;
	float:left;
	line-height:28px;
	color:#333;
	font-weight:200;
	
}
.table th a em{
	float:left;
	font-style: normal;
}
.table th a span{
	background:url(../images/line_line.jpg) no-repeat right center;
	width:10px;
	height:24px;
	float:right;
	display:block;
	
}
.table .add{
	background:url(../images/add_ico_.jpg) no-repeat 0 center;
}
.table .edit{
	background:url(../images/edit_ico.jpg) no-repeat 0 center;
}
.table .tongji{
	background:url(../images/tj_ico_.jpg) no-repeat 0 center;
}
.table .sort{
	background:url(../images/sort_ico.jpg) no-repeat 0 center;
}
.table .sort span{
	background:none;
}
.tablelist{padding-top:23px;}
.content_body ul li{margin-bottom:15px;}
.content_body ul li span{margin-right:20px;}
</style>
<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
<script type="text/javascript">
function popWaitGen(){
	$.blockUI({ message: "生成中，请稍后...<img src='/../images/loading_32_32.gif'/>",
	}); 
}

$('#div_mask').block({message:'<img src="/../images/loading_32_32.gif"/>'});
</script>
</head>
<body>
<div id="Container">
    <div id="Header">
        <div id="logo">这里设置了padding属性介绍一下padding的用法,padding将设置文本与边框的距离。</div>
    </div>
    <div id="Content">
        <div id="Content-Left">
			<h1>CSS</h1>
		        <h2><a href="javascript:void(0)" onclick="popWaitGen()">css入门</a></h2>
		        <h2><a href="#" id="div_mask">css进阶</a></h2>
		        <h2><a href="#">css高级</a></h2>
		    <h1>webUI</h1>
		        <h2><a href="#">理论知识</a></h2>
		        <h2><a href="#">实战应用</a></h2>
		        <h2><a href="#">高级技巧</a></h2>
		    <h1>DOM</h1>
		        <h2><a href="#">DOM入门</a></h2>
		        <h2><a href="#">DOM应用</a></h2>
		        <h2><a href="#">DOM与浏览器</a></h2>
		    <h1>XHTML</h1>
		        <h2><a href="#">参考手册</a></h2>
		        <h2><a href="#">交流论坛</a></h2>
		</div>
        <div id="Content-Main" class="content_body">
			<ul userid="${user.userId }">
				<li><span>用户名:</span><span>${user.username }</span></li>
				<li><span>邮箱:</span><span>${user.email }</span></li>
				<li><span>手机号:</span><span>${user.mobile }</span></li>
				<li><span>性别:</span>
					<span>
						<c:if test="${user.sex==1 }">男</c:if>
						<c:if test="${user.sex==0 }">女</c:if>
					</span>
				</li>
				<li><span>最近登录时间:</span><span>${user.lastLoginDateStr }</span></li>
				<li><span>状态:</span>
					<span>
						<c:if test="${user.status==0 }">正常</c:if>
						<c:if test="${user.status==-1 }">屏蔽</c:if>
						<c:if test="${user.status==-2 }">删除</c:if>
					</span>
				</li>
				<li>
					<a href="javascript:;" onclick="ban(this)">屏蔽</a> 
				    <a href="javascript:;" onclick="removeUser(this)">删除</a> 
				    <a href="javascript:;" onclick="recovery(this)">恢复</a>
				    <a href="<%=request.getContextPath() %>/admin/user/list.htm">返回列表</a>
				 </li>
			</ul>
		</div>
    </div>
    <div class="Clear"><!--如何你上面用到float,下面布局开始前最好清除一下。--></div>
    <div id="Footer">Footer</div>
</div>
<script src="<%=request.getContextPath() %>/front/static/js/jquery-1.7.2.js"></script>
<script>
function ban(obj){
	var $this = $(obj);
	var userId = $this.parent().parent().attr("userid");
	updateUserStatus(userId,-1);
}

function removeUser(obj){
	var $this = $(obj);
	var userId = $this.parent().parent().attr("userid");
	updateUserStatus(userId,-2);
}

function recovery(obj){
	var $this = $(obj);
	var userId = $this.parent().parent().attr("userid");
	updateUserStatus(userId,0);
}

function updateUserStatus(userId, status){
	var url = "<%=request.getContextPath() %>/admin/user/modifyStatus.htm";
	$.post(url, {userId:userId,status:status}, function(result){
		alert(result.msg);
	});
}
</script>
</body>
</html>