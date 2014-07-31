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
body,ul,li{margin: 0;padding: 0;font: 12px normal "宋体", Arial, Helvetica, sans-serif;list-style: none;}
/*------------分页------------*/
.page{padding:24px 0;height:36px;line-height:34px;font-size:14px;text-align:right}
.page a{display:inline-block;border:#e2e2e2 1px solid;padding:0 16px;height:36px}
.page a:hover,.page a.on{background:#248cff;color:#fff;border:#cde6ff 1px solid; text-decoration:none}
.page span{display:inline-block;padding:0 16px}

   </style>
	<script type="text/javascript" src="/js/jquery/jquery-1.8.1.min.js"></script>
	<script type="text/javascript" src="/js/jquery/jquery.blockUI.js"></script>
	<script type="text/javascript" src="/js/layer/layer.min.js"></script>
	<script type="text/javascript" src="/js/basic.js"></script>
</head>
<body>
<div align="center">
	<div style="width: 822px;margin-top: 20px;" align="left" >
	   <div style="float: left;width: 120px;display:inline;">
      	<input id="popAddAlbum" type="button" style="height: 25px;width: 120px;" value="添加相册"/>
      </div>
    </div>
    <div class="page" style="width:822px;display:inline;padding-left: 50px;">
      	<a href="/admin/album_list.htm?album_type=china">国内</a>&nbsp;<a href="/admin/album_list.htm?album_type=bj_around">北京周边</a>&nbsp;<a href="/admin/album_list.htm?album_type=h_m_t">港澳台</a>
      	<a href="/admin/album_list.htm?album_type=madai">马尔代夫</a>&nbsp;<a href="/admin/album_list.htm?album_type=island">海岛图</a>&nbsp;<a href="/admin/album_list.htm?album_type=aoxink">澳新凯</a>
      	<a href="/admin/album_list.htm?album_type=asia">亚洲</a>&nbsp;<a href="/admin/album_list.htm?album_type=europe">欧洲</a>&nbsp;<a href="/admin/album_list.htm?album_type=america">美洲</a>
      	<a href="/admin/album_list.htm?album_type=africa">中东非洲</a>&nbsp;<a href="/admin/album_list.htm?album_type=ad">广告图</a>&nbsp;<a href="/admin/album_list.htm">全部</a>
      </div>
    <div>
      <table cellpadding="0" cellspacing="0" border="1" bordercolor="#c4c4c4" width="822px">
      	<tbody>
      	<tr style="line-height: 25px;font-size: 14px;">
      		<td><a href="javascript:void(0)" onclick="checkAll(this)">全选</a></td>
      		<td align="center" width="125px;">相册名称</td>
      		<td>所属类型</td>
      		<td colspan="3">编辑</td>
      	</tr>
      	<c:if test="${empty albumList}">
			<tr style="line-height: 30px;">
				<td colspan="6">列表暂时没有信息</td>
			</tr>
	 	</c:if>
      	<c:forEach var="item" items="${albumList}" varStatus="status">
      	<tr style="line-height: 30px;">
      		<td><input type="checkbox" name="album_id" value="${item.album_id }"/></td>
      		<td>${item.album_name }</td>
      		<td>
      			<c:if test="${item.album_type == 'china' }">国内</c:if>
				<c:if test="${item.album_type == 'bj_around' }">北京周边</c:if>
				<c:if test="${item.album_type == 'h_m_t' }">港澳台</c:if>
				<c:if test="${item.album_type == 'madai' }">马尔代夫</c:if>
				<c:if test="${item.album_type == 'island' }">海岛图</c:if>
				<c:if test="${item.album_type == 'aoxink' }">澳新凯</c:if>
				<c:if test="${item.album_type == 'asia' }">亚洲</c:if>
				<c:if test="${item.album_type == 'europe' }">欧洲</c:if>
				<c:if test="${item.album_type == 'america' }">美洲</c:if>
				<c:if test="${item.album_type == 'africa' }">中东非洲</c:if>
				<c:if test="${item.album_type == 'ad' }">广告图</c:if>
      		</td>
      		<td><a href="picture_list.htm?album_id=${item.album_id}">进入相册</a></td>
      		<td><a href="javascript:void(0)">编辑</a></td>
      		<td><a href="javascript:alert('${item.album_id }')">删除</a></td>
      	</tr>
      	</c:forEach>
      	</tbody>
      </table>
      <!--分页 start{-->
      <div class="page" style="width: 820px;">
	       <c:if test="${totalCount > pageSize}">
					<a href="/admin/album_list.htm">首页</a>
					<c:if test="${currentPage > 1}">
						<a href='/admin/album_list.htm?p=${currentPage-1}<c:if test="${!empty album_type} ">&album_type=${album_type}</c:if>'>上一页</a>
					</c:if>
					<c:forEach begin="0" end="${totalPage-1}" step="1" varStatus="p">
						<c:choose>
							<c:when test="${p.index+1 == currentPage}">
								<a href="javascript:void(0)" class="on">${currentPage}</a>
							</c:when>
							<c:otherwise>
								<a href='/admin/album_list.htm?p=${p.index+1 }<c:if test="${!empty album_type} ">&album_type=${album_type}</c:if>'>${p.index+1 }</a>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
					<c:if test="${totalPage > currentPage}">
						<a href='/admin/album_list.htm?p=${currentPage+1}<c:if test="${!empty album_type} ">&album_type=${album_type}</c:if>'>下一页</a>
					</c:if>
		    </c:if>
      </div>
      <!--}分页 end-->
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
							<input type="text" id="album_name" name="album_name" maxlength="10" style="width: 170px;font-size: 16px;" onchange="return checkAlbumNameExist()" placeholder="2-6位汉字、字母、数字组成" autocomplete="off" />
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
			backgroundColor:'#fff'
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