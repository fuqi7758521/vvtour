<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title>网站相册</title>
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
      <input id="popAddAlbum" type="button" class="button button-small" value="添加相册"/>
    </div>
    <p></p>
    <div class="row span24">
      <c:if test="${empty albumList}">
			列表暂时没有信息
	  </c:if>
	  <c:forEach var="item" items="${albumList}" varStatus="status">
			${item.album_name}，${item.album_comment}， ${item.picture_count}，<a href="picture_list.htm?album_id=${item.album_id}">进入相册</a>|<a href="">编辑相册</a><br/>
	</c:forEach>
    </div>
</div>
<!-- 添加菜单层 -->
 <div id="addAlbumlayer" style="text-align: center;height: 290px; display:none;">
        <div style="background-color:#fff; z-index:19891015" class="xubox_main">
		<div class="xubox_page">
			<div class="xuboxPageHtml" id="xuboxPageHtml1">
				<form action="addAlbum.htm" id="addAlbumForm" method="post">
					<ul class="formLib" style="margin-top: 20px;margin-left: 50px;width: 400px;height:220px; ">
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>相册名：</label>
							<input type="text" id="album_name" name="album_name" maxlength="6" style="width: 170px;font-size: 16px;" onchange="return checkAlbumNameExist" placeholder="2-6位汉字、字母、数字组成" autocomplete="off" />
							<span class="from_msg" id="checkMsg" style="text-align: right;">&nbsp;</span>
						</li>
						<!-- 
						<li style="text-align: left; line-height: 35px;">
							<label>描&nbsp;&nbsp;述：</label>
							<textarea id="album_comment" name="album_comment" style="width: 182px;height: 50px;" placeholder="相册描述"></textarea>
							<span class="from_msg" id="checkCnMsg" style="text-align: left;">&nbsp;</span>
						</li> -->
						<li style="margin-bottom: 20px; position: relative;line-height: 22px; text-align: left;">
							<label>相册类型：</label>
							<select name="album_type" id="album_type" style="height:120px;font-size: 16px;"  size="6">
								<option value="china">国内</option>
								<option value="bj_around">北京周边</option>
								<option value="h_m_t">港澳台</option>
								<option value="madai">马尔代夫</option>
								<option value="island">海岛图</option>
								<option value="aoxink">澳新凯</option>
								<option value="asia">亚洲</option>
								<option value="europe">欧洲</option>
								<option value="america">美洲</option>
								<option value="africa">中东非洲</option>
								<option value="ad">广告图</option>
							</select>
						</li>
						<li style="text-align: center;margin-top: 22px;">
							<input class="BB_button" id="submitAlbum" onclick="return addAlbumName()" value="提交" type="button"><span class="from_msg"><a href="javascript:void(0)" onclick="closeLayer()">关闭弹窗</a></span>
						</li>
					</ul>
				</form>
		</div>
		</div>
		</div>
</div>
<!-- 添加菜单层 -->
<script type="text/javascript">
$('#popAddAlbum').on('click', function(){
	 $.blockUI({ message: $('#addAlbumlayer'),			
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
<script type="text/javascript" src="/js/adminJS/album.js"></script>
</body>
</html>